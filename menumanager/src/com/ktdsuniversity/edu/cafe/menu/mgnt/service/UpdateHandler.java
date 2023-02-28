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

	public void run(int menu) {
		menuTitle = menuList.get(menu);
		print.type();

		while (true) {
			print.scanInt(menuTitle);
			input = scan.nextLine();

			if (exception.inputNum(input)) {
				itemTypeNum = Integer.parseInt(input);
				itemType = common.menuSelect(itemTypeNum);
				if (itemType.equals("없음")) {
					print.overRange();
					continue;
				} else {
					break;
				}
			} else {
				print.inputErr();
				itemTypeNum = 0;
				continue;
			}
		}

		int cnt = 0;
		for (MenuMgntVO itemList : MainHandler.service.readSome(itemType)) {
			System.out.printf("[%d] %s\n", cnt++, itemList.getItemName());
		}

		// 목록 없을 때 탈출
		if (cnt == 0) {
			System.out.println("아이템 목록이 존재하지 않음 ㅂ");
			continue;
		}

		int itemIdx = 0;

		while (true) {
			print.scanInt(menuTitle);
			input = scan.nextLine();

			if (exception.inputNum(input)) {
				itemIdx = Integer.parseInt(input);
				break;
			} else {
				print.inputErr();
				continue;
			}
		}

		if (itemIdx >= cnt) {
			print.overRange();
			continue;
		}

		while (true) {
			print.scanStr(menuTitle);
			String itemName = scan.nextLine();

			if (exception.inputStr(itemName)) {
				MenuMgntVO name = new MenuMgntVO();
				name.setItemName(itemName);
				MainHandler.service.update(itemType, itemIdx, name);
				print.complete(menuTitle);
				break;
			} else {
				print.inputErr();
				continue;
			}
		}
	}
	
}
