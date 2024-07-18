package com.java.tennis.view;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import com.github.lalyos.jfiglet.FigletFont;
import com.java.tennis.service.LanguageService;
import com.java.tennis.service.MainService;

public class MainView {
	private Scanner scan;
	
	public MainView() {
		scan = new Scanner(System.in);
	}
	
	public void getMainMenu() {
		String result = "";
		result += getSeperator();
		result += getTitle();
		result += getSeperator();
		result += LanguageService.get("1. 게임 시작하기 2. 명예의 전당 3. 게임 설명 4. 환경 설정 5. 게임 종료");
		result += "\r\n";
		result += getSeperator();
		result += "\r\n";
		result += selectMenu();
		MainService.printLine(result, 200);
	}
	
	public String getTitle() {
		String result = "";
    	try {
			String path = "flf/speed.flf";
			result = FigletFont.convertOneLine(new File(path), "Tennis Simulator");
		} catch (IOException e) {
			e.printStackTrace();
		}
    	return result;
	}
	
	public void pause() {
		System.out.println();
		System.out.println(LanguageService.get("계속하시려면 엔터를 치세요."));
		
		scan.nextLine();	//Block
		System.out.println();
	}
	
	public void end() {
		String result = "";
		result += LanguageService.get("게임을 종료합니다.");
		result += "\r\n";
		result += LanguageService.get("안녕히 가십시오.");
		System.out.println(result);
	}
	
	public void errorInput() {
		String result = "";
		result += LanguageService.get("잘못 입력 하셨습니다.");
		result += "\r\n";
		result += LanguageService.get("다시 입력해주세요.");
		System.out.println(result);
	}
	
	public String selectMenu() {
		return LanguageService.get("메뉴 선택");
	}
	
	public String getSeperator() {
		return "=============================================================================\r\n";
	}
}
