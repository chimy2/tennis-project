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
		temp += LanguageService.get("원하는 캐릭터를 선택하세요.");
		temp += "\r\n";
		for(int i=0; i<characterList.size(); i++) {
			temp += (i + 1) + ". ";
			temp += characterList.get(i).getName();
			temp += "\r\n";
		}
		temp += mainView.input();
		System.out.println(temp);
		
//		이곳에서 캐릭터를 보여주고 유저가 맘에드는 캐릭터에 대응하는 번호를 입력하면 그 값으로 캐릭터 값을 리턴해줘야함
		
	}
	
	public void selectGameType() {
		String temp = "";
		
		temp += "\r\n";
		temp += mainView.getSeperator();
		temp += LanguageService.get("게임 타입을 선택해주세요.");
		temp += "\r\n";
		temp += mainView.getSeperator();
		temp += mainView.addMenuMargin("단식", "복식");
//		temp += String.format("1.[%s]\t\t\t2.[%s]",
//				LanguageService.get("단식"),
//				LanguageService.get("복식")
//			);
		temp += "\r\n";
		temp += mainView.input();
		
		System.out.println(temp);
	}
	
	public void selectGameSet() {
		String set = LanguageService.get("세트");
		String temp = "";
		
		temp += "\r\n";
		temp += mainView.getSeperator();
		temp += LanguageService.get("세트 수를 선택해주세요.");
		temp += "\r\n";
		temp += mainView.getSeperator();
		temp += mainView.addMenuMargin("세트", 3, 5);
//		temp += String.format("1.[3%s]\t\t\t2.[5%s]",
//				set,
//				set
//			);
		temp += "\r\n";
		temp += mainView.input();
		
		System.out.println(temp);
	}
	
	public void selectPlayerNumber() {
		String temp = "";

		temp += "\r\n";
		temp += mainView.getSeperator();
		temp += LanguageService.get("플레이어 수를 입력해주세요.");
		temp += "\r\n";
		temp += mainView.getSeperator();
		temp += mainView.addMenuMargin("1명", "2명");
//		temp += String.format("1.[%s]\t\t\t2.[%s]",
//				LanguageService.get("1명"),
//				LanguageService.get("2명")
//			);
		temp += "\r\n";
		temp += mainView.input();
		
		System.out.println(temp);
	}
	
	public void startGame() {
		String temp = "";
		
		temp += "\r\n";
		temp += LanguageService.get("게임을 시작합니다.");
		
		System.out.println(temp);
	}
	
	public void selectSkill() {
		String temp = "";
		
		temp += LanguageService.get("사용할 기술을 선택해주세요.");
		
		System.out.println(temp);
	}
	
	public void recordGame() {
		String temp = "";

		temp += LanguageService.get("게임을 기록하시겠습니까?");
		temp += "\r\n";
		temp += mainView.addMenuMargin("예", "아니요");
//		temp += LanguageService.get("1.예	2.아니오");
		temp += "\r\n";
		
		System.out.println(temp);
	}
	
	public void completeRecordGame() {
		String temp = "";
		
		temp += LanguageService.get("게임 기록이 저장됐습니다.");
		temp += "\r\n";
		
		System.out.println(temp);
	}
}
