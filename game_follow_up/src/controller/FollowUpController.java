package controller;

import java.util.Scanner;

import service.FollowUpService;
import service.FollowUpServiceImpl;

public class FollowUpController {

	
//	public static final int WORDCOUNT;
//
//	static {
//		WORDCOUNT = 3;
//	}
//	예외처리로 추가하기 어렵맨
//	public static void wordCount(String word) {
//		if (word.length() != WORDCOUNT) {
//			throw new CountCheckException("!!!" + WORDCOUNT + "글자가 아님");
//		}
//	}
	
	

	public static void main(String[] args) {
		
		FollowUpService service = new FollowUpServiceImpl();

		System.out.println("!!!끝말잇기 게임 시작!!!");
		
		Scanner scan = new Scanner(System.in);

		System.out.println("시작 단어를 입력하세요 :");
		
		String word = "";

		while (true) {

			word =  scan.nextLine();
			if (service.countCheck(word)) {
				service.create(word);
				System.out.println("시작단어 저장o");
				break;
			} else {
				System.out.println("!!글자수 맞지않음");
				
			}

		}

//		System.out.println(service.countCheck(word));
		System.out.println(service.lastChar()+" << 로 시작"); 
		
		while (true) {
			
			//입력 단어 받기
			word = scan.nextLine();

			if (word.equals("종료")) {
				System.out.println("!!!게임 종료!!!");

				System.out.println("===입력한 단어 목록===");
				service.readAll();

				System.out.println("!!!게임 종료!!!");
				break;
			}
			
			if (service.firstCharCheck(word)) {
				if (service.countCheck(word)) {
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
			
			


		}
	}
}
