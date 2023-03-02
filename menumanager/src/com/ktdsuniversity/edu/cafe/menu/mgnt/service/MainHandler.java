package com.ktdsuniversity.edu.cafe.menu.mgnt.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.ktdsuniversity.edu.cafe.menu.mgnt.dao.CategoryDAO;
import com.ktdsuniversity.edu.cafe.menu.mgnt.dao.MenuListDAO;
import com.ktdsuniversity.edu.cafe.menu.mgnt.util.ExceptionUtil;
import com.ktdsuniversity.edu.cafe.menu.mgnt.util.Print;
import com.ktdsuniversity.edu.cafe.menu.mgnt.vo.MenuMgntVO;

public class MainHandler {

	public static final MenuMgntService service = new MenuMgntServiceImpl();
	public static CategoryDAO cd = new CategoryDAO();
	static ExceptionUtil exception = new ExceptionUtil();

	Scanner scan = new Scanner(System.in);
	Print print = new Print();
	MenuListDAO menuDAO = new MenuListDAO();
	List<String> menuList = menuDAO.getMainMenuList();
	CommonHandler common = new CommonHandler();

	CreateHandler create = new CreateHandler();
	UpdateHandler update = new UpdateHandler();
	DeleteHandler delete = new DeleteHandler();
	ReadSomeHandler readSome = new ReadSomeHandler();
	ReadAllHandler readAll = new ReadAllHandler();

	int menu;
	int itemTypeNum;
	int result;
	String itemType;
	String menuTitle;

	public void run() {

		while (true) {
			print.menu();

			String input = "";
			while (true) {
				print.menuInput();
				input = scan.nextLine();
				if (exception.inputNum(input)) {
					if (exception.checkMenuSize(Integer.parseInt(input))) {
						menu = Integer.parseInt(input);
						break;
					} else {
						print.overRange();
						continue;
					}
				} else {
					print.inputErr();
					continue;
				}
			}

			if (menu == 6) {
				System.out.println("ㄹㅇ 종료? Y/N");
				String ans = scan.nextLine();
				if (ans.equalsIgnoreCase("Y")) {
					System.out.println("Y를 눌렀음. 종료됨");
					break;
				} else {
					System.out.println("취소임 처음으로 돌아감, 아무키나 누르셈");
					scan.nextLine();
				}
			}
			// 등록 .create(itemType1, name)
			else if (menu == 1) {

				result = create.run(menu);

				if (result == 0) {
					continue;
				}
			}

			// 수정 .update(itemType1, itemIdx, name)
			else if (menu == 2) {

				result = update.run(menu);

				if (result == 0) {
					continue;
				}
			}

			// 삭제 .delete(itemType1, itemIdx)
			else if (menu == 3) {

				result = delete.run(menu);

				if (result == 0) {
					continue;
				}
			}

			// 조회...종류 .readSome(String itemType, int itemIdx)
			else if (menu == 4) {
				
				result = readSome.run(menu);
				
				if (result == 0) {
					continue;
				}

			}

			// 조회...전체
			else if (menu == 5) {
				
				readAll.run(menu);

			}

			else {
				print.overRange();
			}
		}

	}

}
