package com.ktdsuniversity.edu.zoo;

import com.ktdsuniversity.edu.zoo.inf.Swimable;
import com.ktdsuniversity.edu.zoo.inf.Walkable;

public class Penguin implements Walkable, Swimable{

	@Override
	public void eat() {
		System.out.println("펭귄 밥");
	}

	@Override
	public void bark() {
		System.out.println("펭귄 곽");
	}

	@Override
	public void swim() {
		System.out.println("펭귄 헤엄");
	}

	@Override
	public void walk() {
		System.out.println("펭귄 뚜벅");
	}

}
