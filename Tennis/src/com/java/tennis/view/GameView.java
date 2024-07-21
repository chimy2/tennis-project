package com.java.tennis.view;

import java.util.ArrayList;

import com.java.tennis.model.CharacterDTO;
import com.java.tennis.model.SkillDTO;
import com.java.tennis.service.LanguageService;
import com.java.tennis.service.SkillService;

public class GameView {
	
	private CharacterDTO dto;
	private SkillService skillService;
	private ArrayList<SkillDTO> skillList;
	private MainView mainView = new MainView();
	
	public GameView() {
		dto = new CharacterDTO();
		skillService = new SkillService();
		skillList = skillService.getSkill();
	}
	
	public void gameView(CharacterDTO dtoCharacter, String currentGameInfo) {
		String skillName = dtoCharacter.getSkill().getName();
		String result = "";
//		int skillCount = skillService.getSkillCount();
		result += mainView.getSeperator();
		result += mainView.getSubTitle("어떤 스킬을 사용하겠습니까?", currentGameInfo);
		result += mainView.getSeperator();
		
		result += mainView.setNumRowMarginNotTrans(
				skillList.stream().map(s -> {
					return skillName.equals(s.getName()) ?
							s.getName() + "(" 
							+ LanguageService.get("필살기") + ")" 
							: s.getName();
				}).toArray(String[]::new));
		result += mainView.getSeperatorThin();
		result += mainView.input();
		System.out.print(result);
	}
}

