package com.ktdsuniversity.edu.controller;

import com.ktdsuniversity.edu.service.MemberService;
import com.ktdsuniversity.edu.service.MemberServiceImpl;
import com.ktdsuniversity.edu.vo.MemberVO;

public class MemberController {

	public static void main(String[] args) {

		// MemberService 인터페이스 에서 MemberServiceImpl을 쓴다
		MemberService service = new MemberServiceImpl();

		// MemberVO는 AbstractVO를 상속받았기에 ReadNumber와 PageNumber 사용 가능
		MemberVO member = new MemberVO();
		member.setId("id1");
		member.setPassword("pwd1");
		member.setReadNumber(1);
		member.setPageNumber(0);
		service.create(member);

		member = new MemberVO();
		member.setId("id2");
		member.setPassword("pwd2");
		member.setReadNumber(2);
		member.setPageNumber(0);
		service.create(member);
		
		member = new MemberVO();
		member.setId("id3");
		member.setPassword("pwd3");
		member.setReadNumber(3);
		member.setPageNumber(0);
		service.create(member);
//		
//		List<MemberVO> memberList = service.readAll();
//		for (MemberVO eachMember : memberList) {
//			System.out.println(eachMember.getId());
//			System.out.println(eachMember.getPassword());
//			System.out.println(eachMember.getReadNumber());
//			System.out.println(eachMember.getPageNumber());
//		}
//		
		System.out.println("하나읽어오기");
		MemberVO oneMember = service.read("id1");
		System.out.println(oneMember.getId());
		System.out.println(oneMember.getPassword());
		System.out.println(oneMember.getReadNumber());
		System.out.println(oneMember.getPageNumber());

		
		
		try {
					// parseInt..String으로 입력된 숫자를 int로 변환
			int number = Integer.parseInt("abc");
		}
		catch (NumberFormatException e){
			// 에러 메시지 출력
			System.out.println("에러발생:"+e.getMessage());
			// 에러 경로 출력
			e.printStackTrace();
		}
		finally {
			System.out.println(1);
		}
		
		
		
	}
}
