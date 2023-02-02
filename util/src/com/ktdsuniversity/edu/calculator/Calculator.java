package com.ktdsuniversity.edu.calculator;

import java.util.Scanner;

import com.ktdsuniversity.edu.exceptions.NotSupportAgeException;
import com.ktdsuniversity.edu.util.NumberUtil;

public class Calculator {

	public static void checkAge(int age) {
		if (age > 150) {
			throw new NotSupportAgeException("값 151이상 불가");
		}
	}

	public static void main(String[] args) {

		checkAge(10);

		try {
			checkAge(200);
		} 
		catch (NotSupportAgeException nsae) {
			System.out.println(nsae.getMessage());
		}
		
		
		
		Scanner scanner = new Scanner(System.in);
		String string = scanner.nextLine();

		// byte로 변경
		byte toByte = NumberUtil.toByte(string, (byte) 11);

		System.out.print(toByte);

		short toShort = NumberUtil.toShort(string, (short) 22);
		System.out.println(toShort);

		int toInt = NumberUtil.toInt(string, 33);
		System.out.println(toInt);

		long toLong = NumberUtil.toLong(string, 44l); //long 캐스팅 : 숫자l
		System.out.println(toLong);
		
		float toFloat = NumberUtil.toFloat(string, 55f); //float 캐스팅 : 숫자f
		
		double toDouble = NumberUtil.toDouble(string, (double)66);

	}

}
