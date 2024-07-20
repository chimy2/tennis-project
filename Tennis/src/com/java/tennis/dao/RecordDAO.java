package com.java.tennis.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

import com.java.tennis.model.RecordDTO;
import com.java.tennis.service.LanguageService;
import com.java.tennis.view.MainView;
import com.java.tennis.view.RecordView;

public class RecordDAO {
	private RecordView view;
	private Scanner scan;
//	private RecordDTO dto;
	private MainView mainView;

	private Stack<String> historyStack;
	private String currentPage;
	HashMap<String, String> dumy = new HashMap<>();

	public RecordDAO() {
		this.view = new RecordView();
		this.scan = new Scanner(System.in);
//		this.dto = new RecordDTO();
		this.mainView = new MainView();
	}

	private final String PATH = ".\\resource\\"; // 변경되면 안됌

	// 정보 불러오는 메서드----------------------------------------------------------------

	// 간단한 정보 불러오기
	public void get() { // 명예의전당

		String line = null;
		int count = 0;
		String[] temp = null;
		int num = 1;

		try {
			BufferedReader reader = new BufferedReader(new FileReader(PATH + "record.txt"));

			// 1,2024-04-03,현영석,3,2,0
			// 번호 날짜 닉네임 캐릭터 스코어 점수
			//
			while ((line = reader.readLine()) != null) {

				temp = line.split(",");

				String character = nameCharacter(temp[3]);

				String score = "";
				score = temp[4] + " : " + temp[5];
				String list = String.format("\t%2s\t\t%s\t%s\t\t%s\t\t%s", temp[0], temp[1], temp[2], LanguageService.get(character), score);

				System.out.println(list);
				count++;

				if (count == 10) { // 10줄만 보이고 싶어
					break;
				}

			}

			String result = ""; // 구분선
			result += view.thingetSeperator();
			System.out.println(result);

			System.out.println();

			reader.close();

		} catch (Exception e) {
			System.out.println("RecordDAO.get");
			e.printStackTrace();
		}

	}

	// 상세한 정보 불러오기

	public String getSpec(String num) { // id입력
		String result = "";
		String line = null;
		try {
			BufferedReader reader = new BufferedReader(new FileReader(PATH + "game.txt"));

//			view.subTitleSpecific(); //명예의 전당 > 아이디검색 > 출력 > 번호입력 > [속성 출력]

			while ((line = reader.readLine()) != null) {

				String[] temp = line.split(",");

				String dump = dumy.get(num);
				if (temp[0].equals(dump)) {

					// 1,1,1,4,0
					// 번호 세트 게임 스코어점수

					String score = "";
					score = temp[3] + " : " + temp[4];

					String win = "";
					if ((temp[3].compareTo(temp[4])) > 0) {
						win = "승";
					} else {
						win = "패";
					}

					result += String.format("\t%s세트\t\t%s게임\t\t%s\t\t %s\n", temp[1], temp[2], score, win);

				}
			}

//			System.out.println(result);

			if (num.equals("q")) {
				result = "q";
			}

//			MainView error = new MainView();
//			System.out.println(error.getSeperator()); //구분선 > 출력이 마지막 구현이라 구분해주려고 선 추가
//			error.pause(); //계속하시려면 엔터
//			

			reader.close();
		} catch (Exception e) {
			System.out.println("RecordDAO.getSpec");
			e.printStackTrace();
		}

		return result;
	}

	// 검색 기능 : 이름 검색하면 불러올 수 있는 기능
	public String recordSearch(String id) {

		// 간단한 점수 저장------------------------------------------
		// 일련번호, 날짜, 이름, 캐릭터 번호, 스코어1(나), 스코어2(컴퓨터)
		// 1,2024-04-03,현영석,3,2,0
		String result = "";
		String line = null;
		int i = 1;

		try {
			BufferedReader reader = new BufferedReader(new FileReader(PATH + "record.txt"));

			while ((line = reader.readLine()) != null) {
				String[] temp = line.split(",");

				if (temp[2].equals(id)) {
					String character = nameCharacter(temp[3]);

					String score = "";
					score = temp[4] + " : " + temp[5];

					String list = String.format("\t%2s\t\t%s\t%s\t\t%s\t\t%s\n", i, temp[1], temp[2], character, score);

					result += list;
					String numChange = String.format("%s", i);
					dumy.put(numChange, temp[0]);
					i++;
				}
				
				
			}

			if (id.equals("q")) {
				result = "q";
			}
			
			reader.close();
		} catch (Exception e) {
			System.out.println("RecordDAO.recordSearch");
			e.printStackTrace();
		}
		
		return result;
	}

	public String gameId() { // 명예의 전당 > 아이디 검색하기 > [ 아이디 입력(출력) ]

		String result = "";
		result += "\r\n";
		result += view.thingetSeperator();
		result += "아이디 검색\r\n";
		result += view.thingetSeperator();
		result += "아이디 입력 : ";
		System.out.print(result);
		String id = scan.nextLine();
		System.out.println();

		return id;
	}

	public String gameNum() {

//		mainView.input();
		String result = "";
		result += view.thingetSeperator();
		result += "번호 입력 : ";
		System.out.print(result);
		String num = scan.nextLine();
		System.out.println();

		return num;

	}

	public ArrayList<String> getTotal() {

		String line = null;
		String list = null;
		ArrayList<String> lineArray = new ArrayList<>();
		String[] temp = null;
		int num = 1;
	
		
		
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(PATH + "record.txt"));

			// 1,2024-04-03,현영석,3,2,0
			// 번호 날짜 닉네임 캐릭터 스코어 점수
			
			while ((line = reader.readLine()) != null) {

				temp = line.split(",");

				String character = nameCharacter(temp[3]);

				String score = "";
				score = temp[4] + " : " + temp[5];

				//10개씩 보여주기
				lineArray.add(String.format("\t%2s\t\t%s\t%s\t\t%s\t\t%s", num, temp[1], temp[2], character, score));

//				System.out.print(list);

//				System.out.println(lineArray.get(0));
				num++;

			}
		
			
			
			
			
			String thinline = "";	//구분선
			thinline += view.thingetSeperator();
			System.out.println(thinline);
			System.out.println();
			
			reader.close();
			
		} catch (Exception e) {
			System.out.println("RecordDAO.get");
			e.printStackTrace();
		}
		return lineArray;
	}

	public void sort(String number) {
		String line = null;
		String lineTemp = null;
		String[] temp = null;
		int num = 1;

		try {
			// 일련번호, 날짜, 이름, 캐릭터 번호, 스코어1(나), 스코어2(컴퓨터)
			// 1,2024-04-03,현영석,3,2,0
			ArrayList<RecordDTO> list = new ArrayList<RecordDTO>();
			BufferedReader reader = new BufferedReader(new FileReader(PATH + "record.txt"));
			System.out.println(); // 줄 간격 맞추려고 만든 것

			while ((line = reader.readLine()) != null) {

				temp = line.split(",");
				temp[1] = temp[1].replace("-", "");
				RecordDTO dto = new RecordDTO();
				dto.setNo(temp[0]); // 일련번호
				dto.setDate(temp[1]); // 날짜
				dto.setName(temp[2]); // 이름
				dto.setCharacterno(temp[3]); // 캐릭터 > 번호를 이름으로 변경하는 메서드 만들어야 함

				dto.setCharactername(temp[3]); // 캐릭터이름
				dto.setScoreme(temp[4]); // 내 점수
				dto.setSocrecumputer(temp[5]); // 컴퓨터 점수

				dto.setCharactername(nameCharacter(temp[3]));

				list.add(dto);

//					

			}

			stack(list, number); // 정렬 메서드

			int i = 1;
			for (RecordDTO record : list) {

				String dump = record.getDate();
				dump = dump.substring(0, 4) + "-" + dump.substring(4, 6) + "-" + dump.substring(6);

				String character = nameCharacter(record.getCharacterno());
//			

				String tempRecord = "";
				tempRecord = String.format("%d\t%s\t%s\t%s\t%s : %S", i, dump, record.getName(),
						record.getCharactername(), record.getScoreme(), record.getSocrecumputer());
				System.out.println(tempRecord);

				i++;
			}

			MainView error = new MainView();
			System.out.println(error.getSeperator()); // 구분선 > 정렬출력으로 출력이 모두 끝나서 구분해주려고 선 추가
			error.pause(); // 정렬선택(오름차순/내림차순) > 출력 > 계속하려면 엔터쳐라

			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void stack(ArrayList<RecordDTO> list, String number) {

		view.sortMenu();
		String sort = scan.nextLine();

		while (!(sort.equals("1") || sort.equals("2"))) {
			System.out.println("숫자를 다시 입력해주세요.");
			System.out.print("번호 입력: ");
			sort = scan.nextLine();
		}

		if (sort.equals("1") || sort.equals("2")) {
			if (number.equals("1")) {// 날짜
				if (sort.equals("1")) {
					list.sort(Comparator.comparing(RecordDTO::getDate)); // 정렬(오름차순)

				} else {
					list.sort(Comparator.comparing(RecordDTO::getDate).reversed()); // 정렬(내림차순)
				}
			} else if (number.equals("2")) {
				if (sort.equals("1")) {
					list.sort(Comparator.comparing(RecordDTO::getName)); // 정렬(오름차순)

				} else {
					list.sort(Comparator.comparing(RecordDTO::getName).reversed()); // 정렬(내림차순)
				}
			} else if (number.equals("3")) {
				if (sort.equals("1")) {
					list.sort(Comparator.comparing(RecordDTO::getCharactername)); // 정렬(오름차순)

				} else {
					list.sort(Comparator.comparing(RecordDTO::getCharactername).reversed()); // 정렬(내림차순)
				}
			}
		} else {
			MainView error = new MainView();
			error.errorInput();
		}
		System.out.println(); // 줄 간격맞추려고 만든 것
		view.titleSpecific();// 명예의 전당 > 최신 기록 > 정렬(필요) > 아이디 > 정렬선택 > 속성출력

	}

	public static String nameCharacter(String number) {

		String character = "";
		try {
			BufferedReader reader = new BufferedReader(new FileReader(".\\resource\\character.txt"));
			String[] tempCharacter = new String[4];
			String[] tempRecorde = new String[4];
			String line = null;
			int i = 0;

			while ((line = reader.readLine()) != null) {

				if (i > 0) { // 첫 번째 줄은 무시
					tempCharacter = line.split(",");
					if (tempCharacter.length > 1) {
						tempRecorde[i - 1] = tempCharacter[1].trim(); // 이름만 추출해서 저장
					}
				}

				i++;
			}

			if (number.equals("1")) {
				character = tempRecorde[Integer.parseInt(number) - 1];
			} else if (number.equals("2")) {
				character = tempRecorde[Integer.parseInt(number) - 1];
			} else if (number.equals("3")) {
				character = tempRecorde[Integer.parseInt(number) - 1];
			} else if (number.equals("4")) {
				character = tempRecorde[Integer.parseInt(number) - 1];
			}

			reader.close();

		} catch (Exception e) {
			System.out.println("에러");
		}

		return character;
	}

	
	
	
	
	
	
	
	
	
}