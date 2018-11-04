package com.seruhatto.training.exception.neverdo;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Never catch Throwable class
 * @author seruhatto
 */
public class CatchThrowableClass {
    private static Logger logger = Logger.getLogger(CatchThrowableClass.class.getName());

    public static void main(String[] args) {
	doMethod();
    }

    private static void doMethod() {
	try {
	    while (true) {

		System.out.println("Loop");
		doMethod();
	    }
	} catch (Throwable e) {
	    logger.log(Level.SEVERE, "Error:", e);
	}

    }
}
