package random50num;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class Random50Num {
	
//	**** Stream 문제 아닙니다. ****
//	1. 랜덤 숫자 50개를 List에 넣고 그 중 가장 큰 숫자 하나를 출력한다.
//	2. 랜덤 숫자 50개를 List에 넣고 그 중 가장 작은 숫자 하나를 출력한다.
//	3. 랜덤 숫자 50개를 List에 넣고 그 중 평균 값(정수형)과 같은 숫자 하나를 출력한다. 없으면 0 을 출력한다.
//	**** Stream 문제 아닙니다. ****
	
	public static void main(String[] args) {
		
		Random random = new Random();
		
		List<Integer> randomList = new ArrayList<>();
		for (int i=0;i<50;i+=1) {
			randomList.add(random.nextInt(1000));
		}
		// 리스트 오름차순 정렬
		randomList.sort( Comparator.naturalOrder() );
		
		// 정렬된 리스트 출력해서 확인
		System.out.println( randomList );
		
		// 가장 큰 값 가져오기
		System.out.println( randomList.get(randomList.size()-1) + "	가장 큰 값");
		
		// 가장 작은 값 가져오기
		System.out.println( randomList.get(0) + "	가장 작은 값");
		
		// 합계 구하기
		int sum = 0;
		for(int i : randomList) {
			sum += i;
		}
		
		// 평균 구하기
		int avg = 0;
		avg = sum/randomList.size();
		
		// 평균과 같은 값이 리스트에 있는지 확인
		System.out.println( (randomList.contains(avg) ? avg : 0 )+"	평균값["+avg+"]과 같은값 출력...없으면 0");
		
		
		
//		**** Stream 문제 아닙니다. ****
//		1. 랜덤 숫자 50개를 List에 넣고 그 중 가장 큰 숫자 하나를 출력한다.
//		2. 랜덤 숫자 50개를 List에 넣고 그 중 가장 작은 숫자 하나를 출력한다.
//		3. 랜덤 숫자 50개를 List에 넣고 그 중 평균 값(정수형)과 같은 숫자 하나를 출력한다. 없으면 0 을 출력한다.
//		**** Stream 문제 아닙니다. ****
		////////////////////////////////////////////////////
		System.out.println("\n============정렬을 하지 않은 리스트============\n");
		List<Integer> randomList2 = new ArrayList<>();
		for (int i=0 ; i<50 ; i++) {
			randomList2.add(random.nextInt(1000));
		}
		// 생성된 리스트 출력해서 확인하기
		System.out.println(randomList2);
		
		// 최대값 찾기 for
		int max = randomList2.get(0);	// 임의의 값 먼저
		for (int i=0 ; i<randomList2.size(); i++) {
			if (max < randomList2.get(i)) {
				max = randomList2.get(i);
			}
		}
		// 가장 큰 값 가져오기
		System.out.println(max + "	가장 큰 값");
		
		// 최소값 찾기 for
		int min = randomList2.get(0);	// 임의의 값 먼저
		for (int i=0 ; i<randomList2.size(); i++) {
			if (min > randomList2.get(i)) {
				min = randomList2.get(i);
			}
		}
		
		// 가장 작은 값 가져오기
		System.out.println(min + "	가장 작은 값");
		
		// 합계 구하기
		sum = 0;
		for(int i : randomList2) {
			sum += i;
		}
		
		// 평균 구하기
		avg = 0;
		avg = sum/randomList2.size();
		
		// 평균과 같은 값이 리스트에 있는지 확인
		System.out.println( (randomList2.contains(avg) ? avg : 0 )+"	평균값["+avg+"]과 같은값 출력...없으면 0");
		
	}

}
