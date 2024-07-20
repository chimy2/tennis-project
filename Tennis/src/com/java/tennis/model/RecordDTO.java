package com.java.tennis.model;

import com.java.tennis.service.LanguageService;

public class RecordDTO {
	
	//---------------------------
	//기록과 관련된 멤버 변수와 멤버메서드만 정리
	// 간단한 기록 정보
	// 일련번호, 날짜, 닉네임, 캐릭터 번호, 스코어1(나), 스코어2(컴퓨터)
	// 1,2024-04-03,현영석,3,2,0
	private String no;					//일련번호
	private String date;			//날짜
	private String name;			//닉네임
	private String characterno;		//캐릭터 번호
	private String charactername;		//캐릭터 이름 > 캐릭터 번호와 연동
	private String scoreme;			//스코어1(나)
	private String socrecumputer;		//스코어2(컴퓨터)
	
	
	// 세부 기록 정보
	// 일련번호, 세트 번호, 게임 번호, 스코어1(나), 스코어2(컴퓨터) 
	// 1,1,1,4,0 
	private MatchDTO match;			//세트 번호
	private TennisDTO tennis;		// 게임 번호
	
//	private CharacterDTO character;	//캐릭터 > 캐릭터 번호 가져오기
	
	
	
	
	
	
	public String getCharactername() {
		return LanguageService.get(charactername);
	}
	public void setCharactername(String charactername) {
		this.charactername = charactername;
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getScoreme() {
		return scoreme;
	}
	public void setScoreme(String scoreme) {
		this.scoreme = scoreme;
	}
	public String getSocrecumputer() {
		return socrecumputer;
	}
	public void setSocrecumputer(String socrecumputer) {
		this.socrecumputer = socrecumputer;
	}
	public TennisDTO getTennis() {
		return tennis;
	}
	public String getCharacterno() {
		return characterno;
	}
	public void setCharacterno(String characterno) {
		this.characterno = characterno;
	}
	public void setTennis(TennisDTO tennis) {
		this.tennis = tennis;
	}
	public MatchDTO getMatch() {
		return match;
	}
	public void setMatch(MatchDTO match) {
		this.match = match;
	}
	
	
	@Override
	public String toString() {
		return String.format(
				"RecordDTO [no=%s, date=%s, name=%s, scoreme=%s, socrecumputer=%s, tennis=%s, match=%s]",
				no, date, name, scoreme, socrecumputer, tennis, match);
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
	
}
