package com.richard.tickets.infrastructure.resource.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class EventsTicketTypesResponse {

    private UUID id;
    private String name;
    private BigDecimal price;
    private String description;
    private Integer totalAvailable;

}
