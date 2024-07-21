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
		result += mainView.getSubTitle("환경 설정");
		result += mainView.getSeperator();
		result += mainView.setNumRowMargin("언어 설정", "난이도 설정", "만든 사람들", "깃허브", "개발자에게 기부하기", "메인 메뉴");
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
		System.out.print(result);
	}
	
	public void setDiff() {
		String result = "";
		result += mainView.getSeperator();
		result += mainView.getSubTitle("난이도 설정", getDiff());
		result += mainView.getSeperator();
		result += mainView.setNumRowMargin("쉬움", "보통", "어려움", "돌아가기");
		result += mainView.getSeperatorThin();
		System.out.print(result);
	}
	
	public String getDiff() {
		int diff = App.difficulty;
		String result = "";
		result += "(";
		result += LanguageService.get("현재 난이도") + ": ";
		
		if(diff == EASY) {
			result += LanguageService.get("쉬움");
		} else if(diff == NORMAL) {
			result += LanguageService.get("보통");
		} else if(diff == HARD) {
			result += LanguageService.get("어려움");
		}
		result += ")";
		
		return result;
	}
}
