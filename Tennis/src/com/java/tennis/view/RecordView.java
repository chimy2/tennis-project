package com.java.tennis.view;

import java.util.Scanner;

import com.java.tennis.service.LanguageService;

public class RecordView {
	private Scanner scan; //뷰에서 스캐너가 필요한지 확인부탁드립니다.

	public RecordView() {
		this.scan = new Scanner(System.in);
	}

	public void title(String title) {
		
		String result = "";
		result += "\r\n";
		result += thingetSeperator();
		result += LanguageService.get(title);
		//result += "\r\n";
		System.out.println(result);
		
	}
	
	public void subtitle(String title) {
		
		String result = "";
		result += "\r\n";
		result += thingetSeperator();
		result += LanguageService.get(title);
		System.out.println(result);
		
	}

	public void titleSpecific() { //명예의전당 속성이름
		
		String result = "";
		result += thingetSeperator();
		result += LanguageService.get("\t번호\t\t날짜\t\t닉네임\t\t캐릭터\t\t스코어");
		result += "\r\n";
		result += thingetSeperator();
		System.out.println(result);
		
	}



	public void subTitleSpecific() { //명예의전당 > 아이디검색 > 아이디입력 > 출력 > 번호입력 > [속성출력]
	
		String result = "";
		result += thingetSeperator();
		result += LanguageService.get("\t세트\t\t게임\t\t스코어\t\t승패");
		result += "\r\n";
		result += thingetSeperator();
		System.out.println(result);
	}

	// 멈춤
	public void pause() {

		System.out.println();
		System.out.print("계속하시려면 엔터를 치세요.");

		Scanner scan = new Scanner(System.in);
		scan.nextLine(); // Block

		System.out.println();

	}
	
	public void mainMenu() {

		MainView dividingLine = new MainView();

		String result = "";
		result += "\r\n";
		result += dividingLine.getSeperator();
		result += LanguageService.get("명예의 전당\r\n");
		result += dividingLine.getSeperator();
		result += LanguageService.get("1. 명예의 전당\r\n");
		result += LanguageService.get("2. 아이디 검색하기\r\n");
		result += LanguageService.get("3. 최신기록 전체보기\r\n");
		result += LanguageService.get("4. 메인메뉴 돌아가기\r\n");
		result += dividingLine.getSeperator();
		System.out.print(result);
		System.out.print("선택(번호): ");
		

	}
	
	public void subMenu(String title) {
		//원본
//		String result = "";
//		result += thingetSeperator();
//		result += LanguageService.get(title+"\r\n");
//		result += thingetSeperator();
//		System.out.println(result);
		
		String result = "";
		result += "\r\n";
		result += thingetSeperator();
		result += LanguageService.get(title);
		System.out.println(result);
	}
	
	public void sortQuestion() {
		
		String result = "";
		result += thingetSeperator();
		result += "정렬이 필요하십니까? \r\n";
		result += thingetSeperator();
		System.out.print(result);
		System.out.println("1. 필요");
		System.out.println("2. 불필요(전 단계로 돌아기기)");
	
	}
	
	public void sortSortQuestion() { //명예의 전당 > 최신기록 > 정렬(필요) > [정렬질문]
		
		String result = "";
		result += "\r\n";
		result += thingetSeperator(); //구분선
		result += "정렬 선택\r\n";
		result += thingetSeperator(); //구분선
		result += "1. 날짜\r\n";
		result += "2. 아이디\r\n";
		result += "3. 캐릭터\r\n";
		result += thingetSeperator();
		System.out.print(result);
		System.out.print("번호 입력: ");
		
		
	}
	
	
	public String getTitle(String title) {

		return title;
	}


	public String thingetSeperator() { //메뉴 외 구분선
		return "------------------------------------------------------------------"
				+ "------------------------------------------------------\r\n";
	}

	public void sortMenu() { //명예의 전당 > 최신기록 > 정렬(필요) > 정렬질문 > [세부정렬질문]

		String sortmenu = "";
		sortmenu += thingetSeperator();
		sortmenu += "정렬선택\r\n";
		sortmenu += thingetSeperator();
		sortmenu += "1. 오름차순\r\n";
		sortmenu += "2. 내림차순\r\n";
		sortmenu += thingetSeperator();
		System.out.print(sortmenu);
		System.out.print("번호 입력: ");
		
	}

	public void errorInput() {
		String result = "";
		result += LanguageService.get("잘못 입력 하셨습니다.");
		result += "\r\n";
		result += LanguageService.get("다시 입력해주세요.");
		System.out.println(result);
	}

}