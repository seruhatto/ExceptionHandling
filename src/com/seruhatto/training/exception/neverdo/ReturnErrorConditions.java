package com.seruhatto.training.exception.neverdo;

public class ReturnErrorConditions {

	/**
	 * Don't return values like error status codes instead of a spesific exception
	 * 
	 */
	public static void main(String[] args) {

		int result = doMethod(null);
		if (result == 0) {
			// other process
		} else if (result == -1) {
			System.out.println("show message user for -1");
		} else if (result == -2) {
			System.out.println("show message user for -2");
		}
	}

	private static int doMethod(String item) {
		if (item == null) {
			return -1;
		} else if (item.equals("")) {
			return -2;
		}
		return 0;
	}
}
