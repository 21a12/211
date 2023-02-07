package com.ktdsuniversity.edu.stream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BasballStream2 {

	public static List<AllStarFullVO> readAllStarFull() {

		try {
			List<AllStarFullVO> list = Files.readAllLines(Paths.get("C:\\Devs\\data\\baseball\\core\\AllstarFull.csv"))
										.stream()
										.skip(1)
//										.peek(System.out::println)		// 데이터 처리중 출력 확인 ... 임시로 사용
										.map( (line) -> {
											String[] strArr = line.split(",");
											AllStarFullVO vo = new AllStarFullVO();
											vo.setPlayerID(strArr[0]);
											vo.setYearID(strArr[1]);
											vo.setGameNum(Integer.parseInt(strArr[2]));
											vo.setGameID(strArr[3]);
											vo.setTeamID(strArr[4]);
											vo.setLgID(strArr[5]);
											vo.setGP(Integer.parseInt(strArr[6]));
											if (strArr.length==8) {
												vo.setStartingPos(Integer.parseInt(strArr[7]));
											} else {
												vo.setStartingPos(0);
											}
											return vo;
										} )
										.collect(Collectors.toList());
			return list;
		} catch (IOException ioe) {
			ioe.printStackTrace();
			return new ArrayList<>();
		}
	}

	// 병렬 스트림
	public static List<TextVO> readTextFile() {
		String filePath = "C:\\Devs\\data\\bigdata\\10K.ID.CONTENTS";
		try {
		List<TextVO> list = Files.readAllLines(Paths.get(filePath))
									.parallelStream()
									.map( (line) -> {
										String[] strArr = line.split("\t");
										TextVO vo = new TextVO();
										vo.setKey(strArr[0].trim());
										if (strArr.length >= 2) {
											vo.setValue(strArr[1].trim());
										}
										return vo;
									} )
									.collect(Collectors.toList());
		return list;
	} catch (IOException ioe) {
		return new ArrayList<>();
	}
}
	
	

	public static void main(String[] args) {
		List<AllStarFullVO> list = readAllStarFull();

		// filter... yearid == 1933 / teamid == NYA / 3번째...skip2 limit3 ?
		Optional<String> playerID = list.stream()
										.filter( vo -> vo.getYearID().equals("1933"))
										.filter( vo -> vo.getTeamID().equals("NYA"))
										.map( vo -> vo.getPlayerID())
										.skip(2)
										//.peek(System.out::println)	// 데이터 흐름 확인용
										.limit(1)
										.findFirst();
		System.out.println(playerID.orElse("없음"));
		
		
		
		// Q2	1700년 NYA팀의 세번째 선수의 playerID를 출력.
		// List<AllStarFullVO> 타입의 list를 Stream<AllStarFullVO> 타입으로 바꿈
		Stream<AllStarFullVO> listStream = list.stream();
		
		// filter 1
		Stream<AllStarFullVO> playersIn1700 =
				listStream.filter(vo->vo.getYearID().equals("1700"));
		// filter 2
		Stream<AllStarFullVO> playersInNYA =
				playersIn1700.filter( vo -> vo.getTeamID().equals("NYA"));
		
		// Stream<AllStarFullVO>였던 데이터 라인을 map을 통해
		// .getPlayerID (String) 데이터를 저장. 타입은 Stream<String>으로 바뀜
		Stream<String> playersId = playersInNYA.map( vo -> vo.getPlayerID());
		
		// 데이터 skip
		Stream<String> skipedPlayersId = playersId.skip(2);
		// limit
		Stream<String> limitedPlayersId = skipedPlayersId.limit(1);
		
		// findFirst ... 데이터를 가져와서 Optional 클래스로 바꿈
		Optional<String> playerId = limitedPlayersId.findFirst();
								// .orElse( T ) ... Null값일 때 T를 반환
		System.out.println(playerId.orElse("없음"));
		
		
		
		// Q3	1934년 CHA팀 startingPos==8 ... playersID출력
		List<String> q3 = list.stream()
							.filter(vo -> vo.getYearID().equals("1934"))
							.filter(vo -> vo.getTeamID().equals("CHA"))
							.filter(vo -> vo.getStartingPos()==8)
							.map(vo -> vo.getPlayerID())
							.collect(Collectors.toList());
		q3.forEach(System.out::println);
		
		// Q4	1934년 CHA팀 startingPos==8 ... 두번째 playersID출력
		Optional<String> q4 = list.stream()
								.filter(vo -> vo.getYearID().equals("1934"))
								.filter(vo -> vo.getTeamID().equals("CHA"))
								.filter(vo -> vo.getStartingPos()==8)
								.map(vo -> vo.getPlayerID())
								.skip(1)
								.findFirst();
		System.out.println(q4.orElse("없음"));
		
		
		// Q5-1	1933년 ... teamID별 playerID를 모두 출력 (group)
		Map<String, List<AllStarFullVO>> teamMap1 = 
				list.stream()
					.filter(vo -> vo.getYearID().equals("1933"))
					
									// groupingBy		그룹으로 묶는다
									// AllStarFullVO	현재 데이터 타입
									// ::getTeamID		그룹이 되는 기준
					// AllStarFullVO타입의 자료에서 getTeamID를 key값으로 그룹하여(List) Map을 만들어줌
//					.collect(Collectors.groupingBy(AllStarFullVO::getTeamID));
					.collect(Collectors.groupingBy(vo->vo.getTeamID()));

		System.out.println(teamMap1);

		teamMap1.forEach((key, value) -> {
			
			// !!출력방법 1
			value.stream()
				.map(vo -> vo.getPlayerID())
				.forEach(vo1 -> {
					System.out.println(key +"////"+vo1);
				});	
			
			// !!출력방법 2
//			for (AllStarFullVO allStarFullVO : value) {
//				System.out.println("5-1." + key + " > " + allStarFullVO.getPlayerID());
//			}
			
		});		
		
			
			
			
		// Q5-2	1933년 ... teamID별 playerID의 수를 모두 출력 (group)
		Map<String, List<AllStarFullVO>> teamMap2 =
				list.stream()
					.filter(vo -> vo.getYearID().equals("1933"))
					.collect(Collectors.groupingBy(AllStarFullVO::getTeamID));
		teamMap2.forEach((key, value) -> {
//			System.out.println(key +"	"+ value.size());
		});
		
		
		// Q6	teamID별 출전 연도를 모두 출력 (group)
			// 출력폼 
			// 6. teamID > yearID
		Map<String, List<AllStarFullVO>> q6 =
				list.stream()
					.collect(Collectors.groupingBy(AllStarFullVO::getTeamID));
		q6.forEach((teamID,value) -> {
			value.forEach(vo -> {
				System.out.println("Q6 "+teamID+" > "+vo.getYearID()); 
			});
		});
		
		
		// Q7	teamID별 출전 연도를 중복제거하여 모두 출력 (group)
		Map<String, List<AllStarFullVO>> q7 =
				list.stream()
					.collect(Collectors.groupingBy(AllStarFullVO::getTeamID));
		
		// teamID를 key값으로 갖는 Map
		q7.forEach((teamID, value) -> {
			// teamID로 분류 된 [ List<AllStarFullVO>의 value ]
			value.stream()		// 중복제거를 위해 stream<AllStarFullVO> 로 변환
				.map(vo -> vo.getYearID())	// AllStarFullVO에서 .getYearID만 가져옴
				.distinct()		// 중복값을 제거
				.forEach(vo -> {
					System.out.println("Q7 "+teamID+" > "+vo);
				});
		});
		
		////////////////////////////////////
		////////////병렬 스트림 연습	////////////
		////////////////////////////////////
		
		
//		List<TextVO> textList = readTextFile();
//		System.out.println(textList.size()); // 데이터 1만개
		
		
		
		
		// Q8-1	10K.ID.CONTENTS 파일에서 "12370584" 의 내용
		long startTime = System.currentTimeMillis();	// 작업시간 확인
		Optional value = readTextFile().stream()
									.filter(vo -> vo.getKey().equals("12370584"))
									.map(vo -> vo.getValue())
									.findFirst();
//									.forEach(System.out::println);	// 출력 다른방법
		System.out.println(value.orElse("없음"));
		
		System.out.println("8-1	runtime: "+(System.currentTimeMillis()-startTime));	// 작업시간 확인
		
		
		
		// Q8-2	(병렬) 10K.ID.CONTENTS 파일에서 "12370584" 의 내용
		startTime = System.currentTimeMillis();	// 작업시간 확인
		readTextFile().parallelStream()
					.filter(vo -> vo.getKey().equals("12370584"))
					.map(vo -> vo.getValue())
					.forEach(System.out::println);
		
		System.out.println("8-2	runtime: "+(System.currentTimeMillis()-startTime));	// 작업시간 확인
		
		
		
		// Q9	(병렬) 10K.ID.CONTENTS 파일에서 "7670637" 단어 개수
		startTime = System.currentTimeMillis();	// 작업시간 확인
		List<String[]> ab = readTextFile().parallelStream()
										.filter(vo -> vo.getKey().equals("7670637"))
										.map(vo -> vo.getValue().split(" "))
										.collect(Collectors.toList());
//										.map(vo -> {
//											return vo.getValue().split(" ").length;
//										})
//										.findFirst();
		
		System.out.println(ab.get(0).length);
		
		System.out.println("9	runtime: "+(System.currentTimeMillis()-startTime));	// 작업시간 확인

		
		
		// Q10	(병렬) 10K.ID.CONTENTS 파일에서 내용이 없는 "번호" 개수
		startTime = System.currentTimeMillis();	// 작업시간 확인
					
		
		
		System.out.println("10	runtime: "+(System.currentTimeMillis()-startTime));	// 작업시간 확인
		
		
		// Q11	(병렬) 10K.ID.CONTENTS 파일에서 두 개의 단어로만 이루어진 "번호" 개수
		startTime = System.currentTimeMillis();	// 작업시간 확인
//		readTextFile().parallelStream()
//					.filter(vo -> vo.getValue().split(" ").length == 2)
					
		
		
//		System.out.println("11	runtime: "+(System.currentTimeMillis()-startTime));	// 작업시간 확인
//		// Q12	(병렬) 10K.ID.CONTENTS 파일에서 내용에 "that" 포함된 글 개수
//		startTime = System.currentTimeMillis();	// 작업시간 확인
//		
//		System.out.println("12	runtime: "+(System.currentTimeMillis()-startTime));	// 작업시간 확인
//		// Q13	(병렬) 10K.ID.CONTENTS 파일에서 글 번호가 6자리 개수
//		startTime = System.currentTimeMillis();	// 작업시간 확인
//		
//		System.out.println("13	runtime: "+(System.currentTimeMillis()-startTime));	// 작업시간 확인
//		// Q14	(병렬) 10K.ID.CONTENTS 파일에서 글 번호가 7자리 개수
//		startTime = System.currentTimeMillis();	// 작업시간 확인
//		
//		System.out.println("14	runtime: "+(System.currentTimeMillis()-startTime));	// 작업시간 확인
//		// Q15	(병렬) 10K.ID.CONTENTS 파일에서 글 번호가 9로 시작하는 모든 글의 첫번째 단어
//		startTime = System.currentTimeMillis();	// 작업시간 확인
//		
//		System.out.println("15	runtime: "+(System.currentTimeMillis()-startTime));	// 작업시간 확인
//		// Q16	(병렬) 10K.ID.CONTENTS 파일에서 
//		startTime = System.currentTimeMillis();	// 작업시간 확인
//		
//		System.out.println("16	runtime: "+(System.currentTimeMillis()-startTime));	// 작업시간 확인
//		// Q17	(병렬) 10K.ID.CONTENTS 파일에서 
//		startTime = System.currentTimeMillis();	// 작업시간 확인
//		
//		System.out.println("17	runtime: "+(System.currentTimeMillis()-startTime));	// 작업시간 확인
//		// Q18	(병렬) 10K.ID.CONTENTS 파일에서 
//		startTime = System.currentTimeMillis();	// 작업시간 확인
//		
//		System.out.println("18	runtime: "+(System.currentTimeMillis()-startTime));	// 작업시간 확인
		
		
		
		
		
		
		
		
//		List<String> ab = new ArrayList<>();
//		ab.add("aa");
//		ab.add("aa");
//		ab.add("cc");
//		ab.forEach(System.out::println);
//		
//		Stream<String> abb = ab.stream();
//		abb.forEach(System.out::println);
		
		
		
		
	}

}
