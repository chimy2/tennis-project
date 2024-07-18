package com.java.tennis.dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

import com.java.tennis.App;
import com.java.tennis.service.LanguageService;

public class SettingDAO {
	private Scanner scan;
	private LanguageService languageService;
	
	public SettingDAO() {
		scan = new Scanner(System.in);
		languageService = new LanguageService();
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
			
			while((line = reader.readLine()) != null) {
				result += line;
				result += "\r\n";
			}
		} catch (Exception e) {
			System.out.println("SettingDAO.getDevelopers");
			e.printStackTrace();
		}
		
		return result;
	}
}
