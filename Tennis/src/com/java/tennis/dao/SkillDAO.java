package com.java.tennis.dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import com.java.tennis.model.CharacterDTO;
import com.java.tennis.model.SkillDTO;

public class SkillDAO {
	
	final String PATH = "resource\\skill.txt";
	
	public SkillDTO getSkill(int num) {
		SkillDTO skill = null;
		
		try {
			
			BufferedReader reader = new BufferedReader(new FileReader(PATH));
			
			String line = null;
			
			while ((line = reader.readLine()) != null) {
				
				String[] temp = line.split(",");
				try {
					int skillNum = Integer.parseInt(temp[0]);
					if (skillNum == num) {
						skill = new SkillDTO(temp[1], temp[2]);
						break;
					}
				} catch (Exception e) {
				}
			}
			
		} catch (Exception e) {
			System.out.println("SkillDAO.getSkill");
			e.printStackTrace();
		}
		return skill;
		
	}
	
	public ArrayList<SkillDTO> getSkill() {
		ArrayList<SkillDTO> list = new ArrayList<>();
		try {
			
			BufferedReader reader = new BufferedReader(new FileReader(PATH));
			
			String line = null;
			
			while ((line = reader.readLine()) != null) {
				String[] temp = line.split(",");
				try {
					Integer.parseInt(temp[0]);
					SkillDTO skill = new SkillDTO(temp[1], temp[2]);
					list.add(skill);
				} catch (Exception e) {
				}
			}
			
		} catch (Exception e) {
			System.out.println("SkillDAO.getSkill");
			e.printStackTrace();
		}
		return list;
	}
	
	public int getSkillCount() {
		int count = 0;
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(PATH));
			
			String line = "";
			
			while((line = reader.readLine()) != null) {
				String[] temp = line.split(",");
				
				try {
					Integer.parseInt(temp[0]);
					count++;
				} catch (Exception e) {
				}
			}
		} catch (Exception e) {
			System.out.println("SkillDAO.getSkillCount");
			e.printStackTrace();
		}
		
		return count;
	}
}
