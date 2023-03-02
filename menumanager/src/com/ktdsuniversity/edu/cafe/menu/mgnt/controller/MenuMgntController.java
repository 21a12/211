package com.ktdsuniversity.edu.cafe.menu.mgnt.controller;

import com.ktdsuniversity.edu.cafe.menu.mgnt.service.MainHandler;
import com.ktdsuniversity.edu.cafe.menu.mgnt.service.MenuMgntService;
import com.ktdsuniversity.edu.cafe.menu.mgnt.service.MenuMgntServiceImpl;

public class MenuMgntController {

	public static void main(String[] args) {

		MainHandler handler = new MainHandler();

		System.out.println("**Cafe Menu Management System**");

		handler.run();

	}

}
