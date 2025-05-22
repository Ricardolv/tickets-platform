package com.richard.tickets.infrastructure.resource.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CreateTicketTypeRequest {
    private String name;
    private BigDecimal price;
    private String description;
    private Integer totalAvailable;
}
