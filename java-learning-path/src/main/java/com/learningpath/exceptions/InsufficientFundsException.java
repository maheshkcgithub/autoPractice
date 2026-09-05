package com.learningpath.exceptions;

/**
 * A custom checked exception. Extending `Exception` (not `RuntimeException`)
 * makes it "checked": callers are forced by the compiler to either catch it
 * or declare `throws InsufficientFundsException`.
 */
public class InsufficientFundsException extends Exception {

	public InsufficientFundsException(String message) {
		super(message);
	}
}
