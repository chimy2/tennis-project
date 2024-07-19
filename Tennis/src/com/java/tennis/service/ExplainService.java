package com.java.tennis.service;

import com.java.tennis.dao.ExplainDAO;
import com.java.tennis.view.ExplainView;
import com.java.tennis.view.MainView;

public class ExplainService {
	private ExplainView view;
	private MainView mainView;
	private ExplainDAO dao;
	
	public ExplainService() {
		view = new ExplainView();
		mainView = new MainView();
		dao = new ExplainDAO();
	}

	public void get() {
		MainService.printLine(dao.getExplain());
		mainView.pause();
	}
}
