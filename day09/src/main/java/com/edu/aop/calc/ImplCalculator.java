package com.edu.aop.calc;

public class ImplCalculator implements Calculator {

	@Override
	public long factorial(long num) {
		long result = 1;
		// 시작 전 시간 체크
		
		for(long i=1; i <= num; i++) {
			result = result * i; 
		}
		// 종료 시간 체크 
		
		
		return result;
	}

}
