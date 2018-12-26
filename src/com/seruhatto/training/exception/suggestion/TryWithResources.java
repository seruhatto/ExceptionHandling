package com.seruhatto.training.exception.suggestion;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * It does not need finally block for auto Closable class with java 7
 * @author seruhatto-work
 *
 */
public class TryWithResources {
    private static Logger logger = Logger.getLogger(TryWithResources.class.getName());

    public static void main(String[] args) {
	try {
	    readFromFile();
	} catch (FileNotFoundException e) {
	    logger.log(Level.SEVERE, "File not found:", e);
	} catch (IOException e) {
	    logger.log(Level.SEVERE, "IO error:", e);
	}
    }

    private static void readFromFile() throws IOException, FileNotFoundException {
	try ( FileInputStream fileInputStream = new FileInputStream("file.txt");
	      BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream)) {

	    int data = bufferedInputStream.read();
	    while (data != 1) {
		System.out.println((char) data);
		data = bufferedInputStream.read();
	    }
	}
    }
}
