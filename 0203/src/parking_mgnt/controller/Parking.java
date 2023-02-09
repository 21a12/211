package parking_mgnt.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Parking {

	public static final Map<String, Integer> PRICE;

	static {
		PRICE = new HashMap<>();
		PRICE.put("경차", 500);
		PRICE.put("소형차", 800);
		PRICE.put("준중형차", 850);
		PRICE.put("중형차", 1000);
		PRICE.put("대형차", 1500);
	}

	public static int leftOver = 3;
	public static final int max = leftOver;

	public static boolean menuCheck(String str) {
		if (str.equals("0") ||str.equals("1") || str.equals("2") || str.equals("3")) {
			return true;
		}
		return false;
	}

	public static boolean typeCheck(String str) {
		return PRICE.keySet().contains(str);
	}
	
	public static boolean carNumCheck(String str) {
		return str.length() != 4;
	}
	
	public static boolean master(String password) {
		return password.trim().equals("주차관리시스템");
	}
	
	public static void menuPrint() {
		int index = 0;
		System.out.println(++index + ". 입");
		System.out.println(++index + ". 출");
		System.out.println(++index + ". 조회");
	}

	public static void carTypePrint() {
		System.out.println("=====차 종류 목록=====");
		System.out.println(PRICE.keySet());
		System.out.println("=====차 종류 목록=====");
	}
	
	
	
	
	public static void main(String[] args) {
		
		Map<String,String> carMap = new HashMap<>(); 
		
		System.out.println("제목 : ㅈㅊㄱㄹㅅㅅㅌ");
		Scanner scan = new Scanner(System.in);

		System.out.print("입력 :");
		String password = scan.nextLine();

		while (master(password)) {
			System.out.println("====================종료키 : \"0\"");
			System.out.println("남은자리 : " + leftOver);
			menuPrint();

			String menu = scan.nextLine();

			if (!menuCheck(menu)) {
				System.out.println("메뉴 잘 보기");
				continue;
			}

			if (menu.equals("1")) {

				if (!(leftOver > 0)) {
					System.out.println("!!만차!!");
					continue;
				}

				carTypePrint();

				System.out.print("차 종류 : ");

				String carType = scan.nextLine();
				if (!typeCheck(carType)) {
					System.out.println("타입존재안함");
					continue;
				}

				System.out.print("차 남바(4자리) : ");
				String carNum = scan.nextLine();
				if (carNumCheck(carNum)) {
					System.out.println("남바 4자리 안맞음");
					continue;
				}

				if (carMap.size() > 0) {
					if (carMap.containsKey(carNum)) {
						if (carMap.get(carNum).equals(carType)) {
							System.out.println("남바 및 타입 중복");
							continue;
						}
						System.out.println("남바 중복... 내용 수정? (Y/N)");
						String ans = scan.nextLine();
						if (ans.toLowerCase().equals("y") || ans.equals("ㅛ")) {
							carMap.put(carNum, carType);
							continue;
						} else {
							System.out.println("!!수정 취소!!");
							continue;
						}
					}
				}

				carMap.put(carNum, carType);
				leftOver--;

				continue;
			}
			// 출차 ... 리스트에서 삭제
			if (menu.equals("2")) {

				if (carMap.size()==0) {
					System.out.println("입 정보 없음");
					continue;
				}
				
				int cnt = 0;
				for (String key : carMap.keySet()) {
					System.out.println("No."+ ++cnt + "	차 남바 : " + key + "	차 종류 : " + carMap.get(key));
				}
				System.out.print("차 남바 : ");
				String carNum = scan.nextLine();
				if (carNumCheck(carNum)) {
					System.out.println("남바 4자리 안맞음");
					continue;
				}
				
				if (!carMap.keySet().contains(carNum)) {
					System.out.println("정보 없음");
					continue;
				}
				
				int carTypePrice = PRICE.get(carMap.get(carNum));
				
				System.out.print("주차시간 : ");
				int time = scan.nextInt();
				scan.nextLine();
				
				int hour = time/60;
				int minute = time % 60;

				String timeFormat = hour > 0 ? Integer.toString(hour) + "시간 " + minute + "분" : minute + "분";
				int money = time/10*PRICE.get(carMap.get(carNum));
				int typePirce = PRICE.get(carMap.get(carNum));
				
				System.out.println("=====출차 정보=====");
				System.out.printf("차 남바	: %s\n차 종류	: %s ...10분당 %d원\n주차시간	: %s\n정산 금액	: %d",carNum,carMap.get(carNum),typePirce,timeFormat, money);
				
				System.out.print("출차 확인? (Y/N)");
				String yyyy = scan.nextLine();
				if(!(yyyy.toLowerCase().equals("y") || yyyy.equals("ㅛ")) ) {
					System.out.println("!!작업취소!!");
					continue;
				}
				carMap.remove(carNum);
				leftOver++;
				System.out.println("!!출차 완료!!");
				
				continue;
			}
			
			//	조회 ... 분으로 입력된 시간은 0시0분으로 표현 ... 전체조회에서 종류별 가격*시간 해서 값까지 출력
			if (menu.equals("3")) {
				System.out.println("구현안댐");
				continue;
			}
			break;
		}
		
		System.out.println("!!정상종료!!");
		
	}

}
