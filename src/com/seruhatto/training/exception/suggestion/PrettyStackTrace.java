package com.seruhatto.training.exception.suggestion;

import org.apache.log4j.Logger;

/**
 * Always exception parameter pass a parameter in log method <br>
 * Always include all information about an exception in single log message for multi-thread process<br>
 * Pass all relevant information to exceptions to make them informative as much as possible
 * 
 * @author Serhat ERSEL
 *
 */
public class PrettyStackTrace {
	private static Logger logger = Logger.getLogger(PrettyStackTrace.class.getName());
	private static String userName = "Clumsy User";

	public static void main(String[] args) {
		ValuableObject obj = new ValuableObject();
		int requestType = 1;
		try {
			String response = sendUpdateRequest(requestType);
			doUpdate(response);
		} catch (RuntimeException e) {
			logger.error("Error occured during updating UserName:" + userName + " RequestType:" + requestType + " ValuableContent:" + obj, e);
		}
	}

	private static void doUpdate(String response) {
		throw new RuntimeException("Update can not proceed");
	}

	private static String sendUpdateRequest(int requestType) {
		if (requestType == 1) {
			throw new RuntimeException("Response can not parsed");
		} else if (requestType == 2) {
			throw new RuntimeException("Response can not parsed");
		} else if (requestType == 3) {
			throw new RuntimeException("Response can not parsed");
		}
		return "success";
	}
}

class ValuableObject {

	private String id = "1";
	private String systemName = "system1";
	private String deviceId = "device1";
	private String type = "type1";

	@Override
	public String toString() {
		return "ValuableObject [id=" + id + ", systemName=" + systemName + ", deviceId=" + deviceId + ", type=" + type + "]";
	}
}