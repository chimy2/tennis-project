package com.java.tennis.service;

import com.java.tennis.App;
import com.java.tennis.dao.LanguageDAO;

public class LanguageService {
	private LanguageDAO dao;
	private final int LANG_KR = 0;
	private final int LANG_EN = 1;
	private final int LANG_JP = 2;
	
	public LanguageService() {
		dao = new LanguageDAO();
	}
	
	public static String get(String line) {
		return LanguageDAO.get(line, App.langIndex);
	}
	
	public void set(int num) {
		if(num == 1) {	//한국어
			App.langIndex = LANG_KR;
		} else if(num == 2) {
			App.langIndex =	LANG_EN;
		} else if(num == 3) {
			App.langIndex = LANG_JP;
		}
	}
}
