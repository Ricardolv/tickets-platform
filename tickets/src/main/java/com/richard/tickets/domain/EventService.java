package com.richard.tickets.domain;

import com.richard.tickets.infrastructure.persistence.entities.Event;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public interface EventService {
    Event createEvent(UUID organizedId, Event event);
}
