package com.ktdsuniversity.edu.todo.vo;

public class TodoVO {
	
	private String itenName;
	private boolean isSuccess;
	
	public TodoVO(String itemName) {
		setItenName(itemName);
	}

	public String getItenName() {
		return itenName;
	}

	public void setItenName(String itenName) {
		this.itenName = itenName;
	}

	public boolean isSuccess() {
		return isSuccess;
	}

	public void setSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}

}