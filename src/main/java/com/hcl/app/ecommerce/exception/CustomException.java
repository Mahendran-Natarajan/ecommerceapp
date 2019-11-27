package com.hcl.app.ecommerce.exception;

/**
 * custom exception
 *
 * @author manatara
 * @version 1.0
 * @since 27-11-2019
 */
public class CustomException extends Exception {
    /**
     * Constructs a new exception with the specified detail message.  The
     * cause is not initialized, and may subsequently be initialized by
     * a call to {@link #initCause}.
     *
     * @param message the detail message. The detail message is saved for
     *                later retrieval by the {@link #getMessage()} method.
     */
    public CustomException(String message) {
        super(message);
    }
}
