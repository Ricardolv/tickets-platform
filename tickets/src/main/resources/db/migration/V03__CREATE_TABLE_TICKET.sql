CREATE TABLE tickets
(
    id             UUID                        NOT NULL,
    status         VARCHAR(255)                NOT NULL,
    ticket_type_id UUID,
    purchaser_id   UUID,
    created_at     date                        NOT NULL,
    updated_at     TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    CONSTRAINT pk_tickets PRIMARY KEY (id)
);

ALTER TABLE tickets
    ADD CONSTRAINT FK_TICKETS_ON_PURCHASER FOREIGN KEY (purchaser_id) REFERENCES users (id);

ALTER TABLE tickets
    ADD CONSTRAINT FK_TICKETS_ON_TICKET_TYPE FOREIGN KEY (ticket_type_id) REFERENCES ticket_types (id);