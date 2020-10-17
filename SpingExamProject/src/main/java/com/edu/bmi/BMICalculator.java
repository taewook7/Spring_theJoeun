package com.edu.bmi;

public class BMICalculator {
	private double lowWeight;  // 저체중
	private double normal; 	   // 표준
	private double overWeight; // 과체중
	private double obesty;     // 비만
	
	public void bmicalculation(double weight,double height) {
		double h=height * 0.01;
		double result=weight / (h*h);
		
		System.out.println("BMI 지수 : "+(int)result);
		
		if(result>obesty) {
			System.out.println("비만이당");
		} else if(result >overWeight) {
			System.out.println("과체중이당");
		} else if(result >normal) {
			System.out.println("표준임");
		} else {
			System.out.println("저체중임");
		}
	}

	public double getLowWeight() {
		return lowWeight;
	}

	public void setLowWeight(double lowWeight) {
		this.lowWeight = lowWeight;
	}

	public double getNormal() {
		return normal;
	}

	public void setNormal(double normal) {
		this.normal = normal;
	}

	public double getOverWeight() {
		return overWeight;
	}

	public void setOverWeight(double overWeight) {
		this.overWeight = overWeight;
	}

	public double getObesty() {
		return obesty;
	}

	public void setObesty(double obesty) {
		this.obesty = obesty;
	}
	
	
	
}
