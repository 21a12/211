package controller;

import java.util.Scanner;

import service.FollowUpService;
import service.FollowUpServiceImpl;

public class FollowUpController {

	public static void main(String[] args) {
		
		FollowUpService service = new FollowUpServiceImpl();

		System.out.println("!!!끝말잇기 게임 시작!!!");
		
		Scanner scan = new Scanner(System.in);

		System.out.println("시작 단어를 입력하세요 :");
		
		String word = scan.nextLine();
		
		
//		System.out.println(service.wordCount(word));
		
		if (service.wordCount(word)) {
			service.create(word);
			System.out.println("시작단어 저장o");
		}
		
		System.out.println(service.lastChar()+" << 로 시작"); 
		
		while (true) {
			
			//입력 단어 받기
			word = scan.nextLine();

			if (word.equals("포기")) {
				System.out.println("!!!게임을 종료합니다!!!");
				
				
				System.out.println("===입력한 단어 목록===");
				service.readAll();
				
				break;
			}
			
			if (service.firstCharCheck(word)) {
				if (service.wordCount(word)) {
					if(service.overLap(word)!=true ) {
						
						service.create(word);
						System.out.println(service.lastChar()+" << 로 시작"); 
						
					} else {
						System.out.println("!!중복값");
						System.out.println(service.lastChar()+" << 로 시작"); 
						
					}
					
				} else {
					System.out.println("!!글자수 맞지않음");
				}
				
			} else {
				System.out.println("!!시작글자 맞지 않음");
			}
			
//			System.out.println(service.firstChar());
//			System.out.println(service.lastChar());
			
			// 단어를 List에 생성 >> list.add("단어")
			// 하지만 3글자인지 먼저 확인
			// 글자수 check 기능 필요 String.startsWith("단어 및 글자")
			
			
			


		}
	}
}
