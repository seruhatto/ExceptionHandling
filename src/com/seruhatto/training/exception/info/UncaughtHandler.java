package com.seruhatto.training.exception.info;

import java.lang.Thread.UncaughtExceptionHandler;

/**
 * 
 * 
 *
 */
public class UncaughtHandler {
    public static void main(String[] args) {
	//MyThread.setDefaultUncaughtExceptionHandler(new CustomUncaughtExceptionHandler());
 
	ThreadGroup threadGroup = new ThreadGroup("My Thread Group");
 
	//	new MyThread(threadGroup,"1").start();
//	new MyThread(threadGroup,"2").start();
	MyThread myThread = new MyThread(threadGroup,"3");
	myThread.setUncaughtExceptionHandler(new CustomUncaughtExceptionHandler());
	myThread.start();
	
	
	// String text = null;
	// method(text);
	// method("Test");
    }

    private static void method(String text) {
	System.out.println("First char:" + text.indexOf(0));
    }

}

class MyThread extends Thread {

    public MyThread(ThreadGroup threadGroup,String name) {
	super(threadGroup, name);
    }

    @Override
    public void run() {
	long i = 0;
	while (true) {
 	    run();
	}
    }
}

class CustomUncaughtExceptionHandler implements UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
 	System.out.println("Exce:" +t.getName());
 	new MyThread(null, "4").start();

    }

}