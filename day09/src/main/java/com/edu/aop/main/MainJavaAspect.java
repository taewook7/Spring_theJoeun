package com.edu.aop.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.edu.aop.calc.Calculator;
import com.edu.aop.config.JavaConfig;

public class MainJavaAspect {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(JavaConfig.class);
		
		Calculator recCal = ctx.getBean("recCal",Calculator.class);
		long fiveFact1 = recCal.factorial(15);
		System.out.println("recCal.factorial(15) = " + fiveFact1);
		
		Calculator implCal = ctx.getBean("implCal",Calculator.class);
		long fiveFact2 = recCal.factorial(15);
		System.out.println("implCal.factorial(15) = " + fiveFact2);
		
		
	}

}
