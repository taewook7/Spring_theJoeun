package com.edu.mycar01;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CarTest {
	@Test
	public void 자동차에_장착된_타이어브랜드_테스트() {
		Car car=new Car();
		System.out.println("장착된 브랜드 : " + car.getTireBrand());
		
		// 앞,뒤 테스트 하는 메서드이다.
		assertEquals("현재 장착된 타이어는 미국타이어", car.getTireBrand());
		
	}
}
