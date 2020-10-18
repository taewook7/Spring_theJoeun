package com.edu.di01.spring;

public class VersionPrinter {
	private int majorVersion;
	private int minorVersion;
	
	//기본 생성자
	public VersionPrinter() {	}
	
	//매개변수가 있는 생성자
	public VersionPrinter(int majorVersion, int minorVersion) {
		this.majorVersion=majorVersion;
		this.minorVersion=minorVersion;
	}

	public void setMajorVersion(int majorVersion) {
		this.majorVersion = majorVersion;
	}
	
	// println은 안된다 정수형인 printf 를 써야한다.
	public void print() {
		System.out.printf("이 프로그램의 버전은 %d.%d입니다.",majorVersion, minorVersion);
	}
	public void setMinorVersion(int minorVersion) {
		this.minorVersion = minorVersion;
	}
	
}
