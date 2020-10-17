package com.edu.mycar03;

public class Driver {

	//스프링없이 의존성 주입하기 : 속성을 통한 의존성 주입 
	public static void main(String[] args) {
		Tire tire = new KoreaTire();
		
		//생성자를 통한 방식과 다른 부분 
		Car car = new Car();
		car.setTire(tire);
		System.out.println(car.getTireBrand());
		
		
	}

}
