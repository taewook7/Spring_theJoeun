package com.edu.mycar06;

import org.springframework.beans.factory.annotation.Autowired;

public class Car {
	
	
	//주입을넣어준다.
	// autowired 는 자동으로 주입하는것이다.
	@Autowired
	Tire tire;
	
	public String getTireBrand() {
		return "장착된 타이어는 " + tire.getBrand();
	}
	
	
}
