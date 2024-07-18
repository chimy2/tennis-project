package com.java.tennis.view;

import com.github.lalyos.jfiglet.FigletFont;
import com.java.tennis.dao.CharacterDAO;
import com.java.tennis.model.CharacterDTO;

public class TennisView {

	CharacterDTO dto = new CharacterDTO();
	
	public void mainMenu() {
		
		System.out.println("============================================================================================================");
		
		try {
			 String asciiArt1 = FigletFont.convertOneLine("TENNIS   SIMULATOR");
			    System.out.println(asciiArt1);
		} catch (Exception e) {
			System.out.println("TennisView.mainMenu");
			e.printStackTrace();
		}
	
		System.out.println("============================================================================================================");
		System.out.println("1.게임 시작");
		System.out.println("2.게임 기록");
		System.out.println("3.게임 정보");
		System.out.println("4.게임 설정");
		System.out.println("5.종료");
		System.out.println("------------------------------------------------------------------------------------------------------------");
		System.out.println("선택(번호): ");
	}

	public void subtitle(String string) {
		
		System.out.println();
		
		
	}
	
	public void characterSelect() {
		
		CharacterDAO dao = new CharacterDAO();

		String temp = "";
		System.out.println();
		temp += "원하는 캐릭터를 선택하세요.\r\n";
		temp += "1. " + (dao.get(1)).getName() + "\r\n";
		temp += "2. " + (dao.get(2)).getName() + "\r\n";
		temp += "3. " + (dao.get(3)).getName() + "\r\n";
		temp += "4. " + (dao.get(4)).getName() + "\r\n";
		
		System.out.println(temp);
		
//		이곳에서 캐릭터를 보여주고 유저가 맘에드는 캐릭터에 대응하는 번호를 입력하면 그 값으로 캐릭터 값을 리턴해줘야함
		
	}
	

}
