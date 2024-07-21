package com.java.tennis.dao;

import java.io.BufferedReader;
import java.io.FileReader;

import com.java.tennis.model.AbilityDTO;

public class AbilityDAO {
	
	final String PATH = "resource\\character.txt";
	
	public AbilityDTO get(int num) {
		
		try {
			
			BufferedReader reader = new BufferedReader(new FileReader(PATH));
			
			String line = null;
			
				while ((line = reader.readLine())!= null) {
					
					if (line.startsWith(String.valueOf(num))) {
						
						String [] temp = line.split(",");
						
						AbilityDTO dto = new AbilityDTO();
						
						dto.setPower(Integer.parseInt(temp[3]));
						dto.setAgility(Integer.parseInt(temp[4]));
						dto.setStamina(Integer.parseInt(temp[5]));
						dto.setFocus(Integer.parseInt(temp[6]));
						
						return dto;
						
						}
				}
				reader.close();
			
				
		} catch (Exception e) {
			System.out.println("AbilityDAO.get");
			e.printStackTrace();
		}
		return null;
	
	}

}
