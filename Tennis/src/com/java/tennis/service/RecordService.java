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

	public void get() { // 명예의전당 출력

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

				MainView error = new MainView(); // 계속하려면 엔터쳐라
				error.pause();

			} else if (menu.equals("2")) {// 2. 아이디 검색하기

				String list = dao.recordSearch(dao.gameId());
				while (list.equals("")) { // 확인되지 않는 아이디 입력시
					System.out.println("확인되지 않는 아이디입니다.\n메뉴로 돌아가실려면 'q'를 입력해주세요.");
					list = dao.recordSearch(dao.gameId());
					
					if(list.equals("q")) {
						list = "";
						break;
					}
				}
			
				if(!list.equals("")) {
					view.titleSpecific();
				}
				System.out.println(list);
				
				
				if (!(list.equals("") || (list.equals("q")))) { //id 없거나 q 선택했을 때 안돌아가게
					String listSpec = dao.getSpec(dao.gameNum());
					while (listSpec.equals("")) { // 확인되지 않는 번호 입력시
						System.out.println("확인되지 않는 번호입니다.\n메뉴로 돌아가실려면 'q'를 입력해주세요.");

						listSpec = dao.getSpec(dao.gameNum());

						if (listSpec.equals("q")) {
							listSpec = "";
							break;
						}
					}
					if(!listSpec.equals("")) {
						view.subTitleSpecific(); //명예의 전당 > 아이디검색 > 출력 > 번호입력 > [속성 출력]
					}
				System.out.println(listSpec);
				
				}

			}

			else if (menu.equals("3")) {// 3. 최신기록 전체보기

				view.subMenu("최신 기록");
				view.titleSpecific();
				dao.getTotal(); // 전체 최신기록

				view.sortQuestion(); // 정렬질문
				System.out.print(view.thingetSeperator()); // 정렬질문_구분선
				System.out.print("번호 입력: ");
				String need = scan.nextLine(); // 정렬질문_스캔
			
				
				while (!(need.equals("1") || need.equals("2"))) {
					System.out.println("숫자를 다시 입력해주세요.");
					System.out.print("번호 입력: ");
					need = scan.nextLine();
				}
				if (need.equals("1")) {
					
					view.sortSortQuestion(); // 명예의 전당 > 최신기록 > 정렬(필요) > 정렬질문
					
					String num = scan.nextLine();
					while (!(num.equals("1") || num.equals("2") || num.equals("3"))) {
						System.out.println("숫자를 다시 입력해주세요.");
						System.out.print("번호 입력: ");
						num = scan.nextLine();
						
					}
					dao.sort(num);
				}
			} else if (menu.equals("4")) {

				stop = false;
				System.out.println("메인메뉴로 돌아갑니다.");
			}

			else {

				MainView error = new MainView();
				error.errorInput();
				error.pause();

			}

		}
	}

}