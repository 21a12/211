package com.ktdsuniversity.edu.cafe.menu.mgnt.util;

import com.ktdsuniversity.edu.cafe.menu.mgnt.dao.MenuListDAO;
import com.ktdsuniversity.edu.cafe.menu.mgnt.service.MainHandler;

public class Print {

	ExceptionUtil exception = new ExceptionUtil();
	MenuListDAO mld = new MenuListDAO();

	String menuTitle = "";
	String categoryTitle = "";

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
		divideLine();
		for (int i = 0; i < mld.getMainMenuList().size(); i++) {
			if (i + 1 < mld.getMainMenuList().size()) {
				menuTitle = mld.getMainMenuList().get(i + 1);
				System.out.printf("%d. %s\n", i + 1, menuTitle);
			} else {
				menuTitle = mld.getMainMenuList().get(0);
				System.out.printf("%d. %s\n", i + 1, menuTitle);
			}
		}
		divideLine();
	}

	public void type(String str) {
//		System.out.println("===등록 메뉴 타입 선택===\r\n"
//				+ "1. 커피\r\n"
//				+ "2. 음료\r\n"
//				+ "3. 티\r\n"
//				+ "4. 디저트\r\n"
//				+ "====뒤로가기 아무버튼====");
		System.out.printf("===%s 메뉴 타입 선택===\n", str);
		for (int i = 0; i < MainHandler.cd.getcategoryList().size(); i++) {
			categoryTitle = MainHandler.cd.getcategoryList().get(i);
			System.out.printf("%d. %s\n", i + 1, categoryTitle);
		}
		System.out.println("==== 뒤로가기 [-] ====");
	}

	public void menuInput() {
		System.out.print("메뉴 선택(숫자) : ");
	}

	public void complete(String str) {
		System.out.printf("!!%s 완료!!\n", str);
	}

	/**
	 * @param str 메뉴 타이틀 (생성,수정,삭제,조회)
	 * @param s 입력타입 선택 [ String / int ]
	 */
	public void scanType(String str, String s) {
		System.out.print(str + "할 메뉴 타입 선택(문자) : ");
	}

	/**
	 * @param str 메뉴 타이틀 (생성,수정,삭제,조회)
	 * @param i 입력타입 선택 [ String / int ]
	 */
	public void scanType(String str, int i) {
		System.out.print(str + "할 메뉴 타입 선택(숫자) : ");
	}

	public void inputErr() {
		System.out.println("잘못된 입력");
	}

	public void overRange() {
		System.out.println("범위 유효하지않음 뒤로가기");
	}

	public void divideLine() {
		System.out.println("====================");
	}

	public void back() {
		System.out.println("[-] 입력...이전으로");
	}

	public void typeTitleLine(String str) {
		System.out.printf("===%s 메뉴 타입 선택===\n", str);
	}

	public void notFound() {
		System.out.println("아이템 목록이 존재하지 않음 ㅂ");
	}
}
