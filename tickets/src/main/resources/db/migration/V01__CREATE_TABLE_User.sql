CREATE TABLE user_event_attending
(
    event_id UUID NOT NULL,
    user_id  UUID NOT NULL
);

CREATE TABLE user_event_staffing
(
    event_id UUID NOT NULL,
    user_id  UUID NOT NULL
);

CREATE TABLE users
(
    id         UUID                        NOT NULL,
    name       VARCHAR(255)                NOT NULL,
    email      VARCHAR(255)                NOT NULL,
    created_at date                        NOT NULL,
    updated_at TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    CONSTRAINT pk_users PRIMARY KEY (id)
);

ALTER TABLE user_event_attending
    ADD CONSTRAINT fk_useeveatt_on_event FOREIGN KEY (event_id) REFERENCES events (id);

ALTER TABLE user_event_attending
    ADD CONSTRAINT fk_useeveatt_on_user FOREIGN KEY (user_id) REFERENCES users (id);

ALTER TABLE user_event_staffing
    ADD CONSTRAINT fk_useevesta_on_event FOREIGN KEY (event_id) REFERENCES events (id);

ALTER TABLE user_event_staffing
    ADD CONSTRAINT fk_useevesta_on_user FOREIGN KEY (user_id) REFERENCES users (id);