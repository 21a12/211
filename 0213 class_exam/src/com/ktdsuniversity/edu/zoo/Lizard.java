package com.ktdsuniversity.edu.zoo;

import com.ktdsuniversity.edu.zoo.inf.Crawlable;
import com.ktdsuniversity.edu.zoo.inf.Swimable;
import com.ktdsuniversity.edu.zoo.inf.Walkable;

public class Lizard implements Crawlable, Walkable, Swimable{
	
	@Override
	public void eat( ) {
		System.out.println("도매뱀 밥");
	}

	@Override
	public void bark() {
		System.out.println("도마뱀 악!");
	}
	
	@Override
	public void crawl() {
		System.out.println("도마뱀 기기");
	}
	
	@Override
	public void walk() {
		System.out.println("도마뱀 걷기");
	}
	
	@Override
	public void swim() {
		System.out.println("도마뱀 수영");
	}
	
}
