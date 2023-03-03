package com.ktdsuniversity.edu.cafe.menu.mgnt.service;

import java.util.List;
import java.util.Scanner;

import com.ktdsuniversity.edu.cafe.menu.mgnt.dao.MenuListDAO;
import com.ktdsuniversity.edu.cafe.menu.mgnt.util.ExceptionUtil;
import com.ktdsuniversity.edu.cafe.menu.mgnt.util.Print;
import com.ktdsuniversity.edu.cafe.menu.mgnt.vo.MenuMgntVO;

public class UpdateHandler {

	ExceptionUtil exception = new ExceptionUtil();

	Scanner scan = new Scanner(System.in);
	Print print = new Print();
	MenuListDAO menuDAO = new MenuListDAO();
	List<String> menuList = menuDAO.getMainMenuList();
	CommonHandler common = new CommonHandler();

	int itemTypeNum;
	String itemType;
	String menuTitle;
	String input = "";
	
	String itemName;
	int price;
	int stock;
	String soldout;

	public int run(int menu) {

		menuTitle = menuList.get(menu);
		print.type(menuTitle);

		itemType = common.typeSelect(menuTitle);
		if (itemType.equals("-")) {
			return 0;
		}

		int cnt = 0;
		for (MenuMgntVO itemList : MainHandler.service.readSome(itemType)) {
			System.out.printf("[%d] %s\n", cnt++, itemList.getItemName());
		}

		// 목록 없을 때 탈출
		if (cnt == 0) {
			print.notFound();
			return 0;
		}

		int itemIdx = 0;

		// itemIdx : 메뉴타입 선택
		while (true) {
			print.scanType(menuTitle, 1);
			input = scan.nextLine();

			if (exception.inputNum(input)) {
				itemIdx = Integer.parseInt(input);
				if (itemIdx >= cnt) {
					print.overRange();
					continue;
				}
				break;
			} else {
				print.inputErr();
				continue;
			}
		}
		
		// itemName : 아이템 이름
		while (true) {
			print.scanType(menuTitle, "a");
			input = scan.nextLine();
			
			if (input.equals("-")) {
				return 0;
			}

			if (exception.inputStr(input)) {
				MenuMgntVO name = new MenuMgntVO();
				name.setItemName(input);
				MainHandler.service.update(itemType, itemIdx, name);
				print.complete(menuTitle);
				break;
			} else {
				print.inputErr();
				continue;
			}
		}
		
//		// price : 아이템 가격
//		while (true) {
//			
//		}
		return 1;
	}

}
