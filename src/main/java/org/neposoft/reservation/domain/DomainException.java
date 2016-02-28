package org.neposoft.reservation.domain;

/**
 * Created by mrdezzods on 28/02/16.
 */
public class DomainException extends RuntimeException {
    public DomainException() {
        super();
    }

    public DomainException(String message) {
        super(message);
    }
}
