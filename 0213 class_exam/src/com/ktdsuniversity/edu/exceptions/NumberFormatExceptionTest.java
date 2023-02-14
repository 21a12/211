package com.ktdsuniversity.edu.exceptions;

public class NumberFormatExceptionTest {
	
	public static boolean isInteger(String string) {
		if (string == null) {
			return false;
		}
		return string.matches("^[0-9]+$");
	}
	
	public static void main(String[] args) {

		System.out.println(isInteger("12345"));
		System.out.println(isInteger("123.45"));
		System.out.println(isInteger("123. 45"));
		System.out.println(isInteger("ABC"));
		
		String str = "1234";
		if (isInteger(str)) {
			int num = Integer.parseInt(str);
			System.out.println(num);
		}
		
		try {
			Integer.parseInt("affff");
		} catch (NumberFormatException nfe) {
			System.out.println("에러임");
		}
		
	}

}
