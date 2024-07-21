package com.java.tennis.dao;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Calendar;

import com.java.tennis.model.GameDTO;

public class GameDAO {
	
	final String PATH = ".\\resource\\game.txt";

	
	public void add(String temp) {
		
		try {
			
			BufferedWriter writer = new BufferedWriter(new FileWriter(PATH, true));
			
			String line = temp;
			
			writer.write(line);
			writer.close();
			
		} catch (Exception e) {
			System.out.println("GameDAO.add");
			e.printStackTrace();
		}
	}
	
	
	public void get() {
//		MatchDAO를 참조함
		
	}
	
	
	
	
}
