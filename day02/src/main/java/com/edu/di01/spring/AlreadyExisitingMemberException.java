package com.edu.di01.spring;

public class AlreadyExisitingMemberException extends RuntimeException {
	public AlreadyExisitingMemberException(String message) {
		super(message);
	}
}
