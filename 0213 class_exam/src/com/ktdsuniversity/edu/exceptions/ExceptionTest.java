package com.ktdsuniversity.edu.exceptions;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class ExceptionTest {

	public static void main(String[] args) {

		
		List<String> lines = null;
		try {
			lines = Files.readAllLines(Paths.get("잘못된 경로"));
		} catch (IOException ioe) {
			try {
				lines = Files.readAllLines(Paths.get("올바른 경로"));
			}catch (IOException ioe2) {
				System.out.println("-?-");
			}
		}

		System.out.println("숫자로 변환 시작");

		String str = "ABC";
		try {
			int number = Integer.parseInt(str);
		} catch (NumberFormatException nfe) {
			System.out.println("변환중 에러발생 " + nfe.getMessage());
		}

		System.out.println("숫자로 변환 종료");
	}
}
