package com.edu.mycar02;

public class Car {
	Tire tire;
	
	
	
	//타이어의 종류를 생성자를 통해서 정한다.
	public Car(Tire tire) {
		this.tire = tire;
	}
	public String getTireBrand() {
		return "장착된 타이어는 " +tire.getBrand();
	}
}
