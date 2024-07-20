package com.java.tennis.view;

import java.util.ArrayList;

import com.java.tennis.dao.CharacterDAO;
import com.java.tennis.model.CharacterDTO;
import com.java.tennis.service.LanguageService;

public class TennisView {
	CharacterDAO characterDAO;
	MainView mainView;
	ArrayList<CharacterDTO> characterList;
	
	public TennisView() {
		mainView = new MainView();
		characterDAO = new CharacterDAO();
		characterList = characterDAO.get();
	}

	public void getTitle() {
		String temp = "";
		temp += mainView.getSeperator();
		temp += mainView.addStringMarginMultiLine(mainView.getTitle("Game Start"));
		temp += mainView.getSeperator();
		System.out.println(temp);
	}
	
	public void characterSelect() {
		String temp = "";
		temp += "\r\n";
		temp += mainView.getSeperator();
		temp += mainView.addStringMargin("원하는 캐릭터를 선택하세요.");
		temp += mainView.getSeperator();
		for(int i=0; i<characterList.size(); i++) {
			temp += (i + 1) + ". ";
			temp += characterList.get(i).getName();
			temp += "\r\n";
		}
		temp += mainView.getSeperatorThin();
		temp += mainView.input();
		System.out.print(temp);
		
//		이곳에서 캐릭터를 보여주고 유저가 맘에드는 캐릭터에 대응하는 번호를 입력하면 그 값으로 캐릭터 값을 리턴해줘야함
		
	}
	
	public void selectGameType() {
		String temp = "";
		
		temp += "\r\n";
		temp += mainView.getSeperator();
		temp += mainView.addStringMargin("게임 타입을 선택해주세요.");
		temp += mainView.getSeperator();
		temp += mainView.addMenuMarginCenter("단식", "복식");
		temp += mainView.getSeperatorThin();
//		temp += String.format("1.[%s]\t\t\t2.[%s]",
//				LanguageService.get("단식"),
//				LanguageService.get("복식")
//			);
		temp += mainView.input();
		
		System.out.print(temp);
	}
	
	public void selectGameSet() {
		String set = LanguageService.get("세트");
		String temp = "";
		
		temp += "\r\n";
		temp += mainView.getSeperator();
		temp += mainView.addStringMargin("세트 수를 선택해주세요.");
		temp += mainView.getSeperator();
		temp += mainView.addMenuMarginCenter("세트", 3, 5);
		temp += mainView.getSeperatorThin();
//		temp += String.format("1.[3%s]\t\t\t2.[5%s]",
//				set,
//				set
//			);
		temp += mainView.input();
		
		System.out.print(temp);
	}
	
	public void selectPlayerNumber() {
		String temp = "";

		temp += "\r\n";
		temp += mainView.getSeperator();
		temp += mainView.addStringMargin("플레이어 수를 입력해주세요.");
		temp += mainView.getSeperator();
		temp += mainView.addMenuMarginCenter("1명", "2명");
		temp += mainView.getSeperatorThin();
//		temp += String.format("1.[%s]\t\t\t2.[%s]",
//				LanguageService.get("1명"),
//				LanguageService.get("2명")
//			);
		temp += mainView.input();
		
		System.out.print(temp);
	}
	
	public void startGame() {
		String temp = "";
		
		
		System.out.println(temp);
	}
	
	public void selectSkill() {
		String temp = "";
		
		temp += LanguageService.get("사용할 기술을 선택해주세요.");
		
		System.out.println(temp);
	}
	
	public void recordGame() {
		String temp = "";

		temp += mainView.getSeperator();
		temp += LanguageService.get("게임을 기록하시겠습니까?");
		temp += mainView.getSeperator();
		temp += mainView.addMenuMarginCenter("예", "아니요");
		temp += mainView.getSeperatorThin();
//		temp += LanguageService.get("1.예	2.아니오");
		
		System.out.println(temp);
	}
	
	public void completeRecordGame() {
		String temp = "";
		
		temp += LanguageService.get("게임 기록이 저장됐습니다.");
		temp += "\r\n";
		
		System.out.println(temp);
	}
	
	public void informGame(int countSet, int countGame, int countTotalServe) {
		String temp = "";
		temp += mainView.getSeperator();
		temp += mainView.addStringMargin(String.format("%d세트 %d게임 %d회차 서브", countSet, countGame, countTotalServe));
		temp += mainView.getSeperator();
		System.out.println(temp);
	}
}
