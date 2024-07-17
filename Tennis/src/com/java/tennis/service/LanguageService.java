package com.java.tennis.service;

import com.java.tennis.App;
import com.java.tennis.dao.LanguageDAO;

public class LanguageService {
	private LanguageDAO dao;
	
	public LanguageService() {
		dao = new LanguageDAO();
	}
	
	public String get(String line) {
		return dao.get(line, App.langIndex);
	}
	
	public void set(int num) {
		if(num == 1) {	//한국어
			App.langIndex = 0;
		} else if(num == 2) {
			App.langIndex = 1;
		} else if(num == 3) {
			App.langIndex = 2;
		}
	}
}
