package parking_mgnt.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import parking_mgnt.vo.CarType;

public class Parking {

	public static final Map<CarType, Integer> PRICE;

	static {
		PRICE = new HashMap<>();
		PRICE.put(CarType.경차, 500);
		PRICE.put(CarType.소형차, 800);
		PRICE.put(CarType.준중형차, 850);
		PRICE.put(CarType.중형차, 1000);
		PRICE.put(CarType.대형차, 1500);
	}

	public static int leftover = 35;

	public static boolean menuCheck(String str) {
		if (str.equals("1") || str.equals("2")) {
			return true;
		}
		return false;
	}

	public static boolean typeCheck(String str) {
		return PRICE.keySet().contains(str);
	}
	
	
	
	
	
	
	
	
	public static void main(String[] args) {

		System.out.println("ㅈㅊㄱㄹㅅㅅㅌ");
		Scanner scan = new Scanner(System.in);

		System.out.println("while문 돌기. 아무키 ㄱ");
		scan.nextLine();

		while (true) {
			System.out.println("====================");
			System.out.println("남은자리 : " + leftover);

			String menu = scan.nextLine();

			if (!menuCheck(menu)) {
				System.out.println("1 또는 2 입력");
				continue;
			}

			if (menu.equals("1")) {
				System.out.print("차종류 입력 : ");

				String carType = scan.nextLine();
				if (!typeCheck(carType)) {
					System.out.println("타입존재안함");
					continue;
				}
				

				// 리스트에 입력

				continue;
			}

			break;
		}
		
		
	}

}
