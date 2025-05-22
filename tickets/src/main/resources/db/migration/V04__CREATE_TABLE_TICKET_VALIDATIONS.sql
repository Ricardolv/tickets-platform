CREATE TABLE ticket_validations
(
    id                UUID                        NOT NULL,
    status            VARCHAR(255)                NOT NULL,
    validation_method VARCHAR(255)                NOT NULL,
    ticket_id         UUID,
    created_at        date                        NOT NULL,
    updated_at        TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    CONSTRAINT pk_ticket_validations PRIMARY KEY (id)
);

ALTER TABLE ticket_validations
    ADD CONSTRAINT FK_TICKET_VALIDATIONS_ON_TICKET FOREIGN KEY (ticket_id) REFERENCES tickets (id);