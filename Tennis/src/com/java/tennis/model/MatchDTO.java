package com.java.tennis.model;

import java.util.Calendar;

public class MatchDTO {
	
	private int no;					//일련번호
	private Calendar date;			//날짜
	private String name;			//유저 이름
	private int character;			//캐릭터 이름		
	private int mePointSet;			//유저 세트 점수
	private int cpuPointSet;		//컴퓨터 세트 점수
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public Calendar getDate() {
		return date;
	}
	public void setDate(Calendar date) {
		this.date = date;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCharacter() {
		return character;
	}
	public void setCharacter(int character) {
		this.character = character;
	}
	public int getMePointSet() {
		return mePointSet;
	}
	public void setMePointSet(int mePointSet) {
		this.mePointSet = mePointSet;
	}
	public int getCpuPointSet() {
		return cpuPointSet;
	}
	public void setCpuPointSet(int cpuPointSet) {
		this.cpuPointSet = cpuPointSet;
	}
	
	@Override
	public String toString() {
		return "MatchDTO [no=" + no + ", date=" + date + ", name=" + name + ", character=" + character + ", mePointSet="
				+ mePointSet + ", cpuPointSet=" + cpuPointSet + "]";
	}
	
}
























