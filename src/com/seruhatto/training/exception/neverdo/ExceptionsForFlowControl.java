package com.seruhatto.training.exception.neverdo;

import java.util.logging.Logger;

/**
 * Never use exceptions for flow control in your program
 * It makes code hard to read, understand and ugly.
 */
public class ExceptionsForFlowControl {
    private static Logger logger = Logger.getLogger(ExceptionsForFlowControl.class.getName());

    public static void main(String[] args) {
	String userDefinedValue = "1";
	try {
	    checkValue(userDefinedValue);
	    doMethod();
	} catch (Exception e) {
	    anotherDoMethod();
	}

    }

    private static void anotherDoMethod() {
	System.out.println("Another way");
    }

    private static void doMethod() {
	System.out.println("doMethod");
    }

    private static void checkValue(String userDefinedValue) throws Exception {
	if (!userDefinedValue.equals("1")) {
	    throw new Exception("Alternative Way");
	}
    }
}
