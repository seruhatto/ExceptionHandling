package com.seruhatto.training.exception.neverdo;

import org.apache.log4j.Logger;

/**
 * 
 * Throwing multiple checked exceptions from your method is fine, as long as there are different possible courses of
 * action that the caller may want to take, depending on which exception was thrown. If you have multiple checked
 * exceptions that basically mean the same thing to the caller, wrap them in a single checked exception. * For the
 * correct using :
 * 
 * 
 * @author seruhatto-work
 *
 */
public class ThrowExtremeMultiException {
	private static Logger logger = Logger.getLogger(ThrowExtremeMultiException.class.getName());

	public static void main(String[] args) {
		try {
			sendMessage("1.1.1.1");
		} catch (FileNotFoundException e) {
			logger.error("Error occured for File not found: ", e);
		} catch (EntityNotFoundException e) {
			logger.error("Error occured  for entity not found: ", e);
		} catch (MyException e) {
			logger.error("Error occured for my exception: ", e);
		} catch (InvalidIPException e) {
			logger.error("Error occured for invalid IP: ", e);
		} catch (Exception e) {
			logger.error("Error occured for exception: ", e);
		}

	}

	private static void sendMessage(String serverIp) throws FileNotFoundException, EntityNotFoundException,
			MyException, InvalidIPException, Exception {
		String file = "C:/file.txt";
		if (serverIp.equals("1.1.1.1")) {
			// Something is Wrong
			throw new ServerUnavailableException();
		} else if (serverIp.equals("0.0.0.0.0")) {
			// Something is Wrong
			throw new InvalidIPException();
		}

		String user = null;
		// get user from DB;
		if (user == null) {
			throw new EntityNotFoundException();
		}

		boolean isClosed = false;
		// file steps...
		if (file == null) {
			throw new FileNotFoundException();
		} else if (isClosed) {
			throw new MyException();
		}
	}

}

class MyException extends Exception {
	MyException() {
		super();
	}
}

class EntityNotFoundException extends Exception {
	EntityNotFoundException() {
		super();
	}
}

class FileNotFoundException extends Exception {
	FileNotFoundException() {
		super();
	}
}

class InvalidIPException extends Exception {
	InvalidIPException() {
		super();
	}
}