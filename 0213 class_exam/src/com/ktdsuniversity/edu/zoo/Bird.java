package com.ktdsuniversity.edu.zoo;

import com.ktdsuniversity.edu.zoo.inf.Flyable;
import com.ktdsuniversity.edu.zoo.inf.Walkable;

public class Bird implements Flyable, Walkable{
	
	@Override
	public void eat() {
		System.out.println("새 밥");
	}
	
	@Override
	public void bark() {
		System.out.println("새 짹!");
	}

	@Override
	public void fly() {
		System.out.println("새 파닥");
	}
	
	@Override
	public void walk() {
		System.out.println("새 뚜벅");
	}
	
}
