package com.edu.aop.aspect;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

// 어노테이션을 이용해서 공통 기능을 제공하는 Aspect 클래스를 작성 
// @ASPECT 어노테이션을 적용한 클래스에 공통기능과 Pointcut을 설정한다. 
@Aspect 
public class ExeTimeAspect2 {

	//하위에 모든폴더를 다 포함
	@Pointcut("execution(public * calc..*(..))")
	private void publicTarget() {
		
	}
	
	@Around("publicTarget()")
	public Object measure(ProceedingJoinPoint joinPoint) throws Throwable {
		long start = System.nanoTime();
		try {
			Object result = joinPoint.proceed();
			return result;
		} finally {
			long finish = System.nanoTime();
			Signature sig = joinPoint.getSignature();
			System.out.printf("%s.%s(%s) 실행시간 : %d ns\n", 
					joinPoint.getTarget().getClass().getSimpleName(), sig.getName(), Arrays.toString(joinPoint.getArgs()), (finish-start));
			
		}
	}
}
