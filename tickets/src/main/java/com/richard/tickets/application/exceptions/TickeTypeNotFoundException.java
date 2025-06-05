package com.richard.tickets.application.exceptions;

public class TickeTypeNotFoundException extends EventTicketException {
    public TickeTypeNotFoundException() {
    }

    public TickeTypeNotFoundException(String message) {
        super(message);
    }

    public TickeTypeNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public TickeTypeNotFoundException(Throwable cause) {
        super(cause);
    }

    public TickeTypeNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
