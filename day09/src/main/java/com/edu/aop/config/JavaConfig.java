package com.edu.aop.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.edu.aop.aspect.ExeTimeAspect2;
import com.edu.aop.calc.Calculator;
import com.edu.aop.calc.ImplCalculator;
import com.edu.aop.calc.RecCalculator;

@Configuration  
@EnableAspectJAutoProxy


public class JavaConfig {
	@Bean
	public ExeTimeAspect2 exeTimeAspect() {
		return new ExeTimeAspect2();
	}
	
	@Bean
	public Calculator recCal() {
		return new RecCalculator();
	}
	
	@Bean
	public Calculator implCal() {
		return new ImplCalculator();
	}
}
