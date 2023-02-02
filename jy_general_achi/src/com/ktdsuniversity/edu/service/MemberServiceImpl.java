package com.ktdsuniversity.edu.service;

import java.util.List;

import com.ktdsuniversity.edu.dao.MapMemberDAOImpl;
import com.ktdsuniversity.edu.dao.MemberDAO;
import com.ktdsuniversity.edu.vo.MemberVO;

public class MemberServiceImpl implements MemberService {

	private MemberDAO memberDAO;

	public MemberServiceImpl() {
		memberDAO = new MapMemberDAOImpl();
	}

	@Override
	public boolean create(MemberVO menberVO) {
		return memberDAO.create(menberVO) > 0;
	}

	@Override
	public List<MemberVO> readAll() {
		return memberDAO.readAll();
	}

	@Override
	public MemberVO read(String id) {
		return memberDAO.read(id);
	}

	@Override
	public MemberVO read(int index) {
		return memberDAO.read(index);
	}

}
