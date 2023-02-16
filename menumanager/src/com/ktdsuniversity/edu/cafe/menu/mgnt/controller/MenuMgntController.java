package com.ktdsuniversity.edu.cafe.menu.mgnt.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.ktdsuniversity.edu.cafe.menu.mgnt.service.MenuMgntService;
import com.ktdsuniversity.edu.cafe.menu.mgnt.service.MenuMgntServiceImpl;
import com.ktdsuniversity.edu.cafe.menu.mgnt.util.ExceptionUtil;
import com.ktdsuniversity.edu.cafe.menu.mgnt.util.Print;
import com.ktdsuniversity.edu.cafe.menu.mgnt.vo.MenuMgntVO;

public class MenuMgntController {

	public static void main(String[] args) {

		MenuMgntService service = new MenuMgntServiceImpl();
		ExceptionUtil exception = new ExceptionUtil();

		Scanner scan = new Scanner(System.in);
		Print print = new Print();

		System.out.println("**Cafe Menu Management System**");
		int menu;
		int itemTypeNum;
		String itemType;

		while (true) {
			print.menu();

			String input = scan.nextLine();

			if (exception.inputNum(input)) {
				menu = Integer.parseInt(input);
			} else {
				print.inputErr();
				continue;
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
				print.type();
				System.out.print("등록할 메뉴 타입 선택(숫자) : ");
				
				input = scan.nextLine();
				if (exception.inputNum(input)) {
					itemTypeNum = Integer.parseInt(input);
				} else {
					print.inputErr();
					continue;
				}

				itemType = print.menuSelect(itemTypeNum);
				if (itemType.equals("없음")) {
					System.out.println("유효하지않음 뒤로가기");
					continue;
				}

				System.out.print("등록할 메뉴 이름 작성(문자) : ");
				String itemName = scan.nextLine();

				MenuMgntVO name = new MenuMgntVO();
				name.setItemName(itemName);
				service.create(itemType, name);
				System.out.println("!!등록 완료!!");

			}

			// 수정 .update(itemType1, itemIdx, name)
			else if (menu == 2) {
				print.type();
				System.out.print("수정할 메뉴 타입 선택(숫자) : ");

				input = scan.nextLine();
				if (exception.inputNum(input)) {
					itemTypeNum = Integer.parseInt(input);
				} else {
					print.inputErr();
					continue;
				}

				itemType = print.menuSelect(itemTypeNum);
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

				System.out.print("수정할 아이템 인덱스 입력(숫자) : ");
				int itemIdx = scan.nextInt();
				scan.nextLine();

				if (itemIdx >= cnt) {
					System.out.println("유효하지않음 뒤로가기");
					continue;
				}

				System.out.print("수정할 메뉴 이름 작성(문자) : ");
				String itemName = scan.nextLine();

				MenuMgntVO name = new MenuMgntVO();
				name.setItemName(itemName);

				service.update(itemType, itemIdx, name);
				System.out.println("!!수정 완료!!");
			}

			// 삭제 .delete(itemType1, itemIdx)
			else if (menu == 3) {
				print.type();
				System.out.print("삭제할 메뉴 타입 선택(숫자) : ");
				
				input = scan.nextLine();
				if (exception.inputNum(input)) {
					itemTypeNum = Integer.parseInt(input);
				} else {
					print.inputErr();
					continue;
				}

				itemType = print.menuSelect(itemTypeNum);
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
				print.type();
				System.out.print("조회할 메뉴 타입 선택(숫자) : ");
				
				input = scan.nextLine();
				if (exception.inputNum(input)) {
					itemTypeNum = Integer.parseInt(input);
				} else {
					print.inputErr();
					continue;
				}

				itemType = print.menuSelect(itemTypeNum);
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
