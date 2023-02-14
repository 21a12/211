package com.ktdsuniversity.edu.method;

public class Welcome {

	// 가변인자 사용 시 ...보다 []배열을 더 자주 사용한다.
	// 메소드명(type[] ~, type ~) 로 배열과 다른 파라미터를 쉽게 구분할 수 있음.
	public String greetings(String[] message) {
		String welcomeMessage = "";
		for (String msg : message) {
			welcomeMessage += msg + "님, ";
		}
		return welcomeMessage;
	}
	
	// 가변인자 사용법
	// (type...) ...을 사용함으로써 파라미터의 개수 제한을 해제
	// message에 커서를 올려보면 타입이 String[] (배열)로 되어있다.
	// 때문에 type...과 type[]는 별개로 사용되지 않고 같다고 본다.
	public String greeting(String... message) {
		String welcomeMessage = "";
		for (String msg : message) {
			welcomeMessage += msg + "님, ";
		}
		return welcomeMessage;
	}
	
	public String greeting() {
		return "안녕하세요?";
	}

	public String greeting(String name) {
		return name + "님, 안녕하세요?";
	}

	public String greeting(String name, String message) {
		return name + "님, " + message;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
