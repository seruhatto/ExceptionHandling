package com.seruhatto.training.exception.suggestion.exception;

public class InvalidIpException extends RuntimeException {

    public InvalidIpException(String ip) {
	super(ip);
    }

}
