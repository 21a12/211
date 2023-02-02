package com.ktdsuniversity.edu.todo.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.ktdsuniversity.edu.todo.vo.TodoVO;

public class TodoDAO {

	private static int count = 1;

	private Map<Integer, TodoVO> dataSource;

	public TodoDAO() {
		dataSource = new HashMap<>();
	}

	// 등록
	public int create(String itemName) {
		dataSource.put(count++, new TodoVO(itemName));
		return 1;
	}

	// 조회..단일
	public TodoVO read(int key) {
		return dataSource.get(key);
	}

	// 조회..전부
	public List<TodoVO> readAll() {
		return dataSource.entrySet()
							.stream()
							.map(entry -> entry.getValue())
							.collect(Collectors.toList());
	}

	// 수정
	public int update(int key, boolean isSuccess) {
		dataSource.get(key).setSuccess(isSuccess);
		return 1;
	}

	// 삭제..단일
	public int delete(int key) {
		dataSource.remove(key);
		return 1;
	}

	// 삭제..전부
	public int deleteAll() {
		int size = dataSource.size();
		dataSource.clear();
		return size;
	}

}