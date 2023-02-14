package com.ktdsuniversity.edu.exceptions;

import java.util.HashMap;
import java.util.Map;

public class ThrowNewTest {

	static Map<String, String> memberMap = new HashMap<>();

	public static boolean isCreate(String memberID) {
		if (memberMap.containsKey(memberID)) {
			throw new DuplicateMemberIDException(memberID);
		}
		memberMap.put(memberID, "생성" + memberID);
		return memberMap.containsKey(memberID);
	}

	public static void main(String[] args) {
		boolean isCreate = isCreate("ktds0601");
		System.out.println(isCreate);
		
		isCreate = isCreate("ktds0601");
		System.out.println(isCreate);
		
		System.out.println("가입 완료");
		
	}

}
