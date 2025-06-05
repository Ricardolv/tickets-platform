package com.richard.tickets.domain.impl;

import com.richard.tickets.application.exceptions.EventNotFoundException;
import com.richard.tickets.application.exceptions.EventUpdateException;
import com.richard.tickets.application.exceptions.TickeTypeNotFoundException;
import com.richard.tickets.application.exceptions.UserNotFoundException;
import com.richard.tickets.domain.EventService;
import com.richard.tickets.infrastructure.persistence.entities.Event;
import com.richard.tickets.infrastructure.persistence.entities.TicketType;
import com.richard.tickets.infrastructure.persistence.entities.User;
import com.richard.tickets.infrastructure.persistence.repositories.EventRepository;
import com.richard.tickets.infrastructure.persistence.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

@Service
@RequiredArgsConstructor
public class EventServiceImpl implements EventService {

    private final UserRepository userRepository;
    private final EventRepository eventRepository;

    @Transactional
    @Override
    public Event createEvent(UUID organizedId, Event event) {

        User organizer = userRepository.findById(organizedId)
                .orElseThrow(() -> new UserNotFoundException(
                        String.format("Organizer with id %s not found", organizedId)
                ));

        event.setOrganizer(organizer);
        return eventRepository.save(event);
    }

    @Transactional
    @Override
    public Event updateEventForOrganizer(UUID organizedId, UUID id, Event event) {

        if (isNull(event.getId())) {
            throw  new EventUpdateException("Event ID cannot be null");
        }

        if (!event.getId().equals(id)) {
            throw  new EventUpdateException("CAnnot update the ID of an event");
        }

        User organizer = userRepository.findById(organizedId)
                .orElseThrow(() -> new UserNotFoundException(
                        String.format("Organizer with id %s not found", organizedId)
                ));

        Event existingEvent = eventRepository.findByIdAndOrganizerId(id, event.getId())
                .orElseThrow(() -> new EventNotFoundException(
                        String.format("Event with id %s does not exist", id)
                ));

        existingEvent.setName(event.getName());
        existingEvent.setStart(event.getStart());
        existingEvent.setEnd(event.getEnd());
        existingEvent.setVenue(event.getVenue());
        existingEvent.setSalesStart(event.getSalesStart());
        existingEvent.setSalesEnd(event.getSalesEnd());
        existingEvent.setStatus(event.getStatus());

        Set<UUID> ticketTypesIds = event.getTicketTypes()
                .stream()
                .map(TicketType::getId)
                .filter(Objects::nonNull)
                .collect(Collectors.toSet());

        existingEvent.getTicketTypes().removeIf(existingTicketType ->
                ticketTypesIds.contains(existingTicketType.getId())
        );

        Map<UUID, TicketType> existingTicketTypesIndex = existingEvent.getTicketTypes()
                .stream()
                .collect(Collectors.toMap(TicketType::getId, Function.identity()));

        for (TicketType ticketType : event.getTicketTypes()) {

            if (isNull(ticketType.getId())) {

                // Create
                ticketType.setEvent(existingEvent);
                existingEvent.getTicketTypes().add(ticketType);

            } else if (existingTicketTypesIndex.containsKey(ticketType.getId())) {

                // Update
                TicketType ticketTypeUpdate = existingTicketTypesIndex.get(ticketType.getId());
                ticketTypeUpdate.setEvent(existingEvent);
                existingEvent.getTicketTypes().add(ticketTypeUpdate);

            } else {
                throw new TickeTypeNotFoundException(
                        String.format("Ticket type with id %s does not exists", ticketType.getId()));
            }

        }

        return eventRepository.save(existingEvent);
    }

    @Transactional(readOnly = true)
    @Override
    public Page<Event> listEventsForOrganizer(UUID organizedId, Pageable pageable) {
        return eventRepository.findByOrganizerId(organizedId, pageable);
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Event> findByIdAndOrganizerId(UUID id, UUID organizerId) {
        return eventRepository.findByIdAndOrganizerId(id, organizerId);
    }

}
