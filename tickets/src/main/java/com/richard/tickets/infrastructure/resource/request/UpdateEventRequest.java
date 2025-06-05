package com.richard.tickets.infrastructure.resource.request;

import com.richard.tickets.infrastructure.persistence.entities.User;
import com.richard.tickets.infrastructure.persistence.entities.enums.EventStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateEventRequest {

    private UUID id;
    private String name;
    private LocalDateTime start;
    private LocalDateTime end;
    private String venue;
    private LocalDateTime salesStart;
    private LocalDateTime salesEnd;
    private EventStatusEnum status;
    private User organizer;
    private List<UpdateTicketTypeRequest> ticketTypes = new ArrayList<>();

}
