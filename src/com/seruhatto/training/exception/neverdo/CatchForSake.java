package com.seruhatto.training.exception.neverdo;

import org.apache.log4j.Logger;

/**
 * Always catch only those exceptions that you can actually handle. It doesn't help anything
 * 
 * @author seruhatto
 *
 */
public class CatchForSake {
	private static Logger logger = Logger.getLogger(CatchForSake.class.getName());

	public static void main(String[] args) {
		try {
			doMethod();
		} catch (Exception e) {
			logger.error("Error occured ", e);
		}
	}

	private static void doMethod() throws Exception {

		try {
			// Something is Wrong
			String abc = null;
			abc.toString();
		} catch (Exception e) {
			throw e;
		}
	}
}
