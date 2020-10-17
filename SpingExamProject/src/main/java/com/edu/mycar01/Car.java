package com.edu.mycar01;

public class Car {
	Tire tire;
	
	public Car() {
//		tire =new KoreaTire();
		tire =new AmericaTire();
	}
	
	public String getTireBrand() {
		return "현재 장착된 타이어는 " + tire.getBrand();
	}
}
