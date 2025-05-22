CREATE TABLE ticket_types
(
    id              UUID                        NOT NULL,
    name            VARCHAR(255)                NOT NULL,
    price           DECIMAL                     NOT NULL,
    total_available INTEGER,
    event_id        UUID,
    created_at      date                        NOT NULL,
    updated_at      TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    CONSTRAINT pk_ticket_types PRIMARY KEY (id)
);

ALTER TABLE ticket_types
    ADD CONSTRAINT FK_TICKET_TYPES_ON_EVENT FOREIGN KEY (event_id) REFERENCES events (id);