package com.java.tennis.dao;

import java.io.BufferedReader;
import java.io.FileReader;

import com.java.tennis.App;
import com.java.tennis.view.MainView;

public class ExplainDAO {
	private static MainView mainView;
	
	public ExplainDAO() {
		mainView = new MainView();
	}
	
	public String getExplain() {
		int langIndex = App.langIndex;
		String result = "";
		String path = "";
		
		if(langIndex == 1) {
			path = "resource/explain_en.txt";
		} else if(langIndex == 2) {
			path = "resource/explain_jp.txt";
		} else {
			path = "resource/explain_kr.txt";
		}
		
		try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
			String line = "";
			
			while((line = reader.readLine()) != null) {
				try {
					String[] temp = line.split("\\.");
					Integer.parseInt(temp[0]);
					result += mainView.getSeperator();
					result += line + "\r\n";
					result += mainView.getSeperator();
				} catch (Exception e) {
					result += line + "\r\n";
				}
			}
		} catch (Exception e) {
			System.out.println("ExplainDAO.getExplain");
			e.printStackTrace();
		}
		return result;
	}
}
