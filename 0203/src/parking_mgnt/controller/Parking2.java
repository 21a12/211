package parking_mgnt.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import parking_mgnt.vo.CarType;

public class Parking2 {

	public static final Map<String, Integer> PRICE;

	static {
		PRICE = new HashMap<>();
		PRICE.put("경차", 500);
		PRICE.put("소형차", 800);
		PRICE.put("준중형차", 850);
		PRICE.put("중형차", 1000);
		PRICE.put("대형차", 1500);
	}

	public static int leftover = 3;
	public static final int max = leftover;

	public static boolean menuCheck(String str) {
		if (str.equals("0") ||str.equals("1") || str.equals("2") || str.equals("3")) {
			return true;
		}
		return false;
	}

	public static boolean typeCheck(String str) {
		return PRICE.keySet().contains(str);
	}
	
	
	public static void menuPrint() {
		int index = 0;
		System.out.println(++index + ". 입");
		System.out.println(++index + ". 출");
		System.out.println(++index + ". 조회");
	}
	
	
	
	
	
	public static void main(String[] args) {
		
		List<Map<String,Integer>> carList = new ArrayList<>(); 
		
		System.out.println("ㅈㅊㄱㄹㅅㅅㅌ");
		Scanner scan = new Scanner(System.in);

		System.out.println("while문 돌기. 아무키 ㄱ");
		scan.nextLine();

		while (true) {
			System.out.println("====================종료키 : \"0\"");
			System.out.println("남은자리 : " + leftover);
			menuPrint();

			String menu = scan.nextLine();

			if (!menuCheck(menu)) {
				System.out.println("메뉴 잘 보기");
				continue;
			}

			if (menu.equals("1")) {
				if (!(leftover > 0)) {
					System.out.println("!!만차!!");
					continue;
				}
				System.out.print("차종류 입력 : ");

				String carType = scan.nextLine();
				if (!typeCheck(carType)) {
					System.out.println("타입존재안함");
					continue;
				}
				
				System.out.print("주차 시간 입력 : ");
				int time = scan.nextInt();
				scan.nextLine();

				Map<String, Integer> carMap = new HashMap<>();
				carMap.put(carType, time);
				carList.add(carMap);
				leftover--;

				// 리스트에 입력

				continue;
			}
			//	출차 ... 리스트에서 삭제
			if (menu.equals("2")) {
				continue;
			}
			
			//	조회 ... 분으로 입력된 시간은 0시0분으로 표현 ... 전체조회에서 종류별 가격*시간 해서 값까지 출력
			if (menu.equals("3")) {
				
				carList.forEach(vo -> {
					int cnt = 0;
					int hour = 0;
					int minute = 0;
					for(String carType : vo.keySet()) {
						vo.get(carType);
						System.out.println(++cnt + "	차종 : " + carType + "	... 주차시간 : " + vo.get(carType));
					}
				});
				
				
				
				
				continue;
			}
			System.out.println("!!정상종료!!");
			break;
		}
		
		
	}

}
