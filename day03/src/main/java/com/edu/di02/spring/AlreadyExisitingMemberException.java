package com.edu.di02.spring;

public class AlreadyExisitingMemberException extends RuntimeException {
	public AlreadyExisitingMemberException(String message) {
		super(message);
	}
}
