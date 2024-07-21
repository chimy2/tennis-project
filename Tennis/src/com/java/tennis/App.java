package com.java.tennis;

import java.util.Scanner;

import com.java.tennis.service.ExplainService;
import com.java.tennis.service.RecordService;
import com.java.tennis.service.SettingService;
import com.java.tennis.service.TennisService;
import com.java.tennis.view.MainView;

public class App {
//	기본 한국어 설정
	public static int langIndex = 0;
//	기본 보통 난이도 설정
	public static int difficulty = 2;
	public static boolean loop = true;
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		MainView view = new MainView();
		ExplainService explainService = new ExplainService();
		TennisService tennisService = new TennisService();
		SettingService settingService = new SettingService();
		RecordService recordService = new RecordService();
		
		while(loop) {
			view.getMainMenu();
			
			String input = scan.nextLine();
			
			if (input.equals("1")) {
//				게임시작
				tennisService.gameSetup();
			} else if (input.equals("2")) {
//				명예의 전당
				recordService.record();
			} else if (input.equals("3")) {
//				게임 설명서
				explainService.get();
			} else if (input.equals("4")) {
//				환경설정
				settingService.main();
			} else if (input.equals("5")) {
//				게임 종료
				view.end();
				loop = false;
			} else {
//				입력 오류
				view.errorInput();
			}
		}
	}
}
