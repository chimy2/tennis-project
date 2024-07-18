package com.java.tennis.view;

import com.java.tennis.App;
import com.java.tennis.service.LanguageService;

public class SettingView {
	private MainView mainView;
	
	private final int EASY = 1;
	private final int NORMAL = 2;
	private final int HARD = 3;
	
	public SettingView() {
		mainView = new MainView();
	}
	
	public void mainView() {
		String result = "";
		result += mainView.getSeperator();
		result += LanguageService.get("1. 언어 설정 2. 난이도 설정 3. 만든 사람들 4. 디스코드 5. 개발자에게 기부하기 6. 메인 메뉴");
		result += "\r\n";
		result += mainView.getSeperator();
		result += mainView.selectMenu();
		System.out.print(result);
	}
	
	public void setLang() {
		String result = "";
		result += mainView.getSeperator();
		result += LanguageService.get("1. 한국어 2. English 3. 日本語 4. 돌아가기");
		result += "\r\n";
		result += mainView.getSeperator();
		System.out.print(result);
	}
	
	public void setDiff() {
		String result = "";
		result += mainView.getSeperator();
		result += LanguageService.get("1. 쉽게 2. 보통 3. 어렵게 4. 돌아가기");
		result += "\r\n";
		result += mainView.getSeperator();
		System.out.print(result);
	}
	
	public void getDiff() {
		int diff = App.difficulty;
		String result = "> ";
		result += LanguageService.get("현재 난이도는") + " ";
		
		if(diff == EASY) {
			result += LanguageService.get("쉽게");
		} else if(diff == NORMAL) {
			result += LanguageService.get("보통");
		} else if(diff == HARD) {
			result += LanguageService.get("어렵게");
		}
		result += LanguageService.get("입니다.");
		System.out.println(result);
	}
}
