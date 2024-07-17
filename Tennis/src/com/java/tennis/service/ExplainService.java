package com.java.tennis.service;

import com.java.tennis.dao.ExplainDAO;
import com.java.tennis.view.ExplainView;
import com.java.tennis.view.MenuView;

public class ExplainService {
	ExplainView view;
	MenuView menuView;
	
	public ExplainService() {
		view = new ExplainView();
		menuView = new MenuView();
	}

	public void get() {
		MainService.printLine(ExplainDAO.getExplain());
		menuView.pause();
	}
}
