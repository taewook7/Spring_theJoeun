package com.edu.mycar02;

import static org.junit.Assert.*;

import org.junit.Test;

public class CarTest {

	@Test
	public void 한국에서_만든_타이어_테스트() {
		Tire tire=new KoreaTire();
		Car car=new Car(tire);
		System.out.println(car.getTireBrand());
		assertEquals("장착된 타이어는 한국타이어", car.getTireBrand());
	
	}

	@Test
	public void 미국에서_만든_타이어_테스트() {
		Tire tire=new AmericaTire();
		Car car=new Car(tire);
		System.out.println(car.getTireBrand());
		assertEquals("장착된 타이어는 미국타이어", car.getTireBrand());
	}
}
