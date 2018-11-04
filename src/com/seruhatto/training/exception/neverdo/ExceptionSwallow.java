package com.seruhatto.training.exception.neverdo;

import java.util.logging.Logger;

/**
 * Never swallow the exception in catch block
 * 
 * Log and Return Null Example:
 * 
 * Although not always incorrect, this is usually wrong. Instead of returning
 * null, throw the exception, and let the caller deal with it. You should only
 * return null in a normal (non-exceptional) use case (e.g.,
 * "This method returns null if the search string was not found.").
 * 
 * @author seruhatto
 *
 */
public class ExceptionSwallow {
    private static Logger logger = Logger.getLogger(ExceptionSwallow.class.getName());

    public static void main(String[] args) {
	String responseCode = sendMessage();
	if (responseCode.equals("200")) {

	} else if (responseCode.equals("400")) {

	} else {

	}
    }

    private static String sendMessage() {

	try {
	    // Something is Wrong
	    String responseCode = null;
	    //send a message and receive a response
	    responseCode.toString();
	    return responseCode;
	} catch (Exception e) {
	    return null;
	}

    }
}
