package com.seruhatto.training.exception.suggestion;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;

import com.seruhatto.training.exception.suggestion.exception.InvalidIpException;
import com.seruhatto.training.exception.suggestion.exception.ServerUnavailableException;

/**
 * Declare the specific checked exceptions that your method can throw
 * 
 * @author seruhatto
 *
 */
public class ThrowSpecificException {
	private static Logger logger = Logger.getLogger(ThrowSpecificException.class.getName());
	private static final Pattern PATTERN = Pattern
			.compile("^(([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.){3}([01]?\\d\\d?|2[0-4]\\d|25[0-5])$");

	public static void main(String[] args) {
		List<String> serverIpList = retrieveServerIPList();
		try {
			for (String ip : serverIpList) {
				try {
					sendMessage(ip);
					logger.info("Message has been sent to: " + ip);
					break;
				} catch (ServerUnavailableException e) {
					logger.warn("Server Unavailable IP:" + e.getMessage() + " The message will be sent another IP");
				}
			}
		} catch (InvalidIpException e) {
			logger.error("Ip is invalid, all IPs must be valid.", e);
		} catch (Exception e) {
			logger.error("Unexpected exception during message sending.", e);
		}
	}

	private static List<String> retrieveServerIPList() {
		String ip1 = "2.2.2.2";
		String alternativeIp = "1.1.1.1";
		List<String> serverIpList = new ArrayList<String>();
		serverIpList.add(ip1);
		serverIpList.add(alternativeIp);
		return serverIpList;
	}

	private static void sendMessage(String ip) throws ServerUnavailableException, InvalidIpException {
		String responseCode = null;
		if (!validate(ip)) {
			throw new InvalidIpException(ip);
		}
		// Assume this IP is unavailable.
		if (ip.equals("1.1.1.1")) {
			responseCode = "200 OK";
		}
		if (responseCode == null) {
			throw new ServerUnavailableException(ip);
		}

	}

	public static boolean validate(final String ip) {
		return PATTERN.matcher(ip).matches();
	}

}
