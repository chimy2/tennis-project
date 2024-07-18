package com.java.tennis.model;

public class AbilityDTO {
	
	private int power;		//힘
	private int agility;	//민첩성
	private int stamina;	//체력
	private int focus;		//정신력
	
	
	public int statModifier(int i) {
		switch (i) {
			case 1:
				return power;
			case 2:
				return agility;
			case 3:
				return stamina;
			case 4:
				return focus;		
		}
		return i;
		
	}
	
	public AbilityDTO() {
		
	}

	public AbilityDTO(String power, String agility, String stamina, String focus) {
		super();
		this.power = Integer.parseInt(power);
		this.agility = Integer.parseInt(agility);
		this.stamina = Integer.parseInt(stamina);
		this.focus = Integer.parseInt(focus);
	}
	
	public int getPower() {
		return power;
	}
	public void setPower(int power) {
		this.power = power;
	}
	
	public int getAgility() {
		return agility;
	}
	public void setAgility(int agility) {
		this.agility = agility;
	}
	
	public int getStamina() {
		return stamina;
	}
	public void setStamina(int stamina) {
		this.stamina = stamina;
	}
	
	public int getFocus() {
		return focus;
	}
	public void setFocus(int focus) {
		this.focus = focus;
	}
	
	@Override
	public String toString() {
		return "AbilityDTO [power=" + power + ", agility=" + agility + ", stamina=" + stamina + ", focus=" + focus
				+ "]";
	}
	
}
