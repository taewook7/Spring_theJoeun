package com.edu.mycar05;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Driver {

	//스프링을 통한 의존성 주입
	//스프링 설정파일(XML) 에서 속성을 주입한다.
	public static void main(String[] args) {
		// 스프링 설정 파일을 불러온다.
		// 불러오게 되면 bean들이 생성 된다.
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/edu/mycar05/appCtx.xml");
		
		// 스프링 설정파일에서 의존관계가 설정되어있다.
		Car car=ctx.getBean("car",Car.class);
		
		System.out.println(car.getTireBrand());
		
		
	}

}
