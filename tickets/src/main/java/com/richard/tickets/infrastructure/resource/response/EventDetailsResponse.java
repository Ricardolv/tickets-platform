package com.richard.tickets.infrastructure.resource.response;

import com.richard.tickets.infrastructure.persistence.entities.enums.EventStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class EventDetailsResponse {

    private UUID id;
    private String name;
    private LocalDateTime start;
    private LocalDateTime end;
    private String venue;
    private LocalDateTime salesStart;
    private LocalDateTime salesEnd;
    private EventStatusEnum status;
    private List<EventTicketTypesDetailsResponse> ticketTypes = new ArrayList<>();
    private LocalDate createdAt;
    private LocalDateTime updatedAt;

}
