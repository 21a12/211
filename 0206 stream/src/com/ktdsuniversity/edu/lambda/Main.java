package com.ktdsuniversity.edu.lambda;

import java.util.Arrays;
import java.util.List;

public class Main {

	public static void print(Printable printable) {
		printable.print("JMC");
	}

	public static void printSumResult(Computable computable) {

		int sumResult = computable.sum(10, 30);
		System.out.println(sumResult);

	}

	public static void main(String[] args) {

		// 익명 클래스
		printSumResult(new Computable() {

			@Override
			public int sum(int numberOne, int numberTwo) {
				return numberOne + numberTwo;
			}
		});

		// 람다 함수
		printSumResult((num1, num2) -> num1 + num2);
		// 중괄호의 의미... return
		printSumResult((num1, num2) -> {
			return num1 + num2;
		});

		// return 형식을 맞춰줘야 함
//		print((data) -> data + "입니다");
		print((data) -> System.out.println(data + "입니다"));
		print((data) -> {
			System.out.println(data + "입니다");
		});
		
		// 메소드 레퍼런스
		print(System.out::println);
		
		List<Integer> intList = List.of(10,20,30,40,50);
		List<Integer> intList2 = Arrays.asList(10,20,30,40,50);
		
		intList.forEach(System.out::println);
		intList2.forEach(System.out::println);

	}

}
