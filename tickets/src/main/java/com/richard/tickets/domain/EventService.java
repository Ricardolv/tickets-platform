package com.richard.tickets.domain;

import com.richard.tickets.infrastructure.persistence.entities.Event;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public interface EventService {

    Event createEvent(UUID organizedId, Event event);
    Page<Event> listEventsForOrganizer(UUID organizedId, Pageable pageable);
    Optional<Event> findByIdAndOrganizerId(UUID id, UUID organizerId);
    Event updateEventForOrganizer(UUID organizedId, UUID id, Event event);

}
