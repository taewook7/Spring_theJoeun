package com.edu.aop.main;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.edu.aop.calc.Calculator;

public class MainXmlAspect {
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:aopAspect.xml");
		
		Calculator implCal = ctx.getBean("implCal",Calculator.class);
		long fiveFact1 = implCal.factorial(10);
		System.out.println("implCal.factorial(10) = "+fiveFact1);
		
		Calculator recCal = ctx.getBean("recCal",Calculator.class);
		long fiveFact2 = recCal.factorial(10);
		System.out.println("recCal.factorial(10) = "+fiveFact2);
		
	}
}
