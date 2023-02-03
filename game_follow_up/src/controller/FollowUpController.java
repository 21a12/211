package controller;

import java.util.Scanner;

import exceptions.CountCheckException;
import service.FollowUpService;
import service.FollowUpServiceImpl;

public class FollowUpController {

	
	public static final int WORDCOUNT = 3;
	public static int LIFE = 3;
	
	
//	예외처리로 추가하기 어렵맨
//	public static void wordCheck(String word) {
//		if (word.length() != WORDCOUNT) {
//			throw new CountCheckException();
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
			if (service.countCheck(word,WORDCOUNT)) {
				service.create(word);
				System.out.println("시작단어 저장o");
				break;
			} else {
				System.out.println("!!글자수 맞지않음");
				System.out.println("!!"+WORDCOUNT+"문자로 이루어진 단어");
				
			}

		}

//		System.out.println(service.countCheck(word));
		System.out.println(service.lastChar(WORDCOUNT)+" << 로 시작"); 
		int life = LIFE;
		
		while (true) {
			
			
			//입력 단어 받기
			word = scan.nextLine();

			if (word.equals("종료") || life==0) {
				System.out.println("!!!게임 종료!!!");

				System.out.println("===입력한 단어 목록===");
				service.readAll();

				System.out.println("!!!게임 종료!!!");
				break;
			}
			
			if (service.firstCharCheck(word,WORDCOUNT)) {
				if (service.countCheck(word,WORDCOUNT)) {
					if(service.overLap(word)!=true ) {
						
						service.create(word);
						life++;
						if (life > LIFE) {
							life = LIFE;
						}
						System.out.println("!!남은기회 : "+life);
						System.out.println(service.lastChar(WORDCOUNT)+" << 로 시작"); 
						
					} else {
						life--;
						System.out.println("!!남은기회 : "+life);
						System.out.println("!!중복값");
						System.out.println(service.lastChar(WORDCOUNT)+" << 로 시작"); 
						
					}
					
				} else {
					life--;
					System.out.println("!!남은기회 : "+life);
					System.out.println("!!글자수 맞지않음");
					System.out.println("!!"+WORDCOUNT+"문자로 이루어진 단어");
				}
				
			} else {
				life--;
				System.out.println("!!남은기회 : "+life);
				System.out.println("!!시작글자 맞지 않음");
			}
			
			


		}
	}
}
