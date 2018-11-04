package com.seruhatto.training.exception.suggestion;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.seruhatto.training.exception.suggestion.exception.ServerUnavailableException;

public class ThrowSpecificException {
    private static Logger logger = Logger.getLogger(ThrowSpecificException.class.getName());

    public static void main(String[] args) {
	try {
	    sendMessage();
	} catch (ServerUnavailableException e) {
	    logger.log(Level.SEVERE, "Error occured: ", e);
	}
    }

    private static void sendMessage() throws ServerUnavailableException {

	// Something is Wrong
	String responseCode = null;
	// check response code
	if (responseCode == null) {
	    throw new ServerUnavailableException();
	}

    }

}
