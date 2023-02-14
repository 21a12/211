package com.ktdsuniversity.edu.infext;

public class Main {
	
	public static void memberManage(MemberService memberService) {
		memberService.regist();
		memberService.updateMyInfo();
		
		// 서브클래스를 구분하여 기능을 사용할 때
		// 조건을 확인하여 전달된 파라미터를 원하는 타입으로 캐스팅 함
//		if (memberService instanceof VipMemberService) {
//			VipMemberService vipMemberService = (VipMemberService) memberService;
//			vipMemberService.addPoint(50);
//			((VipMemberService) memberService).addPoint(50);
//		}
		
		memberService.unregist();
	}

	public static void main(String[] args) {
		
		MemberService memberService = new MemberServiceImpl();
		MemberService vipMemberService = new VipMemberServiceImpl();
		
		memberManage(memberService);
		memberManage(vipMemberService);
		
		
		
//		// Sub class is a Super class
//		
////		(interface)MemberService
////			ㄴ> (class)MemberSerivceImpl
//		MemberService memberService = new MemberServiceImpl();
//		memberService.regist();
//		memberService.unregist();
//		memberService.updateMyInfo();
//		
////		(interface)MemberService 
////			ㄴ> (interface)VipMemberService
////				ㄴ> (class)VipMemberSerivceImpl
//		MemberService vipMemberService = new VipMemberServiceImpl();
//		vipMemberService.regist();
//		vipMemberService.unregist();
//		vipMemberService.updateMyInfo();
////		vipMemberService.addPoint(100); // (interface)MemberService에서는
////										//	addPoint가 구현되지않아 호출할순 없음.
		
	}
	
}
