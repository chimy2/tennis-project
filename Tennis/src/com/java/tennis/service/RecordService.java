package com.java.tennis.service;

import java.util.Scanner;

import com.java.tennis.dao.RecordDAO;
import com.java.tennis.view.MainView;
import com.java.tennis.view.RecordView;

public class RecordService {
	
	private RecordView view;
	private RecordDAO dao;
	private Scanner scan;
 
//	MenuView menuView;

	public RecordService() {
		this.view = new RecordView();
		this.dao = new RecordDAO();
		this.scan = new Scanner(System.in);
	}
	
	
	public void get() {
		
		view.title("명예의 전당"); // 길이가 안맞음
		view.titleSpecific();// 간단한 정보 보여주는 메서드
		dao.get();

	}
	
	
	public void getTotal() {
		
		view.title("최신 기록"); // 길이가 안맞음
		view.titleSpecific();// 간단한 정보 보여주는 메서드
		dao.getTotal();

	}
	
//	public void getSort() {
//
//		view.title("날짜 순서"); // 길이가 안맞음
////		view.titleSpecific();// 간단한 정보 보여주는 메서드
//		System.out.print("번호 선택 : ");
//		int number = scan.nextInt();
//		dao.sort(number);
//
//	}
	
	
	

	
	
	public void getSpec() {
		
		RecordService sevice = new RecordService();
		
		boolean stop = true;
		while (stop) {
			view.mainMenu(); // 명예의 전당 메뉴
			int menu = scan.nextInt();
			scan.skip("\r\n");
			
			if (menu == 1) {
				
				sevice.get(); //명예의 전당 출력
				


			} else if (menu == 2) {
				
//				System.out.println("아이디 입력: ");
				String list = dao.recordSearch(dao.gameId());
//				String num = scan.nextLine();
//				dao.check(num);
//				dao.recordSearch(num);
				if(list.equals("")) {
					System.out.println("잘못된 아이디 입니다.");
				} else {
					System.out.println(list);
					dao.getSpec(dao.gameNum());
					
				}
			}

			else if (menu == 3) {
				//
				
				view.subTitle("최신 기록");
				dao.getTotal(); // 전체 최신기록
				System.out.println("1. 날짜");
				System.out.println("2. 아이디");
				System.out.println("3. 캐릭터");
				
				System.out.println("번호 입력 : ");
				int num = scan.nextInt();
				dao.sort(num);
				
			} else if(menu == 4) {
				stop = false;
				System.out.println("메인메뉴로 돌아갑니다.");
				
				//break;
			} else {
				MainView error = new MainView();
				error.errorInput();
			}

		}
	}
	
	
	
}
