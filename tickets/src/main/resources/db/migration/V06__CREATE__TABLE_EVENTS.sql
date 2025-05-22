CREATE TABLE events
(
    id           UUID                        NOT NULL,
    name         VARCHAR(255)                NOT NULL,
    start        TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    "end"        TIMESTAMP WITHOUT TIME ZONE,
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