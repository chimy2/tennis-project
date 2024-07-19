package com.java.tennis.service;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import com.github.lalyos.jfiglet.FigletFont;
import com.java.tennis.dao.RecordDAO;
import com.java.tennis.view.MainView;
import com.java.tennis.view.RecordView;

public class RecordService {
	
	private RecordView view;
	private RecordDAO dao;
	private Scanner scan;
 

	public RecordService() {
		this.view = new RecordView();
		this.dao = new RecordDAO();
		this.scan = new Scanner(System.in);
	}
	
	
	public void get() { //명예의전당 출력
		
		view.title("명예의 전당");
		view.titleSpecific();// 간단한 정보 보여주는 메서드
		dao.get();
		
	}
	
	
	
	public void getTotal() {
		
		view.title("최신 기록"); // 길이가 안맞음
		view.titleSpecific();// 간단한 정보 보여주는 메서드
		dao.getTotal();

	}
	
	public void getSpec() {
		
		RecordService sevice = new RecordService();
		
		boolean stop = true;
		while (stop) {
			view.mainMenu(); // 명예의 전당 메뉴
			String menu = scan.nextLine();
			
			
			if (menu.equals("1")) {// 1. 명예의 전당

				sevice.get(); // 명예의 전당 출력
				
				MainView error = new MainView(); //계속하려면 엔터쳐라
				error.pause();

			} else if (menu.equals("2")) {//2. 아이디 검색하기
				
				String list = dao.recordSearch(dao.gameId());
				while(list.equals("")) { //확인되지 않는 아이디 입력시 
					System.out.println("확인되지 않는 아이디입니다.");
					list = dao.recordSearch(dao.gameId());
				} 
					System.out.println(list);
					dao.getSpec(dao.gameNum());
					
				
			}

			else if (menu.equals("3")) {//3. 최신기록 전체보기

				view.subMenu("최신 기록");
				dao.getTotal(); // 전체 최신기록
				//정렬질문
				view.sortQuestion();
				
				System.out.println("1. 날짜");
				System.out.println("2. 아이디");
				System.out.println("3. 캐릭터");
				System.out.println("번호 입력 : ");
				String num = scan.nextLine();
				while (!(num.equals("1") || num.equals("2") || num.equals("3"))) {
					System.out.println("번호 입력 : ");
					num = scan.nextLine();
					
					dao.sort(num);
				} 
					MainView error = new MainView();
					error.errorInput();
					continue;
				

			} else if (menu.equals("4")) {//4. 메인메뉴 돌아가기
				stop = false;
				System.out.println("메인메뉴로 돌아갑니다.");
			} else {

				MainView error = new MainView();
				error.errorInput();
				error.pause();

			}
			

		}
	}
	
	
	
}