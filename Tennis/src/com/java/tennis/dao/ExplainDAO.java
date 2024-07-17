package com.java.tennis.dao;

import java.io.BufferedReader;
import java.io.FileReader;

public class ExplainDAO {
	public static String getExplain() {
		String result = "";
		String path = "resource/explain.txt";
		
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
