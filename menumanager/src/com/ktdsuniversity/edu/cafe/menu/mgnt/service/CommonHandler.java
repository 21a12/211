package com.ktdsuniversity.edu.cafe.menu.mgnt.service;

import java.util.Scanner;

import com.ktdsuniversity.edu.cafe.menu.mgnt.dao.CategoryDAO;
import com.ktdsuniversity.edu.cafe.menu.mgnt.util.ExceptionUtil;
import com.ktdsuniversity.edu.cafe.menu.mgnt.util.Print;

public class CommonHandler {

	ExceptionUtil exception = new ExceptionUtil();
	CategoryDAO cd = new CategoryDAO();

	Scanner scan = new Scanner(System.in);
	Print print = new Print();

	int itemTypeNum;
	String itemType;
	String menuTitle;
	String input = "";

	public String menuSelect(int itemTypeNum) {
		if (exception.checkCategorySize(itemTypeNum)) {
			return cd.getcategoryList().get(itemTypeNum - 1);
		} else {
			return "없음";
		}
	}

	public String typeSelect(String menuTitle) {

		while (true) {
			print.scanType(menuTitle, 1);
			input = scan.nextLine();

			if (input.equals("-")) {
				print.back();
				return "-";
			}

			if (exception.inputNum(input)) {
				itemTypeNum = Integer.parseInt(input);
				itemType = menuSelect(itemTypeNum);
				if (itemType.equals("없음")) {
					print.overRange();
					continue;
				} else {
					return itemType;
				}

			} else {
				print.inputErr();
				itemTypeNum = 0;
				continue;
			}

		}
	}

}
