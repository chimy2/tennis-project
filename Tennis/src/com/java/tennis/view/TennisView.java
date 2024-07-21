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
			
			temp += String.format("(%d %s %d %s %d%s %s)", 
					countSet, 
					LanguageService.get("세트"), 
					countGame, 
					LanguageService.get("게임"), 
					countServe, 
					LanguageService.get("회차"),
					LanguageService.get("서브"));
			
		} else {
			
			temp += String.format("(%d %s %d %s %d%s %s)", 
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
	
	public void resultMatch(String name, int winSet, int loseSet) {
		String temp = "";
		temp += mainView.getSeperator();
		temp += mainView.getSubTitleNotTrans(String.format("%s%s [%d-%d] %s", 
				LanguageService.get(name),
				LanguageService.get("이(가)"),
				winSet,
				loseSet,
				LanguageService.get("로 매치를 승리했습니다.")
				));
		temp += mainView.getSeperator();
		System.out.print(temp);
	}
	
	public void resultGame(int countSet, int countGame, String winner, int serveScore, int receiveScore) {
		String text = "";
		text += mainView.getSeperator();
		text += mainView.getSubTitleNotTrans(String.format(
				"%d %s %d%s %s%s", 
				countSet, 
				LanguageService.get("세트"),
				countGame, 
				LanguageService.get("게임의 승자는"),
				winner,
				LanguageService.get("입니다.")
				));
		text += mainView.getSubTitleNotTrans(String.format(
				"%s [%d-%d] %s", 
				LanguageService.get("현재 게임 스코어는"), 
				serveScore, 
				receiveScore, 
				LanguageService.get("입니다.")
				));
		text += mainView.getSeperator();
		text += mainView.getSubTitle("다음 게임을 시작합니다.");
//		text += mainView.getSeperator();
//		text += mainView.getSubTitle("[확인]");
		text += mainView.getSeperatorThin();
		System.out.println(text);
	}

	public String setWinner(int countSet, int pointSet1, int pointSet2, String p1, String p2) {
		
		String text = "";
		
		if (pointSet1 > pointSet2) {
			getSetWinner(countSet, pointSet1, pointSet2, p1);
//			text += mainView.getSeperator();
//			text += mainView.getSubTitleNotTrans(String.format("%d%s %s", countSet, "세트의 승자는", p1, "입니다."));
//			text += mainView.getSubTitleNotTrans(String.format("%s [%d-%d] %s", "현재 세트 스코어는", pointSet1, pointSet2, "입니다."));
//			text += mainView.getSeperator();
//			text += mainView.getSubTitle("다음 세트를 시작합니다.");
//			text += mainView.getSeperatorThin();
//			text += mainView.getSubTitle("[확인]");
//			text += mainView.getSeperatorThin();	
		} else {
			getSetWinner(countSet, pointSet1, pointSet2, p2);
//			text += mainView.getSeperator();
//			text += mainView.getSubTitle(String.format("%d세트의 승자는 %s입니다.", countSet, p2));
//			text += mainView.getSubTitle(String.format("현재 세트 스코어는 [%d-%d] 입니다.", pointSet1, pointSet2));
//			text += mainView.getSeperator();
//			text += mainView.getSubTitle("다음세트를 시작합니다.", LanguageService.get("계속하시려면 엔터를 입력해주세요."));
////			text += mainView.getSeperatorThin();
////			text += mainView.getSubTitle("[확인]");
//			text += mainView.getSeperatorThin();	

		}
		return text;
	}
	
	public String getSetWinner(int countSet, int pointSet1, int pointSet2, String winner) {
		String text = "";
		text += mainView.getSeperator();
		text += mainView.getSubTitleNotTrans(String.format(
				"%d%s %s", 
				countSet, 
				LanguageService.get("세트의 승자는"), 
				winner, 
				LanguageService.get("입니다.")
				));
		text += mainView.getSubTitleNotTrans(String.format(
				"%s [%d-%d] %s", 
				LanguageService.get("현재 세트 스코어는"), 
				pointSet1, 
				pointSet2, 
				LanguageService.get("입니다.")
				));
		text += mainView.getSeperator();
		text += mainView.getSubTitle("다음 세트를 시작합니다.");
//		text += mainView.getSeperatorThin();
//		text += mainView.getSubTitle("[확인]");
		text += mainView.getSeperatorThin();	
		return text;
	}

	public void pointDisplay(int p1, int p2) {
		
		String text = "";
		text += mainView.getSeperator();
		text += mainView.getSubTitleNotTrans(pointName(p1, p2), " ("+LanguageService.get("계속하시려면 엔터를 입력해주세요.")+")");
		text += mainView.getSeperator();
		
		System.out.print(text);
	}

	private String pointName(int p1, int p2) {
			
			String[] pointNames = { "러브", "피프틴", "써티", "포티"	};
			String text;

			if (p1 == p2) {
				if (p1 < 3) {
					text = LanguageService.get(pointNames[p1]) + "-" + LanguageService.get("올");
				} else {
					text = LanguageService.get("듀스");
				}
			} else if (p1 > 3 || p2 > 3) {

				int diff = p1 - p2;
					
				if (diff == 1) {
					text = LanguageService.get("어드밴티지")
							+ LanguageService.get("플레이어")
							+ 1;
				} else if ( diff == -1 ) {
					text =  LanguageService.get("어드밴티지")
							+ LanguageService.get("플레이어")
							+ 2;
				} else if (diff >= 2) {
					text = LanguageService.get("게임")
							+ LanguageService.get("플레이어")
							+ 1;
				} else {
					text = LanguageService.get("게임")
							+ LanguageService.get("플레이어")
							+ 2;
				}
			} else {
					text = LanguageService.get(pointNames[p1]) + "-" + LanguageService.get(pointNames[p2]);
			}
			return text;
	}
}
