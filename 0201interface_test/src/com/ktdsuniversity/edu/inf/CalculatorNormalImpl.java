package com.ktdsuniversity.edu.inf;

public class CalculatorNormalImpl implements Calculator {

	@Override
	public int sum(int numberOne, int numberTwo) {
		return numberOne + numberTwo;
	}

	@Override
	public int minus(int numberOne, int numberTwo) {
		return numberOne - numberTwo;
	}
	
	// 인터페이스에 정의되어있지 않아 Override 되지않음.
	// 사용하려면 해당 타입을 CalculatorNomalImple로 선언해야 한다. 
	public int devide(int numberOne, int numberTwo) {
		return numberOne / numberTwo;
	}

}
