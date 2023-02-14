package com.ktdsuniversity.edu.infext;

public class VipMemberServiceImpl extends MemberServiceImpl implements VipMemberService {

	@Override
	public void regist() {
//		super.regist();
		System.out.println("VIP 회원 가입 완료");
		addPoint(1000);
	}
	
	@Override
	public void updateMyInfo() {
//		super.updateMyInfo();
		System.out.println("VIP 회원 정보 수정 완료");
		addPoint(50);
	}
	
	@Override
	public void addPoint(int point) {
		System.out.println(point + "포인트 지급");
	}

}
