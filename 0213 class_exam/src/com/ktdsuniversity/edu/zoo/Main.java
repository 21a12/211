package com.ktdsuniversity.edu.zoo;

import com.ktdsuniversity.edu.zoo.inf.Animal;
import com.ktdsuniversity.edu.zoo.inf.Crawlable;
import com.ktdsuniversity.edu.zoo.inf.Flyable;
import com.ktdsuniversity.edu.zoo.inf.Runable;
import com.ktdsuniversity.edu.zoo.inf.Swimable;
import com.ktdsuniversity.edu.zoo.inf.Walkable;

public class Main {

	public static void launchar(Animal animal) {
		animal.eat();
		animal.bark();
		if (animal instanceof Walkable) {
			((Walkable) animal).walk();
		}
		if (animal instanceof Runable) {
			((Runable) animal).run();
		}
		if (animal instanceof Flyable) {
			((Flyable) animal).fly();
		}
		if (animal instanceof Swimable) {
			((Swimable) animal).swim();
		}
		if (animal instanceof Crawlable) {
			((Crawlable) animal).crawl();
		}
	}

	public static void main(String[] args) {
		Animal lion = new Lion("메리");
		launchar(lion);

		Animal penguin = new Penguin();
		launchar(penguin);

		Animal duck = new Duck();
		launchar(duck);

		Animal bird = new Bird();
		launchar(bird);

		Animal lizard = new Lizard();
		launchar(lizard);

//		Walkable wLion = new Lion("리메");
//		Runable rLion = new Lion("레미");
//		Swimable sLion = new Lion("메미");
//		
//		lion.eat();
//		lion.bark();
//		wLion.walk();
//		wLion.eat();
//		rLion.run();
//		sLion.swim();

	}

}
