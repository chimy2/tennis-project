package com.java.tennis.dao;

import java.io.BufferedReader;
import java.io.FileReader;

import com.java.tennis.model.AbilityDTO;
import com.java.tennis.model.CharacterDTO;
import com.java.tennis.model.SkillDTO;

public class CharacterDAO {
	
	final String PATH = "resource\\character.txt";
	private SkillDAO skilldao;
	
	public CharacterDAO() {

		skilldao = new SkillDAO();
	}
	
	public CharacterDTO get(int num) {
		
		try {
			
			BufferedReader reader = new BufferedReader(new FileReader(PATH));
			
			String line = null;
			
			
				while ((line = reader.readLine()) != null) {
				
				if (line.startsWith(String.valueOf(num))) {
					
					String[] temp = line.split(",");
					
					CharacterDTO dto = new CharacterDTO();


					dto.setNo(String.valueOf(temp[0]));
					dto.setName(temp[1]);
					dto.setEmoji(temp[2]);
					dto.setAbility(new AbilityDTO(temp[3], temp[4], temp[5], temp[6]));
					dto.setSkill(skilldao.getSkill(Integer.parseInt(temp[7])));
								
					return dto;
					
				}
				
			}
			reader.close();
		} catch (Exception e) {
			System.out.println("CharacterDAO.get");
			e.printStackTrace();
		}
	
		

		return null;
	}
	
}//class CharacterDAO
