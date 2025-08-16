package com.wipro.gp.exception;

public class PaymentNotFoundException extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = -183L;

	public PaymentNotFoundException(String message) {
        super(message);
    }
}
