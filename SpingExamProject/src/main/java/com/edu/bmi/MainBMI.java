package com.edu.bmi;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainBMI {

	public static void main(String[] args) {
		
		// classpath는  java/main/resource 를 의미한다
		String conf = "classpath:applicationContext.xml";
		
		
		// xml 파일일 경우에는 제네릭xml 을 써도된다.
		
		AbstractApplicationContext ctx=new GenericXmlApplicationContext(conf);
		
		//스프링 컨테이너에서 컴포넌트를 가져온다.
		MyInfo myInfo = ctx.getBean("myInfo", MyInfo.class);
		myInfo.getInfo();
		
		
		ctx.close();
	}

}
