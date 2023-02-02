package com.ktdsuniversity.edu.service;

import java.util.List;

import com.ktdsuniversity.edu.vo.MemberVO;

public interface MemberService {

	public boolean create(MemberVO menberVO);

	public List<MemberVO> readAll();

	public MemberVO read(String id);
	public MemberVO read(int index);

}
