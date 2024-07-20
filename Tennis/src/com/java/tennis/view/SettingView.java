package com.java.tennis.view;

import com.java.tennis.App;
import com.java.tennis.service.LanguageService;

public class SettingView {
	private MainView mainView;
	
	public final int EASY = 1;
	public final int NORMAL = 2;
	public final int HARD = 3;
	
	public SettingView() {
		mainView = new MainView();
	}
	
	public void mainView() {
		String result = "";
		result += mainView.getSeperator();
//		result += LanguageService.get("1. 언어 설정 2. 난이도 설정 3. 만든 사람들 4. 디스코드 5. 개발자에게 기부하기 6. 메인 메뉴");
		result += mainView.getSubTitle("환경 설정");
		result += mainView.getSeperator();
		result += mainView.setNumRowMargin("언어 설정", "난이도 설정", "만든 사람들", "디스코드", "개발자에게 기부하기", "메인 메뉴");
		result += mainView.getSeperatorThin();
		result += mainView.selectMenu();
		System.out.print(result);
	}
	
	public void setLang() {
		String result = "";
		result += mainView.getSeperator();
		result += mainView.getSubTitle("언어 설정");
		result += mainView.getSeperator();
		result += mainView.setNumRowMargin("한국어", "English", "日本語", "돌아가기");
		result += mainView.getSeperatorThin();
//		result += LanguageService.get("1. 한국어 2. English 3. 日本語 4. 돌아가기");
//		result += "\r\n";
		System.out.print(result);
	}
	
	public void setDiff() {
		String result = "";
		result += mainView.getSeperator();
		result += mainView.getSubTitle("난이도 설정", getDiff());
		result += mainView.getSeperator();
		result += mainView.setNumRowMargin("쉽게", "보통", "어렵게", "돌아가기");
		result += mainView.getSeperatorThin();
//		result += LanguageService.get("1. 쉽게 2. 보통 3. 어렵게 4. 돌아가기");
//		result += "\r\n";
		System.out.print(result);
	}
	
	public String getDiff() {
		int diff = App.difficulty;
		String result = "";
		result += "(";
		result += LanguageService.get("현재 난이도") + ": ";
		
		if(diff == EASY) {
			result += LanguageService.get("쉽게");
		} else if(diff == NORMAL) {
			result += LanguageService.get("보통");
		} else if(diff == HARD) {
			result += LanguageService.get("어렵게");
		}
		result += ")";
		
		return result;
	}
}
