package com.java.tennis.dao;

import java.io.BufferedReader;
import java.io.FileReader;

import com.java.tennis.model.CharacterDTO;
import com.java.tennis.model.SkillDTO;

public class SkillDAO {
	
	final String PATH = "resource\\skill.txt";
	
	public SkillDTO getSkill(int num) {
	
		try {
			
			BufferedReader reader = new BufferedReader(new FileReader(PATH));
			
			String line = null;
			
			while ((line = reader.readLine()) != null) {
				
				if (line.startsWith(String.valueOf(num))) {
				
					String[] temp = line.split(",");
					
					CharacterDTO dto = new CharacterDTO();
					
					
					
				}
			}
			
	
		
			
			
		} catch (Exception e) {
			System.out.println("SkillDAO.getSkill");
			e.printStackTrace();
		}
		
		
		
		return null;
		
	}
}
