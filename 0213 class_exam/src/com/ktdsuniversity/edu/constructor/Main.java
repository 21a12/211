package com.ktdsuniversity.edu.constructor;

public class Main {
	
	public static void main(String[] args) {
		
//		Calculator calc1 = new Calculator();
//		int result = calc1.sum();
//		System.out.println(result);
//		
//		Calculator calc2 = new Calculator(5, 6);
//		result = calc2.sum();
//		System.out.println(result);
		
		// 선언과 동시에 파라미터를 이용해 getter/setter를 사용하지 않고 멤버변수를 한번에 초기화할 수 있음.
		Doctor doctor1 = new Doctor("최신컴퓨터", "펜");
		String result = doctor1.examination();
		System.out.println(result);
		
		Doctor doctor2 = new Doctor("고물컴퓨터", "청진기");
		result = doctor2.examination();
		System.out.println(result);
		
		Doctor doctor3 = new Doctor("왼손", "오른손");
		result = doctor3.examination();
		System.out.println(result);
		
		
		
		
		
	}
}
