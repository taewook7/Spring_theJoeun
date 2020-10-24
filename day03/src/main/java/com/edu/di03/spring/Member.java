package com.edu.di03.spring;

import java.util.Date;

public class Member {
	private Long id;
	private String email;
	private String password;
	private String name;
	private Date registerDate;
	
	
	// 매개변수 있는 생성자 
	public Member(String email, String password, String name, Date registerDate) {
		this.email=email;
		this.password=password;
		this.name=name;
		this.registerDate=registerDate;
	}
	
	
	//비밀번호 변경 메서드
	public void changePassword(String oldPassword,String newPassword) {
		if (!password.equals(oldPassword)) throw new IdPasswordNotMatchingException(); 
		this.password=newPassword;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Date getRegisterDate() {
		return registerDate;
	}


	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}


	@Override
	// 오버로딩은 똑같은 메서드를 계속찍어낸다. 안에 매개변수가 다르다 타입이틀리거나 개수가 다름 
	// 오버라이딩은 
	public String toString() {
		return "Member [id=" + id + ", email=" + email + ", password=" + password + ", name=" + name + ", registerDate="
				+ registerDate + "]";
	}
	
	
	
	
	
	
	
}
