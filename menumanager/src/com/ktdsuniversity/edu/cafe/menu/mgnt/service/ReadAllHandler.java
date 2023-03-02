package com.ktdsuniversity.edu.cafe.menu.mgnt.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.ktdsuniversity.edu.cafe.menu.mgnt.dao.MenuListDAO;
import com.ktdsuniversity.edu.cafe.menu.mgnt.util.ExceptionUtil;
import com.ktdsuniversity.edu.cafe.menu.mgnt.util.Print;
import com.ktdsuniversity.edu.cafe.menu.mgnt.vo.MenuMgntVO;

public class ReadAllHandler {

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
		
		Map<String, List<MenuMgntVO>> mapList = new HashMap<>(MainHandler.service.readAll());
		for (String type : mapList.keySet()) {
//			if(mapList.get(type).size() == 0) {
//				continue;
//			}
			int cnt = 0;
			System.out.println("====	" + type + "	====");
			for (MenuMgntVO itemList : mapList.get(type)) {
				itemName = itemList.getItemName();
				price = itemList.getPrice();
				stock = itemList.getStock();
				soldout = itemList.isSoldout()? "Y" : "N" ;

				System.out.printf("[%d] %s\t\t %d\t\t %d\t\t %s\n ",
							cnt++, itemName, price, stock, soldout);
			}
		}

		System.out.println("조회완료 아무키나 누르시오");
		scan.nextLine();
		
		return 1;
	}


	
}
