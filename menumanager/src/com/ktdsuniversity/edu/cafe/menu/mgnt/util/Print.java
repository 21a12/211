package com.ktdsuniversity.edu.cafe.menu.mgnt.util;

import com.ktdsuniversity.edu.cafe.menu.mgnt.dao.CategoryDAO;
import com.ktdsuniversity.edu.cafe.menu.mgnt.dao.MenuListDAO;

public class Print {

	private String str;
	
	/**
	 * 기본화면 - Mgnt 전체 메뉴 출력
	 */
	public void menu() {
//		System.out.println("====메뉴를 선택하세요====\r\n"
//				+ "1. 등록\r\n"
//				+ "2. 수정\r\n"
//				+ "3. 삭제\r\n"
//				+ "4. 조회...단일\r\n"
//				+ "5. 조회...전체\r\n"
//				+ "6. 종료\r\n"
//				+ "====================");
		MenuListDAO mld = new MenuListDAO();
		String menuTitle = "";
		System.out.println("====================");
		for (int i = 0; i < mld.getMainMenuList().size(); i++) {
			if (i + 1 < mld.getMainMenuList().size()) {
				menuTitle = mld.getMainMenuList().get(i + 1);
				System.out.printf("%d. %s\n", i + 1, menuTitle);
			} else {
				menuTitle = mld.getMainMenuList().get(0);
				System.out.printf("%d. %s\n", i + 1, menuTitle);
			}
		}
		System.out.println("====================");

	}
	
	public void type() {
//		System.out.println("===등록 메뉴 타입 선택===\r\n"
//				+ "1. 커피\r\n"
//				+ "2. 음료\r\n"
//				+ "3. 티\r\n"
//				+ "4. 디저트\r\n"
//				+ "====뒤로가기 아무버튼====");
		CategoryDAO cd = new CategoryDAO();
		String categoryTitle = "";
	}

	public String menuSelect(int num) {
		if (num == 1) {
			return "커피";
		} else if (num == 2) {
			return "음료";
		} else if (num == 3) {
			return "티";
		} else if (num == 4) {
			return "디저트";
		} else {
			return "없음";
		}
	}

	public void waitForInputInt(String str, int num) {
		System.out.print(str + "할 메뉴 타입 선택(숫자) : ");
	}
	
	public void waitForInputStr(String str) {
		System.out.print(str + "할 메뉴 타입 선택(문자) : ");
	}
	
	public void inputErr() {
		System.out.println("잘못된 입력");
	}

}
