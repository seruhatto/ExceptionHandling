package com.seruhatto.training.exception.info;

import java.lang.Thread.UncaughtExceptionHandler;

import org.apache.log4j.Logger;

/**
 * UncaughtExceptionHandler When a thread is about to terminate due to an uncaught exception the Java Virtual Machine
 * will query the thread for its UncaughtExceptionHandler using Thread.getUncaughtExceptionHandler() <br>
 * and will invoke the handler's uncaughtException method, passing the thread and the exception as arguments. <br>
 * If a thread has not had its UncaughtExceptionHandler explicitly set, then its ThreadGroup object acts as its
 * UncaughtExceptionHandler. <br>
 * If the ThreadGroup object has no special requirements for dealing with the exception, it can forward the invocation
 * to the default uncaught exception handler. Always terminate the thread which it is interrupted
 */
public class UncaughtHandler {
	private static Logger logger = Logger.getLogger(UncaughtHandler.class.getName());

	public static void main(String[] args) {
		Thread.currentThread().setUncaughtExceptionHandler(new CustomUncaughtExceptionHandler());
		ThreadGroup threadGroup = new ThreadGroup("My Thread Group");
		MyThread myThread = new MyThread(threadGroup, "3");
		myThread.setUncaughtExceptionHandler(new CustomUncaughtExceptionHandler());
		myThread.start();
		throw new RuntimeException("gggg");
	}
}

class MyThread extends Thread {

	public MyThread(ThreadGroup threadGroup, String name) {
		super(threadGroup, name);
	}

	@Override
	public void run() {
		long i = 0;
		while (true) {
			if (this.getName() == "3") {
				throw new RuntimeException("Thread Exception:" + this.getName());
			}
		}
	}
}

class CustomUncaughtExceptionHandler implements UncaughtExceptionHandler {
	private static Logger logger = Logger.getLogger(CustomUncaughtExceptionHandler.class.getName());

	@Override
	public void uncaughtException(Thread t, Throwable e) {
		logger.error("Thread Handle:" + t.getName());
	}

}