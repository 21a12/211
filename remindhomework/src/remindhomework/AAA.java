package remindhomework;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AAA {

	public static void main(String[] args) {

//		1. 정수형 변수 number를 생성하고 7을 할당한 후 출력하기
		int number;
		number = 7;
		System.out.println("No.1	" + number);

//		2. 정수형 변수 empty를 생성하고 아무것도 할당하지 않고 출력하기
		int empyt;
//		System.out.println(empyt); // 에러출력

//		3. 정수형 변수 result를 생성하고 7과 7을 더한 후 출력하기
		int result;
		result = 7 + 7;
		System.out.println(result);

//		4. 정수형 변수 overflow를 생성하고 Integer.MAX_VALUE를 할당하고 출력하기
		int overflow;
		overflow = Integer.MAX_VALUE;
		System.out.println(overflow);

//		5. 정수형 변수 overflow에 1을 더해 할당하고 출력하기
		System.out.println(overflow + 1);

//		6. overflow 의 값이 이상하게 출력된 이유를 옆 사람에게 설명하기
		// int 타입의 경계값을 넘었기 때문, 범위이탈

//		7. 6의 결과를 정상적인 값으로 출력되도록 변경해보기

//		8. overflow에 Integer.MIN_VALUE를 할당하고 출력하기
		overflow = Integer.MIN_VALUE;

//		9. 정수형 변수 overflow에 1을 빼서 할당하고 출력하기
		System.out.println(overflow - 1);

//		10. overflow 의 값이 이상하게 출력된 이유를 옆 사람에게 설명하기
		// int 타입의 경계값을 넘었기 때문, 범위이탈

//		11. 10의 결과를 정상적인 값으로 출력되도록 변경해보기

//		12. 정수형 변수 divResult를 생성하고 10/3 의 결과를 할당해 출력하기
		int divResult;
		divResult = 10 / 3;
		System.out.println(divResult); // 3

//		13. 소수점 이하 자리수가 안나오는 이유를 옆 사람에게 설명하기
		// divResult는 int 타입으로 소수점을 갖지 않음. 소수점 이하는 모두 버림

//		14. divResult의 값이 소수점이 나오도록 변경해보기
		// 소수점을 포함하는 실수 타입 [ float ] 또는 [ double ]을 사용
		double ddivResult = 10 / 3.0;
		System.out.println(ddivResult); // 3.333~

//		15. 불린형 변수 isEquals를 생성하고 1 == 1을 할당하고 출력하기
		boolean isEquals;
		isEquals = 1 == 1;
		System.out.println(isEquals); // true

//		16. isEquals에 1 != 1을 할당하고 출력하기
		isEquals = 1 != 1;
		System.out.println(isEquals); // false

//		17. 불린형 변수 logicalAnd를 생성하고 true && true를 할당하고 출력하기
		boolean logicalAnd;
		logicalAnd = true && true;
		System.out.println(logicalAnd); // true

//		18. logicalAnd에 true && false를 할당하고 출력하기
		logicalAnd = true && false;
		System.out.println(logicalAnd); // false ... 논리연산자 && 앞 값이 true 이므로 뒤에 값을 확인

//		19. logicalAnd에 false && true를 할당하고 출력하기
		logicalAnd = false && true;
		System.out.println(logicalAnd); // false ... 논리연산사 && 앞 값이 false 이므로 뒤 값은 확인하지 않음

//		20. logicalAnd에 false && false 를 할당하고 출력하기
		logicalAnd = false && false;
		System.out.println(logicalAnd);

//		21. 불린형 변수 logicalOr를 생성하고 true || true를 할당하고 출력하기
		boolean logicalOr;
		logicalOr = true || true;
		System.out.println(logicalOr); // true

//		22. 불린형 변수 logicalOr를 생성하고 true || false를 할당하고 출력하기
		logicalOr = true || false;
		System.out.println(logicalOr); // true ... 논리연산자 || 앞 값이 true 이므로 뒤 값은 확인하지 않음

//		23. 불린형 변수 logicalOr를 생성하고 false || true를 할당하고 출력하기
		logicalOr = false || true;
		System.out.println(logicalOr); // true ... 논리연산자 || 앞 값이 false 이므로 뒤에 값을 확인

//		24. 불린형 변수 logicalOr를 생성하고 false || false를 할당하고 출력하기
		logicalOr = false || false;
		System.out.println(logicalOr); // false

//		25. 5개의 인덱스를 가진 정수형 배열변수 scores를 생성하기
		int[] scores = new int[5];

//		26. 각 인덱스에 임의의 값을 할당하기
		Random random = new Random(); // 임의 값을 가져오기 위해 random 클래스를 호출
		for (int i = 0; i < scores.length; i++) {
			scores[i] = random.nextInt(100);
		}

//		27. 각 인덱스의 값을 모두 출력하기
		System.out.println(scores[0]);
		System.out.println(scores[1]);
		System.out.println(scores[2]);
		System.out.println(scores[3]);
		System.out.println(scores[4]);

//		28. 각 인덱스의 값을 반복문을 이용해 출력하기
		for (int i = 0; i < scores.length; i++) {
			System.out.println(scores[i]);
		}

//		29. 각 인덱스의 값을 foreach문을 이용해 출력하기
		for (int i : scores) {
			System.out.println(i);
		}

//		30. 각 인덱스의 값을 모두 더해 출력하기
		int sum = 0;
		sum = scores[0] + scores[1] + scores[2] + scores[3] + scores[4];
		System.out.println(sum);

//		31. 각 인덱스의 값을 반복문을 이용해 모두 더한 후 출력하기
		sum = 0;
		for (int i = 0; i < scores.length; i++) {
			sum += scores[i];
		}
		System.out.println(sum);

//		32. 각 인덱스의 값을 foreach를 이용해 모두 더한 후 출력하기
		sum = 0;
		for (int i : scores) {
			sum += i;
		}
		System.out.println(sum);

//		33. 각 인덱스의 값을 반복문으로 출력하기. 단, 값이 70 이하인 경우 출력하지 않도록 하기
		for (int i : scores) {
			if (i > 70) {
				System.out.println(i);
			}
		}

//		33. 각 인덱스의 값을 반복문으로 출력하기. 단, 값이 30보다 크고 70이하 인 경우만 출력하기
		for (int i : scores) {
			if (i > 30 && i <= 70) {
				System.out.println(i);
			}
		}

//		35. List 정수형 변수 scoreList를 생성하기
		List<Integer> scoreList = new ArrayList<>();

//		36. scoreList에 임의의 값 10개 할당하기
		for (int i = 0; i < 10; i++) {
			scoreList.add(random.nextInt(100));
		}

//		37. 각 인덱스의 값을 모두 출력하기
		System.out.println(scoreList);
		System.out.println("37." + scoreList.get(0));
		System.out.println("37." + scoreList.get(1));
		System.out.println("37." + scoreList.get(2));
		System.out.println("37." + scoreList.get(3));
		System.out.println("37." + scoreList.get(4));
		System.out.println("37." + scoreList.get(5));
		System.out.println("37." + scoreList.get(6));
		System.out.println("37." + scoreList.get(7));
		System.out.println("37." + scoreList.get(8));
		System.out.println("37." + scoreList.get(9));

//		38. 각 인덱스의 값을 반복문을 이용해 출력하기
		for (int i = 0; i < scoreList.size(); i++) {
			System.out.println("38." + scoreList.get(i));
		}
//		39. 각 인덱스의 값을 foreach를 이용해 출력하기
		for (int i : scoreList) {
			System.out.println("39." + i);
		}

//		40. 각 인덱스의 값을 모두 더해 출력하기
		sum = 0;
		sum =	scoreList.get(0) +
				scoreList.get(1) +
				scoreList.get(2) +
				scoreList.get(3) +
				scoreList.get(4) +
				scoreList.get(5) +
				scoreList.get(6) +
				scoreList.get(7) +
				scoreList.get(8) +
				scoreList.get(9);  

//		41. 각 인덱스의 값을 반복문을 이용해 모두 더한 후 출력하기
		sum = 0;
		for (int i = 0; i < scoreList.size(); i++) {
			sum += scoreList.get(i);
		}
		System.out.println("41." + sum);

//		42. 각 인덱스의 값을 foreach를 이용해 모두 더한 후 출력하기
		sum = 0;
		for (int i : scoreList) {
			sum += i;
		}
		System.out.println("42." + sum);

//		43. 각 인덱스의 값을 반복문으로 출력하기. 단 값이 50 이하인 경우만 출력하기
		for (int i = 0; i < scoreList.size(); i++) {
			if (scoreList.get(i) <= 50) {
				System.out.println("43. 50이하만 : " + i);
			}
		}

//		44. 각 인덱스의 값을 반복문으로 출력하기. 단 값이 10 이상 30이하인 경우만 출력하기
		for (int i = 0; i < scoreList.size(); i++) {
			if (i >= 10 && i <= 30) {
				System.out.println("44. 10이상 30이하 : " + scoreList.get(i));
			}
		}

//		45. "안녕하세요" 를 출력하는 printHello 메소드를 작성하고 실행하기
		AAA a = new AAA();
		a.printHello();

//		46. 문자열 변수 name을 입력받아 "name님 안녕하세요" 를 출력하는 printHello 메소드를 작성하고 실행하기
		a.printHello("네임");

//		47. 정수형 변수 두 개를 입력받아 각 값을 곱하여 출력하는 multiplyNumbers 메소드를 작성하고 실행하기
		a.multiplyNumbers(5, 5);

//		48. 정수형 변수 세 개를 입력받아 각 값을 더하여 출력하는 plusNumbers 메소드를 작성하고 실행하기
		a.plusNumbers(1, 2, 3);

//		49. 정수형 변수 한 개를 입력받고 값이 음수면 양수로, 양수면 음수로 변환하여 반환하는 convertSymbol 메소드를 작성하고 실행하기
		a.convertSymbol(6);

//		50. 정수형 변수 두 개를 입력받아 뺀 후 결과가 음수면 양수로, 양수면 음수로 변환하여 반환하는 convertSymbol 메소드를 작성하고 실행하기
		a.convertSymbol(7, 9);

//		51. 문자열 변수 하나를 입력받아 문자열의 길이를 반환하는 getLength 메소드를 작성하고 실행하기
		a.getLength("입력된 문자열 길이 확인");
		
//		52. 문자열 변수 두 개를 입력받아 각 문자열을 더하여 반환하는 plusStrings 메소드를 작성하고 실행하기
		a.plusStrings("문자열","더하기");
		
//		53. 문자열 변수 세 대를 입력받아 길이가 가장 긴 문자열만 반환하는 getLongText 메소드를 작성하고 실행하기
		a.getLongText("123","1234","12345");
		
//		54. 문자열 변수 하나와 정수형 변수 두 개를 입력받아 입력받은 두 숫자만큼 문자열을 잘라 반환하는 getSubstring메소드를 작성하고 실행하기
//		55. 문자열 변수 두 개를 입력받아 첫 번째 문자열에서 두 번째 문자열이 포함되어있는지를 반환하는 isContains메소스를 작성하고 실행하기
//		56. 문자열 변수 세 개를 입력받아 첫 번째 문자열에서 두 번째 문자열을 세 번째 문자열로 교체하여 반환하는 getReplaced 메소드를 작성하고 실행하기
//		57. 여러 개의 상품(상품명, 가격)을 가지는 클래스를 만들고 "상품명 | 가격" 형태로 반환하는 toString 메소드를 작성하고 실행하기
//		58. 여러 개의 상품(상품명, 가격)을 가지는 클래스를 만들고 "상품명"을 입력하면 재고 하나를 제거하는 removeOne(상품명) 메소드를 작성하고 실행하기
//		59. 여러 개의 상품(상품명, 가격)과 금액을 가지는 클래스를 만들고 "상품명"을 입력하면 재고하나를 제거하고 금액을 상품가격만큼 증가시키는 order(상품명) 메소드를 작성하고 실행하기
//		60. 여러 개의 상품(상품명, 가격)과 금액을 가지는 클래스를 만들고 모든 상품이 제거될 때까지 무한 반복시키는 orderAll 메소드를 작성하고 실행하기
//		61. 여러 개의 상품(상품명, 가격)과 금액을 가지는 클래스를 만들고 상품을 추가하는 addProduct(상품)를 작성하고 실행하기
//		62. 여러 개의 상품(상품명, 가격)과 금액을 가지는 클래스를 만들고 상품을 추가하면 상품이 개수만큼 추가되고 금액이 가격만큼 빠지는 addProduct(상품, 개수)를 작성하고 실행하기
//		63. 도서 관리 프로그램 만들기
//		    - 도서
//		        - 도서 명
//		        - 저자
//		        - 금액
//		        - ISBN
//		        - 출판사
//		    - 도서 관리 기능
//		        - 대출
//		        - 반납
//		        - 입고
		
		
	}

	private String getLongText(String a, String b, String c) {
		String result = "";
		
		return result;
	}
	
	private String plusStrings(String str1, String str2) {
		return str1 + str2;
	}

	private int getLength(String str) {
		return str.length();
	}

	private int convertSymbol(int i, int j) {
		return -(i - j);
	}
	
	private int convertSymbol(int i) {
		return -i;
	}

	private int plusNumbers(int numberOne, int numberTwo, int numberThree) {
		return numberOne + numberTwo + numberThree;
	}

	private int multiplyNumbers(int numberOne, int numberTwo) {
		return numberOne * numberTwo;
	}

	private void printHello(String name) {
		System.out.println(name + "님 안녕하세요");
	}

	private void printHello() {
		System.out.println("안녕하세요");
	}
}
