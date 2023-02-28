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

	static MenuMgntService service = new MenuMgntServiceImpl();
	public static CategoryDAO cd = new CategoryDAO();
	static ExceptionUtil exception = new ExceptionUtil();

	Scanner scan = new Scanner(System.in);
	Print print = new Print();
	MenuListDAO menuDAO = new MenuListDAO();
	List<String> menuList = menuDAO.getMainMenuList();
	CommonHandler common = new CommonHandler();
	
	CreateHandler create = new CreateHandler();

	int menu;
	int itemTypeNum;
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
				create.run(menu);

			}

			// 수정 .update(itemType1, itemIdx, name)
			else if (menu == 2) {
//				menuTitle = menuList.get(menu);
//				print.type();
//
//				while (true) {
//					print.scanInt(menuTitle);
//					input = scan.nextLine();
//
//					if (exception.inputNum(input)) {
//						itemTypeNum = Integer.parseInt(input);
//						itemType = common.menuSelect(itemTypeNum);
//						if (itemType.equals("없음")) {
//							print.overRange();
//							continue;
//						} else {
//							break;
//						}
//					} else {
//						print.inputErr();
//						itemTypeNum = 0;
//						continue;
//					}
//				}
//
//				int cnt = 0;
//				for (MenuMgntVO itemList : service.readSome(itemType)) {
//					System.out.printf("[%d] %s\n", cnt++, itemList.getItemName());
//				}
//
//				// 목록 없을 때 탈출
//				if (cnt == 0) {
//					System.out.println("아이템 목록이 존재하지 않음 ㅂ");
//					continue;
//				}
//
//				int itemIdx = 0;
//
//				while (true) {
//					print.scanInt(menuTitle);
//					input = scan.nextLine();
//
//					if (exception.inputNum(input)) {
//						itemIdx = Integer.parseInt(input);
//						break;
//					} else {
//						print.inputErr();
//						continue;
//					}
//				}
//
//				if (itemIdx >= cnt) {
//					print.overRange();
//					continue;
//				}
//
//				while (true) {
//					print.scanStr(menuTitle);
//					String itemName = scan.nextLine();
//
//					if (exception.inputStr(itemName)) {
//						MenuMgntVO name = new MenuMgntVO();
//						name.setItemName(itemName);
//						service.update(itemType, itemIdx, name);
//						print.complete(menuTitle);
//						break;
//					} else {
//						print.inputErr();
//						continue;
//					}
//				}
			}

			// 삭제 .delete(itemType1, itemIdx)
			else if (menu == 3) {
				menuTitle = menuList.get(menu);
				print.type();

				input = scan.nextLine();
				if (exception.inputNum(input)) {
					itemTypeNum = Integer.parseInt(input);
				} else {
					print.inputErr();
					continue;
				}

				itemType = common.menuSelect(itemTypeNum);
				if (itemType.equals("없음")) {
					System.out.println("유효하지않음 뒤로가기");
					continue;
				}

				int cnt = 0;
				for (MenuMgntVO itemList : service.readSome(itemType)) {
					System.out.printf("[%d] %s\n", cnt++, itemList.getItemName());
				}
				;

				// 목록 없을 때 탈출
				if (cnt == 0) {
					System.out.println("아이템 목록이 존재하지 않음 ㅂ");
					continue;
				}

				System.out.print("삭제할 아이템 인덱스 입력(숫자) : ");
				int itemIdx = scan.nextInt();
				scan.nextLine();

				service.delete(itemType, itemIdx);
				System.out.println("!!삭제 완료!!");

			}

			// 조회...단일 .readSome(itemType)
			else if (menu == 4) {
				menuTitle = menuList.get(menu);
				print.type();
				print.scanInt(menuTitle);

				input = scan.nextLine();
				if (exception.inputNum(input)) {
					itemTypeNum = Integer.parseInt(input);
				} else {
					print.inputErr();
					continue;
				}

				itemType = common.menuSelect(itemTypeNum);
				if (itemType.equals("없음")) {
					System.out.println("유효하지않음 뒤로가기");
					continue;
				}

				int cnt = 0;
				for (MenuMgntVO itemList : service.readSome(itemType)) {
					System.out.printf("[%d] %s\n", cnt++, itemList.getItemName());
				}
				;

				// 목록 없을 때 탈출
				if (cnt == 0) {
					System.out.println("아이템 목록이 존재하지 않음 ㅂ");
					continue;
				}

				System.out.print("조회할 아이템 인덱스 입력(숫자) : ");
				int itemIdx = scan.nextInt();
				scan.nextLine();

				if (itemIdx > cnt) {
					System.out.println("유효하지않음 뒤로가기");
					continue;
				}

				System.out.println(service.read(itemType, itemIdx).getItemName());

			}

			// 조회...전체
			else if (menu == 5) {
				Map<String, List<MenuMgntVO>> mapList = new HashMap<>(service.readAll());
				for (String type : mapList.keySet()) {
					System.out.println("====	" + type + "	====");
					for (MenuMgntVO item : mapList.get(type)) {
						System.out.println(item.getItemName());
					}
				}

			}

			else {
				System.out.println("번호 잘눌러줭");
			}
		}

	}

}
