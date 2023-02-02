package com.ktdsuniversity.edu.service;

import java.util.List;

import com.ktdsuniversity.edu.dao.ListMemberDAOImpl;
import com.ktdsuniversity.edu.dao.MemberDAO;
import com.ktdsuniversity.edu.vo.MemberVO;

public class SecondMemberServiceImpl implements MemberService {

	private MemberDAO memberDAO;

	public SecondMemberServiceImpl() {
		memberDAO = new ListMemberDAOImpl();
	}

	@Override
	public boolean create(MemberVO menberVO) {
		System.out.println("SecondMemberServiceImpl.create");
		return memberDAO.create(menberVO) > 0;
	}

	@Override
	public List<MemberVO> readAll() {
		System.out.println("SecondMemberServiceImpl.readAll");
		return memberDAO.readAll();
	}

	@Override
	public MemberVO read(String id) {
		System.out.println("SecondMemberServiceImpl.read");
		return memberDAO.read(id);
	}

	@Override
	public MemberVO read(int index) {
		System.out.println("SecondMemberServiceImpl.read");
		return memberDAO.read(index);
	}

}
