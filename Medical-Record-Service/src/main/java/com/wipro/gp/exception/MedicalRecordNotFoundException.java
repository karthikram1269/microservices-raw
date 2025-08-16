package com.wipro.gp.exception;

public class MedicalRecordNotFoundException extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = -183L;

	public MedicalRecordNotFoundException(String message) {
        super(message);
    }
}
