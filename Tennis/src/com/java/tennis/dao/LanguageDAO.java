package com.java.tennis.dao;

import java.io.BufferedReader;
import java.io.FileReader;

public class LanguageDAO {
	private static final String path = "resource/lang.txt";

	public static String get(String sentence, int langIndex) {
		String result = "";
		if(langIndex == 0) {
			return sentence;
		} else {
			try(BufferedReader reader = new BufferedReader(new FileReader(path))) {
				String line = "";
				
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
