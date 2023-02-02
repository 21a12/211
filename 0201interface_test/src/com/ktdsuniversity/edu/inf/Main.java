package com.ktdsuniversity.edu.inf;

public class Main {

	public static void calculate(Calculator calculator) {
		System.out.println(calculator);
		if (calculator instanceof CalculatorNormalImpl) {
			System.out.println(calculator.sum(5, 3));
			System.out.println(calculator.minus(5, 3));
		}

	}

	public static void main(String[] args) {

		calculate(new CalculatorNormalImpl());
		calculate(new CalculatorRandomImpl());

//		// 인터페이스명 변수 = new 구현클래스명();
//		Calculator calculator1 = new CalculatorNormalImpl();
//		
//		System.out.println(calculator1.sum(5, 3));
//		System.out.println(calculator1.minus(5, 3));
//		
//		// calculator1는 변수 타입이 인터페이스 Calculator로 되어있어
//		// 정의되지 않은 devide는 사용할 수 없다.
//		// System.out.println(calculator1.devide(15, 4));
//		
//		Calculator calculator2 = new CalculatorRandomImpl();
//		System.out.println(calculator2.sum(5, 3));
//		System.out.println(calculator2.minus(5, 3));

	}

}
