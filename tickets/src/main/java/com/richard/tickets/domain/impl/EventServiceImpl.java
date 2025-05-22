package com.richard.tickets.domain.impl;

import com.richard.tickets.application.exceptions.UserNotFoundException;
import com.richard.tickets.domain.EventService;
import com.richard.tickets.infrastructure.persistence.entities.Event;
import com.richard.tickets.infrastructure.persistence.entities.User;
import com.richard.tickets.infrastructure.persistence.repositories.EventRepository;
import com.richard.tickets.infrastructure.persistence.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EventServiceImpl implements EventService {

    private final UserRepository userRepository;
    private final EventRepository eventRepository;

    @Override
    public Event createEvent(UUID organizedId, Event event) {

        User organizer = userRepository.findById(organizedId)
                .orElseThrow(() -> new UserNotFoundException(
                        String.format("Organizer with id %s not found", organizedId)
                ));

        event.setOrganizer(organizer);
        return eventRepository.save(event);
    }
}
