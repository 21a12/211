package com.ktdsuniversity.edu.stream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BasballStream1 {

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

	public static void main(String[] args) {
		List<AllStarFullVO> list = readAllStarFull();

		list.stream()
			.filter( (vo) -> vo.getYearID().equals("1933") )
			.forEach( (vo) -> {
			System.out.println(vo.getPlayerID());
			System.out.println(vo.getYearID());
			});
		
		List<AllStarFullVO> playIn1933 = list.stream()
											.filter( (vo) -> vo.getYearID().equals("1933") )
											.collect(Collectors.toList());
		
		AllStarFullVO vo00 = list.stream()
							.filter( (vo1) -> vo1.getYearID().equals("1933") )
							.findFirst()	// 첫번째 값 찾기
//							.get();		// optional의 메소드
							.orElse(new AllStarFullVO());	//값이 없을 때 사용..에러방지
		System.out.println(vo00.getPlayerID());
		
		// 연도에 관계없이 이름이 f로 시작하는 친구들 뽑아오기
		List<AllStarFullVO> nameF = list.stream()
									.filter( f -> f.getPlayerID().toLowerCase().startsWith("f"))
									.collect(Collectors.toList());
		for (AllStarFullVO ff : nameF) {
			System.out.println(ff.getPlayerID());
		}
		System.out.println(nameF.size());
		
		System.out.println("---------------------");
		list.stream()
			.filter( (allStarVO) -> allStarVO.getYearID().equals("2004"))
			.filter( (allStarVO) -> allStarVO.getTeamID().equals("TEX"))
			.forEach( (allStarVO) -> {
				System.out.println(allStarVO.getPlayerID());
				System.out.println(allStarVO.getYearID());
				System.out.println(allStarVO.getTeamID());
			});
		
		
		System.out.println("---------------------");
		List<AllStarFullVO> startingPos = list.stream()
											.filter( pos -> pos.getStartingPos() == 0)
											.collect(Collectors.toList());
			
		for (AllStarFullVO pos : startingPos) {
			System.out.println(pos.getPlayerID());
		}
		System.out.println(startingPos.size());
		
		
		System.out.println("---------------------");
		// gp ==0 / teamID NYA / playerid ... "fo"포함
		List<AllStarFullVO> filter = list.stream()
										.filter( gp -> gp.getGP()==0)
										.filter( teamID -> teamID.getTeamID().equals("NYA"))
										.filter( playerID -> playerID.getPlayerID().toLowerCase().contains("fo"))
										.collect(Collectors.toList());
		for (AllStarFullVO players : filter) {
			System.out.println(players.getPlayerID());			
			System.out.println(players.getYearID());			
		}
		
		
		 
		System.out.println("---------------------");
		
		List<String> playerNameList = list.stream()
										.map( (allStarVO) -> allStarVO.getPlayerID() )
										.distinct()
										.sorted()
										.collect(Collectors.toList());
		
		playerNameList.forEach(System.out::println);
		System.out.println(playerNameList.size());

		
		System.out.println("---------------------");
		// 1. .filter ( startingPos == 4 ... getPlayerID
		// 2. .distinct
		// 3. .sorted
		List<String> pos4PlayerID = list.stream()
									.filter( (vo) -> vo.getStartingPos()==4 )
									.filter( vo -> vo.getPlayerID().matches(".*01"))
									.map( vo -> vo.getPlayerID())
									.distinct()
									.sorted()
									.collect(Collectors.toList());
		pos4PlayerID.forEach(System.out::println);
		
		
		System.out.println(pos4PlayerID.size());
		
		List<String> a = list.stream()
							.filter( vo -> vo.getYearID().matches("195.*"))
							.map( vo1 -> vo1.getPlayerID())
							.distinct()
							.collect(Collectors.toList());
		a.forEach(aaa -> {
			System.out.println(aaa);
		});
		
		System.out.println("------------------------");
		list.stream()
			.filter( vo -> vo.getYearID().startsWith("200"))
			.filter( vo -> vo.getTeamID().equals("BOS"))
			.map( vo -> vo.getPlayerID())
			.distinct()
			.forEach(System.out::println);
		
		
		System.out.println("------------------------");
		AllStarFullVO first = list.stream()
								.filter( vo -> vo.getYearID().matches("1937"))
								.filter( vo -> vo.getTeamID().equals("DET"))
								.findFirst()
								.orElse( new AllStarFullVO());
		System.out.println(first.getPlayerID());
		
		
		
		
		
	}

}
