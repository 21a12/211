package com.ktdsuniversity.edu.cafe.menu.mgnt.service;

import java.util.List;
import java.util.Scanner;

import com.ktdsuniversity.edu.cafe.menu.mgnt.dao.MenuListDAO;
import com.ktdsuniversity.edu.cafe.menu.mgnt.util.ExceptionUtil;
import com.ktdsuniversity.edu.cafe.menu.mgnt.util.Print;
import com.ktdsuniversity.edu.cafe.menu.mgnt.vo.MenuMgntVO;

public class CreateHandler {

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

	public int run(int menu) {

		menuTitle = menuList.get(menu);
		print.type(menuTitle);

		itemType = common.typeSelect(menuTitle);
		if (itemType.equals("-")) {
			return 0;
		}

		while (true) {
			print.scanType(menuTitle, "a");
			input = scan.nextLine();
			
			if (input.equals("-")) {
				return 0;
			}

			if (exception.inputStr(input)) {
				MenuMgntVO name = new MenuMgntVO();
				name.setItemName(input);
				MainHandler.service.create(itemType, name);
				print.complete(menuTitle);
				break;
			} else {
				print.inputErr();
				continue;
			}
		}
		return 1;
	}

}
