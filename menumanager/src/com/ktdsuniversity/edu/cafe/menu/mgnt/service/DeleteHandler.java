package com.ktdsuniversity.edu.cafe.menu.mgnt.service;

import java.util.List;
import java.util.Scanner;

import com.ktdsuniversity.edu.cafe.menu.mgnt.dao.MenuListDAO;
import com.ktdsuniversity.edu.cafe.menu.mgnt.util.ExceptionUtil;
import com.ktdsuniversity.edu.cafe.menu.mgnt.util.Print;
import com.ktdsuniversity.edu.cafe.menu.mgnt.vo.MenuMgntVO;

public class DeleteHandler {
	
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
		
		while (true) {
			print.scanType(menuTitle,1);
			input = scan.nextLine();
			
			if (input.equals("-")) {
				return 0;
			}
			
			if (exception.inputNum(input)) {
				itemIdx = Integer.parseInt(input);
				if (itemIdx >= cnt) {
					print.overRange();
					continue;
				}
				MainHandler.service.delete(itemType, itemIdx);
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
