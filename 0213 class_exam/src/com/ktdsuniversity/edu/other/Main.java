package com.ktdsuniversity.edu.other;

// 다른 패키지의 클래스를 사용하기 위해 import를 함 
import com.ktdsuniversity.edu.member.MemberService;

public class Main {

	public static void main(String[] args) {
		//	클래스를 사용하기 위한 인스턴스화 
		//	(reference Type) 변수로 사용하면 .을 사용할 수 있다
		//	선언:클래스명		변수		=	생성자
		MemberService memberService = new MemberService(); 
		
		memberService.setUserName("JMC");
		String userName = memberService.getUserName();
		System.out.println(userName);
		memberService.join();
//		memberService.login();	// login은 private로 선언되어 선언된 클래스 외에서 사용될 수 없음.
//		memberService.quit();	// quit 선언 시 접근제한자를 작성하지 않아 default 로 자동 선언됨.
								// default로 선언되어, 선언된 패키지를 이탈 시 사용할 수 없음.
		
		System.out.println(userName.length() > 3);
		
		
		
		
	}
}
