package com.seruhatto.training.exception.neverdo;

import org.apache.log4j.Logger;

import com.seruhatto.training.exception.suggestion.WrappingException;

/**
 * Always correctly wrap the exceptions in custom exceptions so that stack trace is not lost
 * 
 * For the correct using : {@link WrappingException}
 * 
 * @author seruhatto
 * 
 *
 */
public class WrongWrappingException {
	private static Logger logger = Logger.getLogger(WrongWrappingException.class.getName());

	public static void main(String[] args) {
		try {
			doMethod();
		} catch (CustomException e) {
			logger.error(e.getMessage(), e);
		}
	}

	private static void doMethod() throws CustomException {
		try {
			ThirdPartyClass.doThirdPartyMethod();
		} catch (ThirdPartyException e) {
			throw new CustomException(e.getMessage());// e includes stackTrace for all exception but e.getMessage() is a spesific message for error.
		}
	}

}

class CustomException extends RuntimeException {
	public CustomException(String message) {
		super(message);
	}
}

/**
 * Third Pary Class
 * 
 */
class ThirdPartyClass {

	static void doThirdPartyMethod() throws ThirdPartyException {
		System.out.println("This is third party method");
		throw new ThirdPartyException();
	}

}

class ThirdPartyException extends Exception {

}