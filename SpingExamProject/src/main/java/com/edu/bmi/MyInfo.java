package com.edu.bmi;

import java.util.ArrayList;

public class MyInfo {
	private String name;
	private double height;
	private double weight;
	
	//취미는 여러개일수있으니 어레이로 스트링 타입으로 설정한다. 
	private ArrayList<String> hobby;
	private BMICalculator bmiCalculator;
	
	
	// 입력받은 몸무게와 키를 가지고 계산한다.
	public void bmiCalculation() {
		bmiCalculator.bmicalculation(weight, height);
	}
	
	// 계산 대상자의 정보를 출력한다.
	public void getInfo() {
		System.out.println("이름" +name );
		System.out.println("키" +height );
		System.out.println("몸무게" +weight );
		System.out.println("취미" +hobby );
		bmiCalculation(); 
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public ArrayList<String> getHobby() {
		return hobby;
	}

	public void setHobby(ArrayList<String> hobby) {
		this.hobby = hobby;
	}

	public BMICalculator getBmiCalculator() {
		return bmiCalculator;
	}

	public void setBmiCalculator(BMICalculator bmiCalculator) {
		this.bmiCalculator = bmiCalculator;
	}
	
	
	
	
	
	
}














