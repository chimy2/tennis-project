package com.java.tennis.dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import com.java.tennis.model.AbilityDTO;
import com.java.tennis.model.CharacterDTO;

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
	
	public ArrayList<CharacterDTO> get() {

		ArrayList<CharacterDTO> list = new ArrayList<>();
		try {
			BufferedReader reader = new BufferedReader(new FileReader(PATH));
			
			String line = null;
			
			while((line = reader.readLine()) != null) {
				String[] temp = line.split(",");
				try {
					Integer.parseInt(temp[0]);
					CharacterDTO dto = new CharacterDTO();
					
					dto.setNo(String.valueOf(temp[0]));
					dto.setName(temp[1]);
					dto.setEmoji(temp[2]);
					dto.setAbility(new AbilityDTO(temp[3], temp[4], temp[5], temp[6]));
					dto.setSkill(skilldao.getSkill(Integer.parseInt(temp[7])));
								
					list.add(dto);
				} catch (NumberFormatException e) {
				}
			}
		} catch (Exception e) {
			System.out.println("CharacterDAO.get");
			e.printStackTrace();
		}
		
		return list;
	}
	
}//class CharacterDAO
