package com.java.tennis.view;

import com.github.lalyos.jfiglet.FigletFont;

public class TennisView {

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
		
		System.out.println();
		System.out.println("원하는 캐릭터를 선택하세요.");
		System.out.println("1. 카리나");
		System.out.println("2. 차은우");
		System.out.println("3. 김국진");
		System.out.println("4. 나는솔로10기 옥순이");
		System.out.println();
		
//		이곳에서 캐릭터를 보여주고 유저가 맘에드는 캐릭터에 대응하는 번호를 입력하면 그 값으로 캐릭터 값을 리턴해줘야함
		
	}
	

}
