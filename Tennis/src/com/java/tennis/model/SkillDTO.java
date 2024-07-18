package com.java.tennis.model;

public class SkillDTO {
	
	private double serve;			//서브	
	private double forehand;		//포핸드
	private double backhand;		//백핸드
	private double volly;			//발리
	
	
	
	
	@Override
	public String toString() {
		return "SkillDTO [serve=" + serve + ", forehand=" + forehand + ", backhand=" + backhand + ", volly=" + volly
				+ "]";
	}
	
}
