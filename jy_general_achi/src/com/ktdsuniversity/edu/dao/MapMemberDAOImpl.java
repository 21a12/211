package com.ktdsuniversity.edu.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.ktdsuniversity.edu.vo.MemberVO;

public class MapMemberDAOImpl implements MemberDAO {

	private Map<String, MemberVO> dataSource;
	
	public MapMemberDAOImpl() {
		dataSource = new HashMap<>();
	}
	
	@Override
	public int create(MemberVO memberVO) {
		dataSource.put(memberVO.getId(), memberVO);
		return 1;
	}

	@Override
	public List<MemberVO> readAll() {
		return dataSource.entrySet()
						.stream()
						.map(entry -> entry.getValue())
						.collect(Collectors.toList());
	}

	@Override
	public MemberVO read(String id) {
		return dataSource.get(id);
	}
	
//	인터페이스 MemberDAO에서 read를 default 메소드로 선언하였기 때문에
//	필요하지 않은 read를 정의하지 않아도 된다.
	
//	@Override
//	public MemberVO read(int index) {
//		return null;
//	}

}
