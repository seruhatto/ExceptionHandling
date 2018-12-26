package com.seruhatto.training.exception.suggestion;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Always correctly wrap the exceptions in custom exceptions so that stack trace
 * is not lost
 * 
 * @author seruhatto
 *
 */
public class WrappingException {
    private static Logger logger = Logger.getLogger(WrappingException.class.getName());

    public static void main(String[] args) {
	try {
	    doMethod();
	} catch (CustomException e) {
	    logger.log(Level.SEVERE, e.getMessage(), e);
	}
    }

    private static void doMethod() throws CustomException {
	try {
	    ThirdPartyClass.doThirdPartyMethod();
	} catch (ThirdPartyException e) {
	    throw new CustomException(e.getMessage(),e);
	}
    }

}

class CustomException extends RuntimeException {
    public CustomException(String message) {
	super(message);
    }

    public CustomException(String message, Exception e) {
	super(message, e);
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