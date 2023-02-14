package com.ktdsuniversity.edu.method;

public class Calc {
	
	// 메소드 오버로딩 ... 파라미터의 변화를 통해 다양하게 사용할 수 있음. 
	// 파라미터가 존재하지 않아도 리턴값을 반환한다.
	public int sum() {
		return 0;
	}

	public int sum(long longNumber) {
		System.out.println("long sum");
		return 0;
	}

	public int sum(int Number) {
		System.out.println("int sum");
		return 0;
	}

	public int sum(int numberOne, int numberTwo) {
		System.out.println("int int sum");
		return 0;
	}
	
	public int sum(int numberOne, int numberTwo, int numberThree) {
		System.out.println("int int int sum");
		return 0;
	}
	
	
	
	
	
//	public static void main(String[] args) {
//		
//		Calc calc = new Calc();
//		
//		int test = calc.sum(99l);
//		
//		System.out.println(test);
//	}

}
