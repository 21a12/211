package com.ktdsuniversity.edu.dao;

import java.util.List;

import com.ktdsuniversity.edu.vo.MemberVO;

public interface MemberDAO {
	
	public int create(MemberVO menberVO);
	public List<MemberVO> readAll();
	public default MemberVO read(String id) {
		return null;
	}
	// default를 사용하여 기본값을 제공할 수 있기 때문에
	// 재정의(@Override)를 하지 않으면 return값이 반환된다
	public default MemberVO read(int index) {
		return null;
	}
	
}
