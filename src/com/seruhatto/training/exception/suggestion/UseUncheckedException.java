package com.seruhatto.training.exception.suggestion;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.seruhatto.training.exception.suggestion.exception.InvalidIpException;
import com.seruhatto.training.exception.suggestion.exception.ServerUnavailableException;

public class UseUncheckedException {
    private static Logger logger = Logger.getLogger(UseUncheckedException.class.getName());

    public static void main(String[] args) {
	boolean isSent = false;
	while (isSent) {
	    try {
		isSent = sendMessage("1.1.1.1");
	    } catch (ServerUnavailableException e) {
		logger.log(Level.SEVERE, "Server unavailable ", e);
	    }
	}

    }

    private static boolean sendMessage(String serverIp) throws ServerUnavailableException {

	if (serverIp.equals("0.0.0.0.0")) {
	    // throw new Exception(serverIp);
	    throw new InvalidIpException(serverIp);
	} else if (serverIp.equals("1.1.1.1")) {
	    // Something is Wrong
	    throw new ServerUnavailableException();
	} else {
	    // sendMessage
	    return true;
	}
    }

}
