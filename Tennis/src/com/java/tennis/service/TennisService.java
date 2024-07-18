package com.java.tennis.service;

import java.util.Random;
import java.util.Scanner;

import com.java.tennis.dao.CharacterDAO;
import com.java.tennis.model.AbilityDTO;
import com.java.tennis.model.CharacterDTO;
import com.java.tennis.model.RecordDTO;
import com.java.tennis.model.TennisDTO;
import com.java.tennis.view.GameView;
import com.java.tennis.view.TennisView;

public class TennisService {
	
	String PATHCharacter = "C:\\class\\project\\Tennis\\resource\\character.txt";
	
	private TennisView view = new TennisView();
//	private TennisDAO dao = new TennisDAO();
	private TennisDTO dto = new TennisDTO();
	private Scanner scan = new Scanner(System.in);
	
	static int countTotalServe; //한 매치에 총 서브 횟수 (매치가 끝날 때 리셋)
	static int countServe; //몇 번째 서브 (게임이 끝날 때 리셋)
	static int countGame; //몇 번째 게임 (세트가 끝날 때 리셋)
	static int countSet; //몇 번째 세트 (매치가 끝날 때 리셋)
	
	TennisDTO me = new TennisDTO();
	TennisDTO cpu = new TennisDTO();
	RecordDTO dtoRecord = new RecordDTO();
	CharacterDAO daoCharacter = new CharacterDAO();
	
//	private int point;		//포인트
//	private int gamePoint; //게임 포인트
//	private int setPoint; //세트 포인트
//	
//	static int serveCount; //몇 번째 서브 (게임이 끝날 때 리셋)
//	static int gameCount; //몇 번째 게임 (세트가 끝날 때 리셋)
//	static int setCount; //몇 번째 세트 (매치가 끝날 때 리셋)

	public TennisService() {
		this.dto = new TennisDTO();
		this.view = new TennisView();
//		this.dao = new TennisDAO();
		this.scan = new Scanner(System.in);
	}

	public void gameSetup() {
//		단식/복식 -> 세트 수 -> 플레이어수 -> 캐릭터 선택
		
		
		
		int type = 0; // 1 = 단식, 2 = 복식
		int set = 0; // 1 = 3세트, 2 = 5세트
		int player = 0; //1 = 유저 1명, 2 = 유저 2명
		int character = 0; //게임 캐릭터 고유일련번호
		
		view.subtitle("게임 시작");
		
		boolean loop = true;
		while (loop) {
			
			System.out.println();
			System.out.println("게임 타입을 선택해주세요.");
			System.out.println("1.[단식]		2.[복식]");
			type = scan.nextInt();
			dto.setType(type);
			scan.skip("\r\n");
			
			if (type == 1 || type == 2) {
				loop = false;
			} else {
				System.out.println("올바른 번호를 입력하세요.");
				continue;
			}
			
		}
		
		loop = true;
		while (loop) {
			
			System.out.println();
			System.out.println("세트 수를 입력해주세요.");
			System.out.println("1.[3세트]		2.[5세트]");
			set = scan.nextInt();
			dto.setSet(set);
			scan.skip("\r\n");
			
			if (set == 1 || set == 2) {
				loop = false;
			} else {
				System.out.println("올바른 번호를 입력하세요.");
				continue;
			}
		}
		
		loop = true;
		while (loop) {
			
			System.out.println();
			System.out.println("유저 수를 입력해주세요.");
			System.out.println("1.[1명]		2.[2명]");
			player = scan.nextInt();
			dto.setPlayer(player);
			scan.skip("\r\n");
			
			if (player == 1 || player == 2) {
				loop = false;
			} else {
				System.out.println("올바른 번호를 입력하세요.");
				continue;
			}
		}
		
		loop = true;
		while (loop) {
			
			System.out.println();
			view.characterSelect();
			character = scan.nextInt();
			scan.skip("\r\n");
			
			if (character == 1 || character == 2|| character == 3 || character ==4) {
				loop = false;
			} else {
				System.out.println("올바른 번호를 입력하세요.");
				continue;
			}
		}
		
		
		;
		dto.setType(type);
		dto.setSet(set);
		dto.setPlayer(player);

		
		gameStart(dto, daoCharacter.get(character));
	
	}

	private void gameStart(TennisDTO dto, CharacterDTO dtoCharacter) {
		
		String p1 = "Player1";
		String p2 = "Player2";
		
		countServe = 1;
		countTotalServe = 1;
		countGame = 1;
		countSet = 1;
		
		
		
		System.out.println("게임을 시작합니다.");
		boolean loop = true;
		while (loop) {

			AbilityDTO dtoAbility = new AbilityDTO();
			int input;
			GameView viewGame = new GameView();
			viewGame.gameView(dtoCharacter);
			input = scan.nextInt();
			scan.skip("\r\n");
			
			Random rnd = new Random();
			me.chance = rnd.nextInt(100) + 50 + dtoAbility.statModifier(input); //stats[i]
			cpu.chance = rnd.nextInt(100) + 1;

			System.out.println();
			System.out.printf("%d세트 %d게임 %d회차 서브\r\n", countSet, countGame, countTotalServe);
	
			
			if (me.chance > cpu.chance) {
				me.point++;
				countTotalServe++;
				countServe++;
				System.out.println(p1 + " 득점!");
//				여기에 본인/컴퓨터 포인트를 인자값으로 받아서 러브 피프틴 써티 포티 이런 걸 말해주는 메서드 구현 필요
			} else if (me.chance < cpu.chance) {
				cpu.point++;
				countTotalServe++;
				countServe++;
//				여기에 본인/컴퓨터 포인트를 인자값으로 받아서 러브 피프틴 써티 포티 이런 걸 말해주는 메서드 구현 필요
				System.out.println(p2 + " 득점!");			
			} else {
				continue;
			}
			System.out.println(me.point + "-" + cpu.point);
			System.out.println("[확인]");
			scan.nextLine();
			
			
		}
		pointCheck();

		}
	
	






	private void pointCheck() {
		
		boolean loop = true;
		while (loop) {
		if (me.point > 3 && me.point - cpu.point > 1) {
			
			
			me.pointGame++;
			break;
		}
		
		if (cpu.point > 3 && cpu.point - me.point > 1) {
			
			cpu.pointGame++;
			break;
		}
		
	}
		
	}


	public void gameRecord() {
		// TODO Auto-generated method stub
		
	}

	public void gameInfo() {
		// TODO Auto-generated method stub
		
	}

	public void gameSetting() {
		// TODO Auto-generated method stub
		
	}

	
}

class TestingService {

	private int chance;
	private int point;
	
	private int pointGame;
	private int pointSet;
	
	static int countServe;
	static int countTotalServe;
	static int countGame;
	static int countSet;
	
	public static void main(String[] args) {

//		m1();
		m2();
		
	

	
	}//main


private static void m2() {

		Scanner scan = new Scanner(System.in);
		TestingService me = new TestingService();
		TestingService cpu = new TestingService();
		
		String p1 = "Player1";
		String p2 = "Player2";
		
		countServe = 1;
		countTotalServe = 1;
		countGame = 1;
		countSet = 1;

		boolean loop = true;
		while (loop) {
			
			
			Random rnd = new Random();
			me.chance = rnd.nextInt(100)+1+50;
			cpu.chance = rnd.nextInt(100)+1;
			
			
			//포인트 조건
			System.out.println();
			System.out.printf("%d세트 %d게임 %d회차 서브\r\n", countSet, countGame, countTotalServe);
			
			if (me.chance > cpu.chance) {
				me.point++;
				countTotalServe++;
				countServe++;
				System.out.println(p1 + " 득점!");
			} else if (me.chance < cpu.chance) {
				cpu.point++;
				countTotalServe++;
				countServe++;
				System.out.println(p2 + " 득점!");			
			} else {
				continue;
			}
			System.out.println(me.point + "-" + cpu.point);
			System.out.println("[확인]");
			emptyScreen();
			scan.nextLine();
			
			
			//게임 포인트 조건
			if (me.point > 3 && me.point - cpu.point > 1) {
				me.pointGame++;
				me.point = 0;
				cpu.point = 0;
				System.out.println();
				System.out.printf("%d세트 %d게임의 승자는 %s입니다.\r\n", countSet, countGame, p1);
				System.out.printf("현재 게임 스코어는 [%d-%d] 입니다.\r\n", me.pointGame, cpu.pointGame);
				System.out.println("다음 게임을 시작합니다.");
				System.out.println("[확인]");
				emptyScreen();
				countGame++;
				countTotalServe = 1;
				scan.nextLine();
			} else if (cpu.point > 3 && cpu.point - me.point > 1) {
				cpu.pointGame++;
				me.point = 0;
				cpu.point = 0;
				System.out.println();
				System.out.printf("%d세트 %d게임의 승자는 %s입니다.\r\n", countSet, countGame, p2);
				System.out.printf("현재 게임 스코어는 [%d-%d] 입니다.\r\n", me.pointGame, cpu.pointGame);
				System.out.println("다음 게임을 시작합니다.");
				System.out.println("[확인]");
				emptyScreen();
				countGame++;
				countTotalServe = 1;
				scan.nextLine();
			}
			
			//세트 포인트 조건
			if (me.pointGame > 5 && me.pointGame - cpu.pointGame > 1) {
				
				me.pointSet++;

				me.point = 0;
				me.pointGame = 0;
				cpu.point = 0;
				cpu.pointGame = 0;
				System.out.println();
				System.out.printf("%d세트의 승자는 %s입니다.\r\n", countSet, p1);
				System.out.printf("현재 세트 스코어는 [%d-%d] 입니다.\r\n", me.pointSet, cpu.pointSet);
				System.out.println("다음 세트를 시작합니다.");
				System.out.println("[확인]");
				countServe = 1;
				countGame = 1;
				countSet++;
				
			} else if (cpu.pointGame > 5 && cpu.pointGame - me.pointGame > 1) {
				
				cpu.pointSet++;

				me.point = 0;
				me.pointGame = 0;
				cpu.point = 0;
				cpu.pointGame = 0;
				System.out.println();
				System.out.printf("%d세트의 승자는 %s입니다.\r\n", countSet, p2);
				System.out.printf("현재 세트 스코어는 [%d-%d] 입니다.\r\n", me.pointSet, cpu.pointSet);
				System.out.println("다음 세트를 시작합니다.");
				System.out.println("[확인]");
				countServe = 1;
				countGame = 1;
				countSet++;
			}

//			매치 포인트 조건
			if (me.pointSet > minSetCheck()) {
				
			}
			
			
			
			
		}
		scan.close();
	}



	private static int minSetCheck() {

//		if 

	return 0;
}


	private static void emptyScreen() {
		
//		for (int i=0; i<30; i++) System.out.println();
		
}


	private static void m1() {


		Random rnd = new Random();
		
		int i = 0;
		while (i <=100) {
			System.out.println(rnd.nextInt(10)+1);
			i++;
		}
		
	}
	
	
	
}

