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
		temp += mainView.addRowMarginMultiLine(mainView.getTitle("Game Start"));
		temp += mainView.getSeperator();
		temp += "\r\n";
		System.out.println(temp);
	}
	
	public void characterSelect() {
		String temp = "";
		temp += "\r\n";
		temp += mainView.getSeperator();
		temp += mainView.getSubTitle("원하는 캐릭터를 선택하세요.");
		temp += mainView.getSeperator();
		temp += mainView.setNumRowMarginNotTrans(characterList.stream().map(i->i.getName()).toArray(String[]::new));
		temp += mainView.getSeperatorThin();
		temp += mainView.input();
		System.out.print(temp);
		
//		이곳에서 캐릭터를 보여주고 유저가 맘에드는 캐릭터에 대응하는 번호를 입력하면 그 값으로 캐릭터 값을 리턴해줘야함
		
	}
	
	public void selectGameType() {
		String temp = "";
		
		temp += "\r\n";
		temp += mainView.getSeperator();
		temp += mainView.getSubTitle("게임 타입을 선택해주세요.");
		temp += mainView.getSeperator();
		temp += mainView.setNumRowMargin("단식", "복식");
		temp += mainView.getSeperatorThin();
		temp += mainView.input();
		
		System.out.print(temp);
	}
	
	public void selectGameSet() {
		String set = LanguageService.get("세트");
		String temp = "";
		
		temp += "\r\n";
		temp += mainView.getSeperator();
		temp += mainView.getSubTitle("세트 수를 선택해주세요.");
		temp += mainView.getSeperator();
		temp += mainView.setNumRowMargin("세트", 3, 5);
		temp += mainView.getSeperatorThin();
		temp += mainView.input();
		
		System.out.print(temp);
	}
	
	public void selectPlayerNumber() {
		String temp = "";

		temp += "\r\n";
		temp += mainView.getSeperator();
		temp += mainView.getSubTitle("플레이어 수를 입력해주세요.");
		temp += mainView.getSeperator();
		temp += mainView.setNumRowMargin("1명", "2명");
		temp += mainView.getSeperatorThin();
		temp += mainView.input();
		
		System.out.print(temp);
	}
	
	public void selectSkill() {
		String temp = "";
		
		temp += LanguageService.get("사용할 기술을 선택해주세요.");
		
		System.out.println(temp);
	}
	
	public void recordGame() {
		String temp = "";

		temp += mainView.getSeperator();
		temp += mainView.getSubTitle("게임을 기록하시겠습니까?");
		temp += mainView.getSeperator();
		temp += mainView.setNumRowMargin("예", "아니요");
		temp += mainView.getSeperatorThin();
		temp += mainView.input();
		System.out.print(temp);
	}
	
	public void completeRecordGame() {
		String temp = "";
		
		temp += LanguageService.get("게임 기록이 저장됐습니다.");
		temp += "\r\n";
		
		System.out.println(temp);
	}
	
	public String informGame(int countSet, int countGame, int countServe) {	
		
		String temp = "";
		
		if (countServe % 2 == 1) {
			
			temp += String.format("(%d%s %d%s %d%s %s)", 
					countSet, 
					LanguageService.get("세트"), 
					countGame, 
					LanguageService.get("게임"), 
					countServe, 
					LanguageService.get("회차"),
					LanguageService.get("서브"));
			
		} else {
			
			temp += String.format("(%d%s %d%s %d%s %s)", 
					countSet, 
					LanguageService.get("세트"), 
					countGame, 
					LanguageService.get("게임"), 
					countServe, 
					LanguageService.get("회차"),
					LanguageService.get("리시브"));
		}
		
		return temp;
	}
	
	public void recordName() {
		String temp = "";
		
		temp += mainView.getSeperator();
		temp += mainView.getSubTitle("기록할 이름을 입력해주세요.");
		temp += mainView.getSeperator();
		temp += mainView.input();
		System.out.print(temp);
	}
	
	public void checkRecordName(String name) {
		String temp = "";
		
		temp += mainView.getSeperator();
		temp += mainView.getSubTitleNotTrans(
				LanguageService.get("입력하신 이름이"),
				" ",
				name,
				LanguageService.get("이(가) 맞습니까?")
				);
		temp += mainView.getSeperator();
		temp += mainView.setNumRowMargin("예", "아니요");
		temp += mainView.getSeperatorThin();
		temp += mainView.input();
		
		System.out.print(temp);
	}

	public void finalMenu() {
		String temp = "";
		
		temp += mainView.getSeperator();
		temp += mainView.getSubTitle("테니스 시뮬레이터를 플레이 해주셔서 감사합니다.");
		temp += mainView.getSeperatorThin();
		temp += mainView.setNumRowMargin("메인 메뉴", "다시 하기");
		temp += mainView.getSeperator();
		temp += mainView.input();
		
		System.out.print(temp);
	}
}
