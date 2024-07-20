package com.java.tennis.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import com.java.tennis.dao.RecordDAO;
import com.java.tennis.view.MainView;
import com.java.tennis.view.RecordView;

public class RecordService {

	private RecordView view;
	private RecordDAO dao;
	private Scanner scan;
	private MainView mainView;

	public RecordService() {
		this.view = new RecordView();
		this.dao = new RecordDAO();
		this.scan = new Scanner(System.in);
		this.mainView = new MainView();
	}

	public void winnerRecord() { // 명예의전당 출력

		view.title("명예의 전당");
		view.titleSpecific();// 간단한 정보 보여주는 메서드
		System.out.println(dao.get()); // 명예의 전당 출력
		mainView.pause();// 계속하려면 엔터쳐라

	}

	public void searchId() {// 아이디 검색하기

		view.title("아이디 검색하기");
		String list = dao.recordSearch(dao.gameId());

		while (list.equals("")) { // 확인되지 않는 아이디 입력시

			view.notExist();
			list = dao.recordSearch(dao.gameId());

			if (list.equals("q")) {
				list = "q";
				break;
			}
		}

		if (!(list.equals("") || list.equals("q"))) {// 아이디를 제대로 적은 경우
			view.titleSpecific();
			System.out.println(list);
		}

		if (!(list.equals("") || (list.equals("q")))) { // id 없거나 q 선택했을 때 안돌아가게
			String listSpec = dao.getSpec(dao.gameNum());
			while (listSpec.equals("")) { // 확인되지 않는 번호 입력시
				view.notExist();
				listSpec = dao.getSpec(dao.gameNum());

				if (listSpec.equals("q")) {
					listSpec = "";
					break;
				}
			}
			if (!listSpec.equals("")) {
				view.subTitleSpecific(); // 명예의 전당 > 아이디검색 > 출력 > 번호입력 > [속성 출력]
			}
			System.out.println(listSpec);

		}
		mainView.pause();// 계속하려면 엔터쳐라

	}

	public void recentRecord() { // 최신기록 전체보기 출력

		view.title("최신기록 전체보기");
		view.titleSpecific();// 간단한 정보 보여주는 메서드

		String lineArray = dao.getTotal();
		System.out.println(lineArray);

		view.sortQuestion(); // 정렬질문
		String need = scan.nextLine(); // 정렬질문_스캔
		while (!(need.equals("1") || need.equals("2"))) {
			view.errorInput();
			need = scan.nextLine();
		}
		if (need.equals("1")) {

			view.sortSortQuestion(); // 명예의 전당 > 최신기록 > 정렬(필요) > 정렬질문

			String num = scan.nextLine();
			while (!(num.equals("1") || num.equals("2") || num.equals("3"))) {
				view.errorInput();
				num = scan.nextLine();

			}
			dao.sort(num);
		}
	}

	
	// 명예의 전당 전체 작동
	public void record() {


		boolean stop = true;
		while (stop) {
			view.mainMenu(); // 명예의 전당 메뉴
			String menu = scan.nextLine();

			if (menu.equals("1")) {// 1. 명예의 전당

				winnerRecord();

			} else if (menu.equals("2")) {// 2. 아이디 검색하기
				searchId();

			}

			else if (menu.equals("3")) {// 3. 최신기록 전체보기

				recentRecord();

			} else if (menu.equals("4")) {

				stop = false;
				mainView.returnMainMenu();
			} else {

				mainView.errorInput();
				mainView.pause();

			}

		}
	}

}