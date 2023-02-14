package com.ktdsuniversity.edu.exceptions;

import java.util.HashMap;
import java.util.Map;

public class NullPointerExceptionTest {

	public static String getName(int nameLength) {

		if (nameLength == 2) {
			return "둘리";
		} else if (nameLength == 3) {
			return "이순재";
		} else if (nameLength == 4) {
			return "선우용녀";
		}

		return null;
	}

	public static String nullToEmpty(String string) {
		return string == null ? "" : string;
	}

	public static String nullToDefault(String string, String defaultValue) {
		return string == null ? defaultValue : string;
	}

	public static void main(String[] args) {

		
		String name = nullToEmpty(getName(5));
		System.out.println(name);
		name = nullToDefault(getName(5),"기본값 default");
		System.out.println(name);
		
//		String name = getName(5);
//		if (name == null) {
//			name = "";
//		}
//		System.out.println(name);
//		boolean isAStart = name.startsWith("A");
//		System.out.println(isAStart);

		Map<String, String> nameMap = new HashMap<>();
		nameMap.put("김", "김둘리");
		nameMap.put("이", "이둘리");
		nameMap.put("박", "박둘리");
		nameMap.put("최", "cccc");

		if (nameMap.containsKey("최") && nameMap.get("최").length() > 0) {
			String fullName = nameMap.get("최");
			String lastName = fullName.substring(0, 1);
			System.out.println(lastName);
		}

		String fullName = nullToEmpty(nameMap.get("최"));
		if (fullName.length() > 0) {
			String lastName = fullName.substring(0, 1);
			System.out.println(lastName);
		} else {
			System.out.println("데이터 없음");
		}

	}
}
