package com.java.tennis.view;

import java.util.Scanner;

import com.java.tennis.service.LanguageService;

public class RecordView {
	private Scanner scan; //뷰에서 스캐너가 필요한지 확인부탁드립니다.
	private MainView mainView;
	
	public RecordView() {
		this.scan = new Scanner(System.in);
		this.mainView = new MainView();
	}

	public void title(String title) {
		
		String result = "";
		result += "\r\n";
		result += mainView.getSeperator();
		result += mainView.getSubTitle(title);
		System.out.print(result);
		
	}


	public void titleSpecific() { //명예의전당 속성이름
		
		String result = "";
		
		result += mainView.getSeperator();
		result += mainView.setRowMargin(
		        "번호",
		        "날짜",
		        "닉네임",
		        "캐릭터",
		        "스코어"
		        );
		result += mainView.getSeperator();
		System.out.println(result);
	}


	public void subTitleSpecific() {
		String result = "";
		String[] menus = {
		        "세트",
		        "게임",
		        "닉네임",
		        "캐릭터",
		        "스코어"
		    };
		
		result += mainView.getSeperator();
		result += mainView.setRowMargin(
				"세트",
				"게임",
				"스코어",
				"승패");
		result += mainView.getSeperator();
		System.out.println(result);
	}

	// 멈춤
	
	public void mainMenu() {

		String result = "";
		result += "\r\n";
		result += mainView.getSeperator();
		result += mainView.getSubTitle("명예의 전당");
		result += mainView.getSeperator();
		result += mainView.setNumRowMargin("명예의 전당", "아이디 검색하기", "최신기록 전체보기", "메인 메뉴 돌아가기");
		result += mainView.getSeperatorThin();
		result += mainView.input();
		System.out.print(result);
	}
	
	public void sortQuestion() {
		
		String result = "";
		result += mainView.getSeperator();
		result += mainView.getSubTitle("정렬해서 보기를 원하십니까?");
		result += mainView.getSeperator();
		result += mainView.setNumRowMargin("네", "아니요(전 단계로 돌아가기)"); 
		result += mainView.getSeperatorThin();
		result += mainView.input();
		System.out.print(result);
	}
	
	public void sortSortQuestion() { //명예의 전당 > 최신기록 > 정렬(필요) > [정렬질문]
		
		String result = "";
		result += "\r\n";
		result += mainView.getSeperator();
		result += mainView.getSubTitle("무엇을 기준으로 정렬하시겠습니까?");
		result += mainView.getSeperator();
		result += mainView.setNumRowMargin("날짜", "아이디", "캐릭터");
		result += mainView.getSeperatorThin();
		result += mainView.input();
		System.out.print(result);
	}


	public void sortMenu() { //명예의 전당 > 최신기록 > 정렬(필요) > 정렬질문 > [세부정렬질문]

		String sortmenu = "";
		sortmenu += mainView.getSeperator();
		sortmenu += mainView.getSubTitle("정렬을 선택해주세요.");
		sortmenu += mainView.getSeperator();
		sortmenu += mainView.setNumRowMargin("오름차순", "내림차순");
		sortmenu += mainView.getSeperatorThin();
		sortmenu += mainView.input();
		System.out.print(sortmenu);
	}
	
	public void sortMenuCalendar() { //명예의 전당 > 최신기록 > 정렬(필요) > 정렬질문 > [세부정렬질문]

		String sortmenu = "";
		sortmenu += mainView.getSeperator();
		sortmenu += mainView.getSubTitle("정렬을 선택해주세요.");
		sortmenu += mainView.getSeperator();
		sortmenu += mainView.setNumRowMargin("오름차순");
		sortmenu += mainView.getSeperatorThin();
		sortmenu += mainView.input();
		System.out.print(sortmenu);
	}


	public String gameId() { // 명예의 전당 > 아이디 검색하기 > [ 아이디 입력(출력) ]
		String result = "";
		result += mainView.getSeperator();
		result += mainView.getSubTitle("아이디 검색하기", 
				"(" + LanguageService.get("이전 메뉴로 돌아가실려면 'q'를 입력해주세요.") + ")");
		result += mainView.getSeperator();
		result += mainView.input();
		System.out.print(result);
		String id = scan.nextLine();

		return id;
	}
	
	public void errorInput() {
		String result = "";
		result += LanguageService.get("잘못 입력 하셨습니다.");
		result += "\r\n";
		result += LanguageService.get("다시 입력해주세요.");
		result += "\r\n";
		result += mainView.input();
		System.out.print(result);
	}
	
	public void notExist() {
		String result = "";
		result += LanguageService.get("존재하지 않는 정보입니다.");
		result += "\r\n";
		System.out.println(result);
	}
	
}