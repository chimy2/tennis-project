package com.java.tennis.dao;

import java.io.BufferedReader;
import java.io.FileReader;

public class LanguageDAO {
	private final String path = "resource/lang.txt";

	public String get(String sentence, int langIndex) {
		String result = "오류가 발생했습니다.";
		if(langIndex == 0) {
			return sentence;
		} else {
			try {
				String line = "";
				BufferedReader reader = new BufferedReader(new FileReader(path));
				
				while((line = reader.readLine()) != null) {
					String[] sentences = line.split(",");
					if(sentences[0].equals(sentence)) {
						result = sentences[langIndex];
						break;
					}
				}
			} catch (Exception e) {
				System.out.println("LanguageDAO.get");
				e.printStackTrace();
			}
		}
		
		return result;
	}
	

}
