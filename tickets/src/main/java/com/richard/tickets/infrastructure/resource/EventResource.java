package com.richard.tickets.infrastructure.resource;

import com.richard.tickets.domain.EventService;
import com.richard.tickets.infrastructure.persistence.entities.Event;
import com.richard.tickets.infrastructure.resource.mapper.EventMapper;
import com.richard.tickets.infrastructure.resource.request.CreateEventRequest;
import com.richard.tickets.infrastructure.resource.response.CreateEventResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping(params = "/api/v1/events")
@RequiredArgsConstructor
public class EventResource {

    private final EventMapper eventMapper;
    private final EventService eventService;

    @PostMapping
    public ResponseEntity<CreateEventResponse> createEvent(
                                            @AuthenticationPrincipal Jwt jwt,
                                            @Valid @RequestBody CreateEventRequest request) {

        Event event = eventMapper.requetToEvent(request);
        UUID userId = UUID.fromString(jwt.getSubject());

        Event entity = eventService.createEvent(userId, event);

        CreateEventResponse createEventResponse = eventMapper.eventToEventResponse(entity);
        return new ResponseEntity<>(createEventResponse, HttpStatus.CREATED);
    }
}
