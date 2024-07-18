package com.java.tennis.service;

import com.java.tennis.App;
import com.java.tennis.dao.ExplainDAO;
import com.java.tennis.view.ExplainView;
import com.java.tennis.view.MainView;

public class ExplainService {
	private ExplainView view;
	private MainView mainView;
	
	public ExplainService() {
		view = new ExplainView();
		mainView = new MainView();
	}

	public void get() {
		MainService.printLine(ExplainDAO.getExplain(App.langIndex));
		mainView.pause();
	}
}
