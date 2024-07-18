package com.java.tennis.dao;

import java.io.BufferedReader;
import java.io.FileReader;

public class ExplainDAO {
	public static String getExplain(int langIndex) {
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
				result += line + "\r\n";
			}
		} catch (Exception e) {
			System.out.println("ExplainDAO.getExplain");
			e.printStackTrace();
		}
		return result;
	}
}
