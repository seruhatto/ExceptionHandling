package com.seruhatto.training.exception.suggestion;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.seruhatto.training.exception.suggestion.exception.InvalidIpException;
import com.seruhatto.training.exception.suggestion.exception.ServerUnavailableException;

public class UseUncheckedException {
	private static Logger logger = Logger.getLogger(UseUncheckedException.class.getName());

	public static void main(String[] args) {
		try {
			boolean isSent = true;
			List<String> serverList = new ArrayList<String>();
			serverList.add("1.1.1.1");
			serverList.add("0.0.0.0.0");
			serverList.add("2.2.2.2");
			for (String ip : serverList) {
				try {
					isSent = sendMessage(ip);
				} catch (ServerUnavailableException e) {
					logger.error("Server unavailable ", e);
				}
			}
		} catch (InvalidIpException e) {
			logger.error("Invalid Server Configuration ", e);
		}

	}

	private static boolean sendMessage(String serverIp) throws ServerUnavailableException {

		if (serverIp.equals("0.0.0.0.0")) {
			// throw new Exception(serverIp);
			throw new InvalidIpException(serverIp);
		} else if (serverIp.equals("1.1.1.1")) {
			// Something is Wrong
			throw new ServerUnavailableException(serverIp);
		} else {
			// sendMessage
			return true;
		}
	}

}
