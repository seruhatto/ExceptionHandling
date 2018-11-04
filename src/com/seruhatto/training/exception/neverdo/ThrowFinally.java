package com.seruhatto.training.exception.neverdo;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.seruhatto.training.exception.suggestion.HandleFinally;
import com.seruhatto.training.exception.suggestion.WrappingException;

/**
 * Never throw any exception from finally block
 * 
 * This is fine, as long as cleanUp() can never throw an exception. In the above
 * example, if blah() throws an exception, and then in the finally
 * block,cleanUp() throws an exception, that second exception will be thrown and
 * the first exception will be lost forever. If the code that you call in a
 * finally block can possibly throw an exception, make sure that you either
 * handle it, or log it. Never let it bubble out of the finally block. For the
 * correct using : {@link HandleFinally}
 * 
 * @author seruhatto
 *
 */
public class ThrowFinally {
    private static Logger logger = Logger.getLogger(ThrowFinally.class.getName());

    public static void main(String[] args) {
	try {
	    doMethod();
	} catch (Exception e) {
	    logger.log(Level.SEVERE, "Error occured ", e);
	}
    }

    private static void doMethod() throws Exception {

	try {
	    // Something is Wrong
	    String abc = null;
	    abc.toString();
	} finally {
	    releaseAndClear();
	}
    }

    private static void releaseAndClear() throws Exception {
	throw new Exception("Error during Release");
    }
}
