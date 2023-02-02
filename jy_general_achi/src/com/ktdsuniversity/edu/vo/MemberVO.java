package com.ktdsuniversity.edu.vo;

			// 자녀클래스    상속     부모클래스
public class MemberVO extends AbstractVO {

	private String id;
	private String password;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
