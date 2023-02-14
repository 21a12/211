package com.ktdsuniversity.edu.method;

public class Main {

	public static void main(String[] args) {
		
		Calc calc = new Calc();
		// 파라미터 ( int )
		calc.sum(0);
		// 파라미터 ( long )
		calc.sum(0l);
		// 파라미터 ( int, int )
		calc.sum(0,0);
		// 파라미터 ( int, int, int)
		calc.sum(0,0,0);
		
		//	클래스	변수명	=	생성자	클래스();
		Welcome welcome = new Welcome();
		String greeting = welcome.greeting();
		System.out.println(greeting);
		
		greeting = welcome.greeting("NAME");
		System.out.println(greeting);
		
		greeting = welcome.greeting("NAME","HELLO");
		System.out.println(greeting);
		
		// 파라미터가 String... 으로 정의되어 ,(콤마)로 파라미터를 구분하여 받음
		greeting = welcome.greeting("1", "2", "3", "4", "5", "6", "7");
		System.out.println(greeting);
		
		// 파라미터가 String[] 으로 정의되어 ,(콤마)가 아닌 배열을 파라미터로 받아야함
//		greeting = welcome.greetings("1", "2", "3", "4", "5", "6", "7");
//		System.out.println(greeting);
		
		// 배열 파라미터 Case ... 배열 파라미터를 사용할 때
		greeting = welcome.greetings(new String[] {"1", "2", "3"});
		System.out.println(greeting);
		
		
		String[] a = {"1", "2", "3", "4", "5", "6", "7"};
		greeting = welcome.greetings(a);
		System.out.println(greeting);
		
		
		
	}
	
}
