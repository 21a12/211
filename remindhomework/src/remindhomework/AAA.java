package remindhomework;

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

//		7. 6의 결과를 정상적인 값으로 출력되도록 변경해보기

//		8. overflow에 Integer.MIN_VALUE를 할당하고 출력하기
		overflow = Integer.MIN_VALUE;

//		9. 정수형 변수 overflow에 1을 빼서 할당하고 출력하기
		System.out.println(overflow - 1);
		
//		10. overflow 의 값이 이상하게 출력된 이유를 옆 사람에게 설명하기
		
//		11. 10의 결과를 정상적인 값으로 출력되도록 변경해보기
		
//		12. 정수형 변수 divResult를 생성하고 10/3 의 결과를 할당해 출력하기
		int divResult;
		divResult = 10/3;
		System.out.println(divResult);
		
//		13. 소수점 이하 자리수가 안나오는 이유를 옆 사람에게 설명하기
		
//		14. divResult의 값이 소수점이 나오도록 변경해보기
		double ddivResult = 10/3.0;
		System.out.println(ddivResult);
		
//		15. 불린형 변수 isEquals를 생성하고 1 == 1을 할당하고 출력하기
		
		
//		16. isEquals에 1 != 1을 할당하고 출력하기
//		17. 불린형 변수 logicalAnd를 생성하고 true && true를 할당하고 출력하기
//		18. logicalAnd에 true && false를 할당하고 출력하기
//		19. logicalAnd에 false && true를 할당하고 출력하기
//		20. logicalAnd에 false && false 를 할당하고 출력하기
//		21. 불린형 변수 logicalOr를 생성하고 true || true를 할당하고 출력하기
//		22. 불린형 변수 logicalOr를 생성하고 true || false를 할당하고 출력하기
//		23. 불린형 변수 logicalOr를 생성하고 false || true를 할당하고 출력하기
//		24. 불린형 변수 logicalOr를 생성하고 false || false를 할당하고 출력하기
//		25. 5개의 인덱스를 가진 정수형 배열변수 scores를 생성하기
//		26. 각 인덱스에 임의의 값을 할당하기
//		27. 각 인덱스의 값을 모두 출력하기
//		28. 각 인덱스의 값을 반복문을 이용해 출력하기
//		29. 각 인덱스의 값을 foreach문을 이용해 출력하기
//		30. 각 인덱스의 값을 모두 더해 출력하기
//		31. 각 인덱스의 값을 반복문을 이용해 모두 더한 후 출력하기
//		32. 각 인덱스의 값을 foreach를 이용해 모두 더한 후 출력하기
//		33. 각 인덱스의 값을 반복문으로 출력하기. 단, 값이 70 이하인 경우 출력하지 않도록 하기
//		33. 각 인덱스의 값을 반복문으로 출력하기. 단, 값이 30보다 크고 70이하 인 경우만 출력하기
//		35. List 정수형 변수 scoreList를 생성하기
//		36. scoreList에 임의의 값 10개 할당하기
//		37. 각 인덱스의 값을 모두 출력하기
//		38. 각 인덱스의 값을 반복문을 이용해 출력하기
//		39. 각 인덱스의 값을 foreach를 이용해 출력하기
//		40. 각 인덱스의 값을 모두 더해 출력하기
//		41. 각 인덱스의 값을 반복문을 이용해 모두 더한 후 출력하기
//		42. 각 인덱스의 값을 foreach를 이용해 모두 더한 후 출력하기
//		43. 각 인덱스의 값을 반복문으로 출력하기. 단 값이 50 이하인 경우만 출력하기
//		44. 각 인덱스의 값을 반복문으로 출력하기. 단 값이 10 이상 30이하인 경우만 출력하기
//		45. "안녕하세요" 를 출력하는 printHello 메소드를 작성하고 실행하기
//		46. 문자열 변수 name을 입력받아 "name님 안녕하세요" 를 출력하는 printHello 메소드를 작성하고 실행하기
//		47. 정수형 변수 두 개를 입력받아 각 값을 곱하여 출력하는 multiplyNumbers 메소드를 작성하고 실행하기
//		48. 정수형 변수 세 개를 입력받아 각 값을 더하여 출력하는 plusNumbers 메소드를 작성하고 실행하기
//		49. 정수형 변수 한 개를 입력받고 값이 음수면 양수로, 양수면 음수로 변환하여 반환하는 convertSymbol 메소드를 작성하고 실행하기
//		50. 정수형 변수 두 개를 입력받아 뺀 후 결과가 음수면 양수로, 양수면 음수로 변환하여 반환하는 convertSymbol 메소드를 작성하고 실행하기
//		51. 문자열 변수 하나를 입력받아 문자열의 길이를 반환하는 getLength 메소드를 작성하고 실행하기
//		52. 문자열 변수 두 개를 입력받아 각 문자열을 더하여 반환하는 plusStrings 메소드를 작성하고 실행하기
//		53. 문자열 변수 세 대를 입력받아 길이가 가장 긴 문자열만 반환하는 getLongText 메소드를 작성하고 실행하기
//		54. 문자열 변수 하나와 정수형 변수 두 개를 입력받아 입력받은 두 숫자만큼 문자열을 잘라 반환하는 getSubstring메소드를 작성하고 실행하기
//		55. 문자열 변수 두 개를 입력받아 첫 번째 문자열에서 두 번째 문자열이 포함되어있는지를 반환하는 isContains메소스를 작성하고 실행하기
//		56. 문자열 변수 세 개를 입력받아 첫 번째 문자열에서 두 번째 문자열을 세 번째 문자열로 교체하여 반환하는 getReplaced 메소드를 작성하고 실행하기

	}
}
