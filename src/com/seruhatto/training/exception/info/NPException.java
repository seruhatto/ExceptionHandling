package com.seruhatto.training.exception.info;

/**
 * So if you must allow NullPointerException in some places in you code then
 * make sure you make them more informative then they usually are.
 * https://howtodoinjava
 * .com/java/exception-handling/how-to-effectively-handle-nullpointerexception
 * -in-java/
 * 
 * @author seruhatto
 *
 */
public class NPException {

    public static void main(String[] args) {
	// call one method at a time

	doSomething(null);
	doSomethingElse(null);
    }

    private static String doSomething(final String param) {
	System.out.println(param.toString());
	return "I am done !!";
    }

    private static String doSomethingElse(final String param) {
	if (param == null) {
	    throw new NullPointerException(" :: Parameter 'param' was null inside method 'doSomething'.");
	}
	System.out.println(param.toString());
	return "I am done !!";
    }

}
