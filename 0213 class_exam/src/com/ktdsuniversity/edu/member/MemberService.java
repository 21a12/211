package com.ktdsuniversity.edu.member;

public class MemberService {

	private String userName;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void join() {
		System.out.println("회원가입");
	}

	// private의 사용 범위를 확인해보기위해 public이 아닌 private로 선언해봄.
	private void login() {
		System.out.println("로그인");
	}

	// 접근제한자가 없을경우 default 로 할당
	void quit() {
		System.out.println("탈퇴");
	}

}
