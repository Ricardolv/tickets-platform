-- CREATE TABLE users
CREATE TABLE users
(
    id         UUID                        NOT NULL,
    name       VARCHAR(255)                NOT NULL,
    email      VARCHAR(255)                NOT NULL,
    created_at date                        NOT NULL,
    updated_at TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    CONSTRAINT pk_users PRIMARY KEY (id)
);

-- CREATE TABLE events
CREATE TABLE events
(
    id           UUID                        NOT NULL,
    name         VARCHAR(255)                NOT NULL,
    event_start  TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    event_end    TIMESTAMP WITHOUT TIME ZONE,
    venue        VARCHAR(255),
    sales_start  TIMESTAMP WITHOUT TIME ZONE,
    sales_end    TIMESTAMP WITHOUT TIME ZONE,
    status       VARCHAR(255)                NOT NULL,
    organizer_id UUID,
    created_at   date                        NOT NULL,
    updated_at   TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    CONSTRAINT pk_events PRIMARY KEY (id)
);

ALTER TABLE events
    ADD CONSTRAINT FK_EVENTS_ON_ORGANIZER FOREIGN KEY (organizer_id) REFERENCES users (id);

-- CREATE TABLE user_event_attending
CREATE TABLE user_event_attending
(
    event_id UUID NOT NULL,
    user_id  UUID NOT NULL
);

ALTER TABLE user_event_attending
    ADD CONSTRAINT fk_useeveatt_on_event FOREIGN KEY (event_id) REFERENCES events (id);

ALTER TABLE user_event_attending
    ADD CONSTRAINT fk_useeveatt_on_user FOREIGN KEY (user_id) REFERENCES users (id);

-- CREATE TABLE user_event_staffing
CREATE TABLE user_event_staffing
(
    event_id UUID NOT NULL,
    user_id  UUID NOT NULL
);

ALTER TABLE user_event_staffing
    ADD CONSTRAINT fk_useevesta_on_event FOREIGN KEY (event_id) REFERENCES events (id);

ALTER TABLE user_event_staffing
    ADD CONSTRAINT fk_useevesta_on_user FOREIGN KEY (user_id) REFERENCES users (id);

-- CREATE TABLE ticket_types
CREATE TABLE ticket_types
(
    id              UUID                        NOT NULL,
    name            VARCHAR(255)                NOT NULL,
    price           DECIMAL                     NOT NULL,
    description     VARCHAR(255),
    total_available INTEGER,
    event_id        UUID,
    created_at      date                        NOT NULL,
    updated_at      TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    CONSTRAINT pk_ticket_types PRIMARY KEY (id)
);

ALTER TABLE ticket_types
    ADD CONSTRAINT FK_TICKET_TYPES_ON_EVENT FOREIGN KEY (event_id) REFERENCES events (id);


-- CREATE TABLE tickets
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


-- CREATE TABLE ticket_types
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

-- CREATE TABLE qr_codes
CREATE TABLE qr_codes
(
    id         UUID                        NOT NULL,
    status     VARCHAR(255)                NOT NULL,
    value      VARCHAR(255)                NOT NULL,
    ticket_id  UUID,
    created_at date                        NOT NULL,
    updated_at TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    CONSTRAINT pk_qr_codes PRIMARY KEY (id)
);

ALTER TABLE qr_codes
    ADD CONSTRAINT FK_QR_CODES_ON_TICKET FOREIGN KEY (ticket_id) REFERENCES tickets (id);