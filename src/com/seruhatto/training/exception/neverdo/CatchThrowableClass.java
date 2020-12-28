package com.seruhatto.training.exception.neverdo;

import org.apache.log4j.Logger;

/**
 * Never catch Throwable/Error class.<br/>
 * This class is thrown by the Java Virtual Machine
 * https://docs.oracle.com/javase/7/docs/api/java/lang/Throwable.html<br/>
 * An Error is a subclass of Throwable that indicates serious problems that a reasonable application <b>should not try
 * to catch</b>. https://docs.oracle.com/javase/7/docs/api/java/lang/Error.html
 * 
 * @author seruhatto
 */
public class CatchThrowableClass {
	private static Logger logger = Logger.getLogger(CatchThrowableClass.class.getName());

	public static void main(String[] args) {
		doRecursiveMethod();
		doAnotherMethod();
	}

	private static void doRecursiveMethod() {
		try {
			logger.info("Loop");
			doRecursiveMethod();
		} catch (Exception e) {// Try to remove catch blocks except Exception
			logger.error("Exception:", e);
		} catch (Error e) {// Try to remove catch blocks for error and Throwable
			// If the JVM throws StackOverFlowError the app should not be continued.
			logger.error("Error:", e);
		} catch (Throwable e) {
			logger.error("Throwable:", e);
		}
	}

	private static void doAnotherMethod() {
		logger.info("Another Method");
	}
}
