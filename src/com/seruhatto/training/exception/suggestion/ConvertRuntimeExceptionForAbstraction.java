package com.seruhatto.training.exception.suggestion;

import java.sql.SQLException;

/**
 * Convert checkedExceptions to meaningful UncheckedException and handle on ClientLayer.
 * 
 * @author seruhatto
 *
 */
public class ConvertRuntimeExceptionForAbstraction {

	public static void main(String[] args) {
		try {
			String userName = RestLayer.getUserName("1");
			// return userName to client;
		} catch (ServerInternalException e) {
			// return restResponse with 500
		}

	}
}

class RestLayer {
	static ApplicationLayer applicationLayer = new ApplicationLayer();

	public static String getUserName(String userId) {
		return applicationLayer.getUserName(userId);
	}
}

class ApplicationLayer {
	private DatabaseLayer databaseLayer = new DatabaseLayer();

	public String getUserName(String id) {
		try {
			return databaseLayer.retrieveUserName(id);
		} catch (SQLException e) {
			throw new ServerInternalException(id);
		}
	}
}

class DatabaseLayer {

	public String retrieveUserName(String userid) throws SQLException {
		throw new SQLException("SQL is not valid");
	}
}

class ServerInternalException extends RuntimeException {
	public ServerInternalException(String message) {
		super(message);
	}
}