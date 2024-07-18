package com.java.tennis.view;

import java.util.Scanner;

public class RecordView {
	private Scanner scan;
public RecordView() {
	this.scan = new Scanner(System.in);
}	
	
	public void title(String title) {
		System.out.println();
		System.out.println("=======================================" + title + "=======================================");
	}

	public void titleSpecific() {
		System.out.println("-----------------------------------------------------------------------------------------");
		System.out.println("\t번호\t\t날짜\t\t닉네임\t\t캐릭터\t\t스코어");
		System.out.println("-----------------------------------------------------------------------------------------");
	}
	
	
	
	
	public void subTitle(String title) {
		System.out.println();
		System.out.println("======================================" + title + "======================================");
	}
	
	public void subTitleSpecific() {
		System.out.println("-----------------------------------------------------------------------------------------");
		System.out.println("\t세트\t\t게임\t\t스코어\t\t승패");
		System.out.println("-----------------------------------------------------------------------------------------");
	}
	
	
	
	//멈춤
	public void pause() {
		
		System.out.println();
		System.out.print("계속하시려면 엔터를 치세요.");
		
		Scanner scan = new Scanner(System.in);
		scan.nextLine(); //Block
		
		System.out.println();
		
	}
	
	
	public void mainMenu() {

		System.out.println("======================================");
		System.out.println("               명예의 전당");
		System.out.println("======================================");
		System.out.println("1. 명예의 전당");
		System.out.println("2. 아이디 검색하기");
		System.out.println("3. 최신기록 전체보기");
		System.out.println("4. 메인메뉴 돌아가기");
		System.out.println("--------------------------------------");
		System.out.print("선택(번호): ");
		
//		int num = -1;
//		num = scan.nextInt();
//		
//		if(num >= 1 && num <=4) {
//			return num;
//		}else {
//			System.out.println("번호를 잘 못 입력했습니다.다시 입력하세요");
//		}
//		
//		return num;
		
	

	}
	
	
	
	public void serchMenu() {

		System.out.println("======================================");
		System.out.println("      검색 상세 기록");
		System.out.println("======================================");
		System.out.println("상세 기록 확인 (Y/N)");
		System.out.println("--------------------------------------");
		System.out.print("선택(Y/N): ");

	}
	
	
	public void serchMenuSpec() {

		System.out.println("======================================");
		System.out.println("      검색 상세 기록");
		System.out.println("======================================");
		System.out.println("상세 기록 확인 (Y/N)");
		System.out.println("--------------------------------------");
		System.out.print("선택(Y/N): ");

	}
	
	//최근기록 > 아이디 입력
	public void idMenu() {
		
		System.out.println("===================");
		System.out.println("       아이디");
		System.out.println("===================");
		

	}
	
	public void dividingLine() {
		System.out.println();
		System.out.println("=========================================================================================");
	}
	
	
public void sortMenu() {
		
		System.out.println("======================================");
		System.out.println("               정렬선택");
		System.out.println("======================================");
		System.out.println("1. 오름차순");
		System.out.println("2. 내림차순");
		System.out.println("--------------------------------------");
		System.out.print("선택(번호): ");
		
	}
	
}
