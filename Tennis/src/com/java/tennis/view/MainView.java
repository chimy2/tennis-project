package com.java.tennis.view;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

import com.github.lalyos.jfiglet.FigletFont;
import com.java.tennis.service.LanguageService;
import com.java.tennis.service.MainService;

public class MainView {
	private Scanner scan;
	private String path;
	
	public MainView() {
		scan = new Scanner(System.in);
		path = "flf/speed.flf";
	}
	
	public void getMainMenu() {
		String result = "";
		result += getSeperator();
		result += getTitle();
		result += getSeperator();
		result += LanguageService.get("1. 게임 시작하기 2. 명예의 전당 3. 게임 설명 4. 환경 설정 5. 게임 종료");
		result += "\r\n";
		result += getSeperator();
		result += selectMenu();
		MainService.printLine(result, 200);
	}
	
	public String getTitle() {
		String result = "";
    	try {
			result = FigletFont.convertOneLine(new File(path), "Tennis Simulator");
		} catch (IOException e) {
			e.printStackTrace();
		}
    	return result;
	}
	
	public String getTitle(String title) {
		String result = "";
    	try {
			result = FigletFont.convertOneLine(new File(path), title);
		} catch (IOException e) {
			e.printStackTrace();
		}
    	return result;
	}
	
	public String addStringMargin(String line) {
//		JetBrainsMonoHangul NL 기준 120자
		int crit = 60;
		int size = crit + calcStringLength(line);
		return String.format("%" + size + "s\r\n", line);
	}
	
	public String addStringMarginMultiLine(String multiLine) {
		String result = "";
		String[] lines = multiLine.split("(\r)?\n");
		
		for(String line : lines) {
			result += addStringMargin(line);
		}
		
		return result;
	}
	
	public int calcStringLength(String str) {
//		int basicLen = 1;
//		double korLen = 120/63.0;
//		double JapLen = 120/75.0;
		
		double result = 0;
		
		for(int i=0; i<str.length(); i++) {
			char c = str.charAt(i);
			if(c < 305) {
				result++;
			} else {
				result += 0.25;
			}
		}
		return (int) result / 2;
	}
	
	public String getSubTitle(String title) {
		return LanguageService.get(title);
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
		return LanguageService.get("메뉴 선택") + " > ";
	}
	
	public String getSeperator() {
		return "=================================================================="
				+ "======================================================\r\n";
	}
}