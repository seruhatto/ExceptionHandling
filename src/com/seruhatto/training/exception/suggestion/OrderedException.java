package com.seruhatto.training.exception.suggestion;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Catch block order is important.
 * 
 * @author seruhatto-work
 *
 */
public class OrderedException {
    private static Logger logger = Logger.getLogger(OrderedException.class.getName());

    public static void main(String[] args) {
	FileInputStream fileInputStream = null;
	BufferedInputStream bufferedInputStream = null;
	try {

	    fileInputStream = new FileInputStream("file.txt");
	    bufferedInputStream = new BufferedInputStream(fileInputStream);
	    int data = bufferedInputStream.read();
	    while (data != 1) {
		System.out.println((char) data);
		data = bufferedInputStream.read();
	    }
	} catch (FileNotFoundException e) {
	    logger.log(Level.SEVERE, "File not found:", e);
	} catch (IOException e) {// FileNotFoundException include IOException
	    logger.log(Level.SEVERE, "IO error:", e);
	} finally {
	    try {
		bufferedInputStream.close();
	    } catch (IOException e) {
		logger.log(Level.SEVERE, "IO error during closed buffered input stream:", e);
	    }
	    try {
		fileInputStream.close();
	    } catch (IOException e) {
		logger.log(Level.SEVERE, "IO error during closed file input stream:", e);
	    }
	}

    }
}
