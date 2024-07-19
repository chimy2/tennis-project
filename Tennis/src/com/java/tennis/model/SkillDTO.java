package com.java.tennis.model;

import com.java.tennis.service.LanguageService;

public class SkillDTO {
	
//	private double serve;			//서브	
//	private double forehand;		//포핸드
//	private double backhand;		//백핸드
//	private double volly;			//발리
	
	private String name;
	private int probability;

	public SkillDTO(String name, String probability) {
		this.name = name;
		this.probability = Integer.parseInt(probability);
	}
	
	public String getName() {
		return LanguageService.get(name);
	}
	public void setName(String skillName) {
		this.name = skillName;
	}
	public int getProbability() {
		return probability;
	}
	public void setProbability(int probability) {
		this.probability = probability;
	}
	
	
}
