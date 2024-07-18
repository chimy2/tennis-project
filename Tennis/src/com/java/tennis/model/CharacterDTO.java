package com.java.tennis.model;

public class CharacterDTO {
	
	private String no;			//일련번호
	private String name;		//캐릭터이름
	private String emoji;		//캐릭터 고유 이모티콘
	private AbilityDTO ability;	//캐릭터능력
	private SkillDTO skill;		//캐릭터스킬
	
	
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmoji() {
		return emoji;
	}
	public void setEmoji(String emoji) {
		this.emoji = emoji;
	}
	public AbilityDTO getAbility() {
		return ability;
	}
	public void setAbility(AbilityDTO ability) {
		this.ability = ability;
	}
	public SkillDTO getSkill() {
		return skill;
	}
	public void setSkill(SkillDTO skill) {
		this.skill = skill;
	}
	
	@Override
	public String toString() {
		return "CharacterDTO [no=" + no + ", emoji=" + emoji + ", name=" + name + ", ability=" + ability + ", skill="
				+ skill + "]";
	}
	
	
	
}
