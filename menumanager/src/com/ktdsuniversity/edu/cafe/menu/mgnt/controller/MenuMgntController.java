package com.ktdsuniversity.edu.cafe.menu.mgnt.controller;

import com.ktdsuniversity.edu.cafe.menu.mgnt.service.MainHandler;

public class MenuMgntController {

	public static void main(String[] args) {

		MainHandler handler = new MainHandler();

		System.out.println("**Cafe Menu Management System**");

		handler.run();

	}

}
