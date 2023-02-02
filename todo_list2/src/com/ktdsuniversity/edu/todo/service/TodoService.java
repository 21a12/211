package com.ktdsuniversity.edu.todo.service;

import java.util.List;

import com.ktdsuniversity.edu.todo.dao.TodoDAO;
import com.ktdsuniversity.edu.todo.vo.TodoVO;

// DAO와 Controller 사이의 중개자
// C,U,D ...true/false값으로 반환... R ...List로 반환
public class TodoService {

	// TodoDAO 클래스 인스턴스화
	private TodoDAO todoDAO;

	// 생성자
	public TodoService() {
		todoDAO = new TodoDAO();
	}

	// 등록
	public boolean create(String itemName) {
		return todoDAO.create(itemName) > 0;
	}

	// 조회..단일
	public TodoVO read(int key) {
		return todoDAO.read(key);
	}

	// 조회..전부
	public List<TodoVO> readAll() {
		return todoDAO.readAll();

	}

	// 수정
	public boolean update(int key, boolean isSuccess) {
		return todoDAO.update(key, isSuccess) > 0;
	}

	// 삭제..단일
	public boolean delete(int key) {
		return todoDAO.delete(key) > 0;
	}

	// 삭제..전부
	public boolean deleteAll() {
		return todoDAO.deleteAll() > 0;
	}
}