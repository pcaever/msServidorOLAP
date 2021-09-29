package com.everis.msdemo.be.exception;

public class SiecaException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private final String codError;

	public SiecaException(String cod, String msg) {
		super(msg);
		this.codError = cod;
	}

	public String getCodError() {
		return codError;
	}

}