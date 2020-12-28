package com.seruhatto.training.exception.suggestion;

import org.apache.log4j.Logger;

/**
 * Never throw any exception from finally block Use finally blocks instead of catch blocks if you are not going to
 * handle exception
 * 
 * @author seruhatto
 *
 */
public class HandleFinally {
	private static Logger logger = Logger.getLogger(HandleFinally.class.getName());

	public static void main(String[] args) {
		try {
			doMethod();
		} catch (Exception e) {
			logger.error("Error occured ", e);
		}
	}

	private static void doMethod() throws Exception {

		try {
			getConnection();
			// Something is Wrong
			String abc = null;
			abc.toString();
		} finally {
			releaseAndClear();
		}
	}

	private static void getConnection() {
		// creates a connection
	}

	private static void releaseAndClear() throws Exception {
		try {
			// close connection
			// release/clear or close your object.
			logger.info("releaseAndClear");
			throw new Exception("Error during Release");
		} catch (Exception e) {
			logger.error("releaseAndClear could not run ", e);
		}
	}
}
