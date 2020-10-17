package com.edu.mycar06;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Driver {
	// 스프링을 통한 의존성 주입 : @Autowired 를 통한 속성 주입
	public static void main(String[] args) {
		//스프링 빈을 읽어와야 하므로 스프링 설정 파일을 읽어들인다. = > 스프링의 컨테이너가 구성된다. (빈으로등록되고 메모리에 올라간다) 
		// 컨테이너 구성 => 설정파일에서 <bean> 을 지정한 것들이 Bean 으로 등록된다.
		ApplicationContext ctx= new ClassPathXmlApplicationContext("com/edu/mycar06/appCtx.xml");
		
		// 필요한 빈을 가져온다.
		// car 에 Autowired 어노테이션을 통해 Tire 을 주입했으므로 게터/세터 없이 자동으로 한국 타이어가 결과로 출력하는 것이다.
		Car car=ctx.getBean("car", Car.class);
		System.out.println(car.getTireBrand());
		
		
	}

}
