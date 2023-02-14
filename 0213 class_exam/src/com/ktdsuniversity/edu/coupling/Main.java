package com.ktdsuniversity.edu.coupling;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		
		// Sub class is SUper class
		// 상속 순서 Iterable > Collection > List > ArrayList
		Iterable<String> iterable = new ArrayList<>();
//		iterable.get(0);
		iterable.forEach(null);
		
		Collection<Integer> collection = new ArrayList<>();
//		collection.get(0);
		collection.forEach(null);
		
		List<String> list = new ArrayList<>();
		list.get(0);	// get은 list에서 추가된 메소드
		list.forEach(null);	// forEach 는 Iterable에서 정의되어 상속받은 모든 클래스에서 사용 가능
		
		//	인터페이스(부모)		변수명		=	구현클래스(자식)
		MemberManagement memberService = new MemberService();
		memberService.regist();
		memberService.unregist();
		memberService.updateMyInfo();

	}

}
