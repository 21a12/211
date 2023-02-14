package com.ktdsuniversity.edu.constructor;

public class Calculator {
	
	private int a;
	private int b;
	
	public Calculator() {
		this.a = 10;
		this.b = 20;
	}
	
	// 파라미터 변수명과 인스턴스필드 변수명이 같아 this.으로 구분해준다
	public Calculator(int a, int b) {
		this.a = a;
		this.b = b;
	}
	
	public int sum() {
		return this.a + this.b;
	}
	
}
