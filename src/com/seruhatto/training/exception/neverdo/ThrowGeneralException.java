package com.seruhatto.training.exception.neverdo;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.seruhatto.training.exception.suggestion.ThrowSpecificException;
import com.seruhatto.training.exception.suggestion.WrappingException;

/**
 * 
 *  * For the correct using : {@link ThrowSpecificException.java}

 * @author seruhatto-work
 *
 */
public class ThrowGeneralException {
    private static Logger logger = Logger.getLogger(ThrowGeneralException.class.getName());

    public static void main(String[] args) {
	try {
	    sendMessage("1.1.1.1");
	} catch (Exception e) {
	    logger.log(Level.SEVERE, "Error occured: ", e);
	}
    }

    private static void sendMessage(String serverIp) throws Exception {

	if (serverIp.equals("1.1.1.1")) {
	    // Something is Wrong
	    throw new ServerUnavailableException();
	} else if (serverIp.equals("0.0.0.0.0")) {
	    // Something is Wrong
	    throw new Exception("Invalid IP");
	} else {
	    // sendMessage
	    // Something is Wrong
	    throw new Exception("Unexpected Exception");
	}
    }

}

class ServerUnavailableException extends Exception {
    ServerUnavailableException() {
	super();
    }
}