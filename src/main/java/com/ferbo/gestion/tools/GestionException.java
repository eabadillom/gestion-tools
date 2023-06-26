package com.ferbo.gestion.tools;

public class GestionException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public GestionException() {
		super();
	}

	/**
	 * @param message mensaje
	 */
	public GestionException(String message) {
		super(message);
	}

	/**
	 * @param cause causa
	 */
	public GestionException(Throwable cause) {
		super(cause);
	}

	/**
	 * @param message mensaje
	 * @param cause causa
	 */
	public GestionException(String message, Throwable cause) {
		super(message, cause);
	}
	
	

}
