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