package com.seruhatto.training.exception.neverdo;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.seruhatto.training.exception.suggestion.ThrowSpecificException;

/**
 * Don't declare the general exceptions that your method can throw
 * * For the correct using : {@link ThrowSpecificException.java}
 * 
 * @author seruhatto-work
 *
 */
public class ThrowGeneralException {
    private static Logger logger = Logger.getLogger(ThrowGeneralException.class.getName());

    public static void main(String[] args) {
	try {
	    String parameterIP="1.1.1.1";
	    sendMessage(parameterIP);
	} catch (Exception e) {
	    logger.log(Level.SEVERE, "Error occured: ", e);
	    //if the IP is invalid , what will the app do?
	    //if the server is unavailable , what will the app do?
	}
    }

    
    private static void sendMessage(String serverIp) throws Exception {

	if (serverIp.equals("1.1.1.1")) {
	    // Something is Wrong
	    throw new ServerUnavailableException();
	} else if (serverIp.equals("0.0.0.0.0")) {
	    // Throw spesific Exception
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