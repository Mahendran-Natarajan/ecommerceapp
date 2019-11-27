package com.hcl.app.ecommerce.exception;

public class ProductNotFoundException extends CustomException {
    /**
     * Constructs a new exception with the specified detail message.  The
     * cause is not initialized, and may subsequently be initialized by
     * a call to {@link #initCause}.
     *
     * @param message the detail message. The detail message is saved for
     *                later retrieval by the {@link #getMessage()} method.
     */
    public ProductNotFoundException(String message) {
        super(message);
    }

}
