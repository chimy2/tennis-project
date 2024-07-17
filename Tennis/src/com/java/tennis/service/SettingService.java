package com.java.tennis.service;

import com.java.tennis.dao.SettingDAO;
import com.java.tennis.view.SettingView;

public class SettingService {
	private SettingView view;
	private SettingDAO dao;
	
	public SettingService() {
		view = new SettingView();
		dao = new SettingDAO();
	}
	
	
}
