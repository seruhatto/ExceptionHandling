package com.seruhatto.training.exception.neverdo;

import org.apache.log4j.Logger;

import com.seruhatto.training.exception.suggestion.PrettyStackTrace;

/**
 * Don’t use printStackTrace() statement or similar methods <br>
 * correct using : {@link PrettyStackTrace}
 * 
 * @author seruhatto
 */
public class PrintStackTrace {
	private static Logger logger = Logger.getLogger(PrintStackTrace.class.getName());
	private static String userName = "Clumsy User";

	public static void main(String[] args) {
		doMethod();
	}

	private static void doMethod() {

		try {
			// Something is Wrong
			String abc = null;
			abc.toString();
		} catch (Exception e) {
			// e.printStackTrace();// don't do this.
			// System.out.println("Error Print:" + e.getMessage());// don't do this
			logger.error("UserName:" + userName);
			logger.error("Error occured " + e.getMessage());// You can pass "e" variable to log method instead of
			// e.getMessage
		}
	}

}
