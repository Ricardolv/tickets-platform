package com.richard.tickets.infrastructure.resource.mapper;

import com.richard.tickets.infrastructure.persistence.entities.Event;
import com.richard.tickets.infrastructure.persistence.entities.TicketType;
import com.richard.tickets.infrastructure.resource.request.CreateEventRequest;
import com.richard.tickets.infrastructure.resource.request.CreateTicketTypeRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface TicketMapper {

    TicketMapper INSTANCE = Mappers.getMapper(TicketMapper.class);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "attendees", ignore = true)
    @Mapping(target = "staff", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    Event ticketToTicketResource(CreateEventRequest request);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "event", ignore = true)
    @Mapping(target = "tickets", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    TicketType ticketTypeToTicketTypeResource(CreateTicketTypeRequest request);



}

