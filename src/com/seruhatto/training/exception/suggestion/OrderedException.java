package com.seruhatto.training.exception.suggestion;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.log4j.Logger;

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
			fileInputStream = new FileInputStream("./file.txt");
			bufferedInputStream = new BufferedInputStream(fileInputStream);
			int data = bufferedInputStream.read();
			while (data != -1) {
				System.out.println((char) data);
				data = bufferedInputStream.read();
			}
		} catch (FileNotFoundException e) {
			logger.error("File not found:", e);
		} catch (IOException e) {// FileNotFoundException extends IOException
			logger.error("IO error:", e);
		}
	}
}
