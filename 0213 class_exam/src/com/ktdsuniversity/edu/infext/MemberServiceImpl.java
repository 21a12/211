package com.ktdsuniversity.edu.infext;

public class MemberServiceImpl implements MemberService{

	@Override
	public void regist() {
		System.out.println("회원 가입 완료");
	}

	@Override
	public void unregist() {
		System.out.println("회원 탈퇴 완료");
	}

	@Override
	public void updateMyInfo() {
		System.out.println("회원 정보 수정 완료");
	}

}
