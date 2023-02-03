package cafe.controller;

import java.util.Scanner;

import cafe.service.MenuMgntService;
import cafe.service.MenuMgntServiceImpl;

public class MenuMgntController {

	/**
	 * 기본화면 - Mgnt 전체 메뉴 출력
	 */
	private static void MenuPrint() {
		System.out.println("====메뉴를 선택하세요====");
		System.out.println("1. 등록");
		System.out.println("2. 수정");
		System.out.println("3. 삭제");
		System.out.println("4. 조회...단일");
		System.out.println("5. 조회...카테고리 선택");
		System.out.println("6. 조회...전체");
		System.out.println("7. 종료");
		System.out.println("====================");
	}
	private static void TypePrint() {
		System.out.println("===등록 메뉴 타입 선택===");
		System.out.println("1. 커피");
		System.out.println("2. 음료");
		System.out.println("3. 티");
		System.out.println("4. 디저트");
		System.out.println("====뒤로가기 아무버튼====");
		
	}
	

	public static void main(String[] args) {

//		Map<String, String> map = new HashMap<>();
//		map.put("a", "b");
//		map.put("b", "b");
//		map.put("b", "c");
//		map.put("c", "1");
//		
//		System.out.println(map);
//		
//		Map<String, List<String>> mapList = new HashMap<>();
//		List<String> list = new ArrayList<>();
//		list.add("ab");
//		list.add("ab");
//		list.add("ab");
//		mapList.put("a", list);
//		
//		System.out.println(mapList);

		MenuMgntService service = new MenuMgntServiceImpl();

		Scanner scan = new Scanner(System.in);

		System.out.println("**Cafe Menu Management System**");

		while (true) {
			MenuPrint();

			// 숫자가 아닌 값 입력 시 에러나는거 처리하고싶다
			int menu = scan.nextInt();
			scan.nextLine();
			
			if (menu == 7) {
				System.out.println("ㄹㅇ 종료? Y/N");
				String ans = scan.nextLine();
				if (ans.equalsIgnoreCase("Y")) {
					System.out.println("Y를 눌렀음. 종료됨");
					break;
				} else {
					System.out.println("취소임 처음으로 돌아감, 아무키나 누르셈");
					scan.nextLine();
				}
			}
			
			if (menu==1) {
				TypePrint();
				System.out.print("등록할 메뉴 타입 선택 : ");
				int itemType = scan.nextInt();
				scan.nextLine();
				System.out.print("등록할 메뉴 이름 작성 : ");
				String itemName = scan.nextLine();
				
				
				
					
			}
				
		}

	}

}
