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
	if (responseCode == null) {
	    logger.severe("Message has not been sent, There is a network problem.");
	} else {
	    logger.info("Message has been sent with status code :" + responseCode);
	}
    }

    private static String sendMessage() {
	try {
	    String responseCode = null;
	    // Something is Wrong

	    // send a message and receive a response
	    return responseCode.toString();
	} catch (Exception e) {
	    return null;
	}
    }
}
