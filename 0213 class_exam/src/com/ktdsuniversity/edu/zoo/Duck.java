package com.ktdsuniversity.edu.zoo;

import com.ktdsuniversity.edu.zoo.inf.Flyable;
import com.ktdsuniversity.edu.zoo.inf.Runable;
import com.ktdsuniversity.edu.zoo.inf.Swimable;
import com.ktdsuniversity.edu.zoo.inf.Walkable;

public class Duck implements Walkable, Runable, Swimable, Flyable

{

	@Override
	public void eat() {
		System.out.println("오리 냠");
	}

	@Override
	public void bark() {
		System.out.println("오리 곽!");
	}

	@Override
	public void fly() {
		System.out.println("오리 파닥");
	}

	@Override
	public void swim() {
		System.out.println("오리 헤엄");
	}

	@Override
	public void run() {
		System.out.println("오리 달려");
	}

	@Override
	public void walk() {
		System.out.println("오리 뚜벅");
	}

}
