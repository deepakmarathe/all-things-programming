package com.deepakm.webservice.util;

/**
 * Created by dmarathe on 5/29/15.
 * PKIException type represents exceptions related to Public Key Infrastructure.
 */
public class PKIException extends Exception {

    /**
     * Constructs a new PKIException with the specified detail message and
     * cause.  <p>Note that the detail message associated with
     * {@code cause} is <i>not</i> automatically incorporated in
     * this exception's detail message.
     *
     * @param message the detail message (which is saved for later retrieval
     *                by the {@link #getMessage()} method).
     * @param cause   the cause (which is saved for later retrieval by the
     *                {@link #getCause()} method).  (A <tt>null</tt> value is
     *                permitted, and indicates that the cause is nonexistent or
     *                unknown.)
     * @since 1.4
     */
    public PKIException(String message, Throwable cause) {
        super(message, cause);
    }
}

