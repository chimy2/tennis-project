package com.java.tennis.dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

import com.java.tennis.App;
import com.java.tennis.service.LanguageService;
import com.java.tennis.service.MainService;
import com.java.tennis.view.MainView;

public class SettingDAO {
	private Scanner scan;
	private LanguageService languageService;
	private MainView mainView;
	
	public SettingDAO() {
		this.scan = new Scanner(System.in);
		this.languageService = new LanguageService();
		this.mainView = new MainView();
	}
	
	public String getDevelopers() {

		String path = "resource/developer";
		String result = "";
		
		try {
			int langSetting = App.langIndex;
			if(langSetting == languageService.LANG_KR) {
				path += "_kr.txt";
			} else if(langSetting == languageService.LANG_EN) {
				path += "_en.txt";
			} else if(langSetting == languageService.LANG_JP) {
				path += "_jp.txt";
			}
			
			BufferedReader reader = new BufferedReader(new FileReader(path));
			
			String line;
			int count = 0;
			while((line = reader.readLine()) != null) {
				if(count % 3 == 0) {
					result += mainView.getSeperator();
					result += mainView.getSubTitleNotTrans(line);
					result += mainView.getSeperator();
				} else {
					result += mainView.getSubTitleNotTrans(line);
				}
//				result += "\r\n";
				count++;
			}
			MainService.printLines(result, 5);
		} catch (Exception e) {
			System.out.println("SettingDAO.getDevelopers");
			e.printStackTrace();
		}
		
		return result;
	}
}
