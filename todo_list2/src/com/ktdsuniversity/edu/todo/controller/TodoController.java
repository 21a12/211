package com.ktdsuniversity.edu.todo.controller;

import java.util.List;
import java.util.Scanner;

import com.ktdsuniversity.edu.todo.service.TodoService;
import com.ktdsuniversity.edu.todo.vo.TodoVO;

public class TodoController {

	public static void main(String[] args) {

		// 생성자 TodoService를 불러오는 service
		TodoService service = new TodoService();

		/*
		 * 1.등록 2.조회..단일 3.조회..전부 4.수정 5.삭제..단일 6.삭제..전부 7.종료
		 */
		Scanner scan = new Scanner(System.in);
		while (true) {

			System.out.println("1.등록\n2.조회..단일\n3.조회..전체\n4.수정\n5.삭제..단일\n6.삭제..전체\n7.종료");
			System.out.println("메뉴를 입력하세요");

			int menu = scan.nextInt();
			scan.nextLine();
			if (menu == 1) {
				System.out.println("TODO 명을 입력하세요.");
				String itemName = scan.nextLine();
				if (service.create(itemName)) {
					System.out.println("아이템이 등록되었습니다.");
				}
				
			} else if (menu == 2) {
				System.out.println("조회할 TODO 'Key'를 입력하세요.");
				int key = scan.nextInt();
				scan.nextLine();

				if (service.read(key) == null) {
					System.out.println("'Key'값의 데이터가 존재하지 않습니다.");
				} else {
					TodoVO todoVO = service.read(key);
					String check = todoVO.isSuccess() ? "X" : " ";
					System.out.println("[" + check + "]" + todoVO.getItenName());
				}

			} else if (menu == 3) {
				List<TodoVO> todoList = service.readAll();
				for (TodoVO list : todoList) {
					String check = list.isSuccess() ? "X" : " ";
					System.out.println("[" + check + "]" + list.getItenName());
				}
				
			} else if (menu == 4) {
				System.out.println("수정할 TODO 'Key'를 입력하세요.");
				int key = scan.nextInt();
				scan.nextLine();
				// key값에 대해 아이템 존재 유무
				if (service.read(key) == null) {
					System.out.println("아이템이 존재하지 않습니다.");
				} else {
					boolean isSuccess;
					if (service.read(key).isSuccess()) {
						// 현재상태 완료 인 상태
						System.out.println("현재상태 : 완료... 미완료로 변경합니까? (Y/N)");
						String yn = scan.nextLine();
						if (yn.equalsIgnoreCase("Y")) {
							service.update(key, false);
							System.out.println("상태 변경 완료 (완료 -> 미완료)");
						} else {
							System.out.println("상태 변경 취소");
						}

					} else {
						// 미완료 상태
						System.out.println("현재상태 : 미완료... 완료로 변경합니까? (Y/N)");
						String yn = scan.nextLine();
						if (yn.equalsIgnoreCase("Y")) {
							service.update(key, true);
							System.out.println("상태 변경 완료 (미완료 -> 완료)");
						} else {
							System.out.println("상태 변경 취소");
						}
					}

				}
			} else if (menu == 5) {
				System.out.println("삭제할 TODO 'Key'를 입력하세요.");
				int key = scan.nextInt();
				scan.nextLine();
				service.delete(key);
			} else if (menu == 6) {
				System.out.println("TODO List를 전부 삭제하시겠습니까? (Y/N)");
				String yn = scan.nextLine();
				if (yn.equalsIgnoreCase("Y")) {
					service.deleteAll();
					System.out.println("전체 삭제 완료");
				} else {
					System.out.println("전체 삭제 취소");
				}
					
				
			} else if (menu == 7) {
				System.out.println("종료? (Y/N)");
				String yn = scan.nextLine();
				if (yn.equalsIgnoreCase("Y")) {
					break;
				} 
			}

		}

	}
}