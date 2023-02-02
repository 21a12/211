package com.ktdsuniversity.edu.exceptions;

// 예외 클래스 만들기
public class NotSupportAgeException extends RuntimeException {

	private static final long serialVersionUID = -3071941030476310489L;

	public NotSupportAgeException() {
		super();
	}

	public NotSupportAgeException(String message) {
		super(message);
	}

}
