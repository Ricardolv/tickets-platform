package com.richard.tickets.infrastructure.resource.mapper;

import com.richard.tickets.infrastructure.persistence.entities.Event;
import com.richard.tickets.infrastructure.persistence.entities.TicketType;
import com.richard.tickets.infrastructure.resource.request.CreateEventRequest;
import com.richard.tickets.infrastructure.resource.request.CreateTicketTypeRequest;
import com.richard.tickets.infrastructure.resource.response.CreateEventResponse;
import com.richard.tickets.infrastructure.resource.response.CreateTicketTypeReponse;
import com.richard.tickets.infrastructure.resource.response.EventsResponse;
import com.richard.tickets.infrastructure.resource.response.EventsTicketTypeResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface EventMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "attendees", ignore = true)
    @Mapping(target = "staff", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    Event requetToEvent(CreateEventRequest request);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "event", ignore = true)
    @Mapping(target = "tickets", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    TicketType requetToEventTicketType(CreateTicketTypeRequest request);

    CreateEventResponse eventToEventResponse(Event event);
    CreateTicketTypeReponse ticketTypeToTicketTypeResponse(TicketType ticketType);

    EventsTicketTypeResponse ticketTypeToEventsTicketTypeResponse(TicketType ticketType);
    EventsResponse eventToEventsResponse(Event event);

}

