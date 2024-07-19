package com.java.tennis.service;

import java.util.ArrayList;

import com.java.tennis.dao.SkillDAO;
import com.java.tennis.model.SkillDTO;

public class SkillService {
	SkillDAO skillDAO;
	
	public SkillService() {
		skillDAO = new SkillDAO();
	}
	
	public SkillDTO getSkill(int skillNum) {
		return skillDAO.getSkill(skillNum);
	}
	
	public ArrayList<SkillDTO> getSkill() {
		return skillDAO.getSkill();
	}
	
	public int getSkillCount() { 
		return skillDAO.getSkillCount();
	}
}
