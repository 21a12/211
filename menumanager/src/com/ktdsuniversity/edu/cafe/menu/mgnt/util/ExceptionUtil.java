package com.ktdsuniversity.edu.cafe.menu.mgnt.util;

public class ExceptionUtil {

	public boolean inputNum(String input) {
		return this.inputNull(input) && 
				(input.length() == input.replaceAll("[^0-9]","").length());
	}
	
	public boolean inputStr(String input) {
		return this.inputNull(input) && 
				(input.length() == input.replaceAll("[^가-힣a-zA-Z]", "").length());
	}
	public boolean inputNull(String input) {
		return input != null;
	}
	
}
