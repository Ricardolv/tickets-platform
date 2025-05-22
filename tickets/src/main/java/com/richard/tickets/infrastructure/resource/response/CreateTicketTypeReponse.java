package com.richard.tickets.infrastructure.resource.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CreateTicketTypeReponse {
    private UUID id;
    private String name;
    private BigDecimal price;
    private String description;
    private Integer totalAvailable;
    private LocalDate createdAt;
    private LocalDateTime updatedAt;
}
