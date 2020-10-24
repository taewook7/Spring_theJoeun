package com.edu.di03.spring;

public class AlreadyExisitingMemberException extends RuntimeException {
	public AlreadyExisitingMemberException(String message) {
		super(message);
	}
}
