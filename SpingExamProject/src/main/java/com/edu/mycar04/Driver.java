package com.edu.mycar04;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Driver {

	public static void main(String[] args) {
		// 설정한걸 불러들이는 파일 
		// 아까 클래스들을 빈으로 설정해뒀으니 꺼내쓸수있다. 
		// appCtx.xml 에 기술한 <bean....> 가 Bean 으로 생성된다.
//		ApplicationContext context = new FileSystemXmlApplicationContext("src/main/java/com/mycar04/appCtx.xml");
		
		ApplicationContext context = new ClassPathXmlApplicationContext("com/edu/mycar04/appCtx.xml");
		
		
//		Car car= new Car();   이렇게 안만들어도된다 이제
		// 빈의 id , 클래스 
		//getBean을 사용하여 생선된 Bean 을 가져온다.
		Car car=context.getBean("car", Car.class);
		Tire tire= context.getBean("tire",Tire.class);  
		
		car.setTire(tire);
		System.out.println(car.getTireBrand());
	}
}
