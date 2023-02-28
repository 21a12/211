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
			return cd.getcategoryList().get(itemTypeNum-1);
		} else {
			return "없음";
		}
	}
	
	public String typeSelect(String menuTitle) {
		
		while (true) {
			print.scanInt(menuTitle);
			input = scan.nextLine();

			if (exception.inputNum(input)) {
				itemTypeNum = Integer.parseInt(input);
				itemType = menuSelect(itemTypeNum);
//				if (itemTypeNum == 0) {
//					print.back();
//					break; // 뒤로안가고 빈칸진행되네;
//				}
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
		
		return itemType;
	}
	
}
