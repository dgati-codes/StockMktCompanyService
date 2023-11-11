package io.dave.exception;

@SuppressWarnings("serial")
public class CompanyNotFoundException extends RuntimeException {

	public CompanyNotFoundException() {
		super();
	}

	public CompanyNotFoundException(String message) {
		super(message);
	}
}
