package com.java.tennis.view;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import com.github.lalyos.jfiglet.FigletFont;
import com.java.tennis.service.MainService;

public class MenuView {
	Scanner scan;
	
	public MenuView() {
		scan = new Scanner(System.in);
	}
	
	public void getMainMenu() {
		String result = "";
		result += "===================================================================================";
		result += "===================================================================================";
		result += "\r\n";
		result += getTitle();
		result += "===================================================================================";
		result += "===================================================================================";
		result += "\r\n";
		result += "메뉴 선택";
		result += "\r\n";
		result += "1. 게임 시작하기 2. 명예의 전당 3. 게임 설명 4. 환경 설정 5. 게임 종료";
		result += "\r\n";
		result += "\r\n";
		result += "\r\n";
		result += "메뉴 입력: ";
		MainService.printLine(result, 200);
	}
	
	public String getTitle() {
		String result = "";
    	try {
			String path = "fif/caligraphy.flf";
			result = FigletFont.convertOneLine(new File(path), "Tennis Simulator");
		} catch (IOException e) {
			e.printStackTrace();
		}
    	return result;
	}
	
	public void pause() {
		System.out.println();
		System.out.println("계속하시려면 엔터를 치세요.");
		
		scan.nextLine();	//Block
		System.out.println();
	}
}
