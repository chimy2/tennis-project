package com.java.tennis.view;

import java.io.File;
import java.io.IOException;
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
//		result += LanguageService.get("1. 게임 시작하기 2. 명예의 전당 3. 게임 설명 4. 환경 설정 5. 게임 종료");
//		result += "\r\n";
//		result += "\r\n";
//		result += getSeperator();
		result += getSubTitle("시작 메뉴");
		result += getSeperator();
		result += addMenuMarginCenter("게임 시작하기", "명예의 전당", "게임 설명", " 환경 설정", "게임 종료");
		result += getSeperatorThin();
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
	
	public String getSubTitle(String title) {
		String result = "";
		result = addStringMargin(LanguageService.get(title));
		return result;
	}
	
	public String getSubTitle(String title, String addition) {
		String result = "";
		result = addStringMargin(LanguageService.get(title) + " " + LanguageService.get(addition));
		return result;
	}
	
	public String addStringMargin(String line) {
//		JetBrainsMonoHangul NL 기준 120자
		int crit = 60;
		int size = crit + calcStringLength(line) / 2;
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
	
	public String addMenuMargin(String... menus) {
		int width = 120;
		String result = "";
		int len = menus.length;
		int areaSize = width / len;

		for(int i=0; i<len; i++) {
			String menu = LanguageService.get(menus[i]);
			result += String.format("%-" + (areaSize - calcKRJPStringCount(menu)) + "s", 
					String.format("%d. %s", i + 1, menu));
		}
		
		result += "\r\n";
		
		return result;
	}
	
	public String addMenuMarginCenter(String... menus) {
		int width = 120;
		String result = "";
		int len = menus.length;
		
		for(int i=0; i<len; i++) {
			String menu = LanguageService.get(menus[i]);
			result += String.format("%d. %s", i + 1, menu);
			if(i != len - 1) {
				result += " ".repeat(3);
			}
		}
		
		result = addStringMargin(result);
		
		return result;
	}
	
	public String addMenuMargin(String str, int... nums) {
		int width = 120;
		String result = "";
		int len = nums.length;
		int areaSize = width / len;
		String temp = LanguageService.get(str);
		
		for(int i=0; i<len; i++) {
			result += String.format("%-" + (areaSize - calcKRJPStringCount(temp)) + "s", 
					String.format("%d. %d%s", i + 1, nums[i], temp));
		}
		
		result += "\r\n";
		
		return result;
	}
	
	public int calcStringLength(String str) {
		double result = 0;
		
		for(int i=0; i<str.length(); i++) {
			char c = str.charAt(i);
			if(c < 305) {
				result++;
			} else {
				result += 0.25;
			}
		}
		return (int) result;
	}
	
	public int calcKRJPStringCount(String str) {
		int result = 0;
//		기본 폰트에 맞춰 크기 설정 하기
		for(int i=0; i<str.length(); i++) {
			char c = str.charAt(i);
			if(c >= '가' && c <= '힣' 
					|| c >= 'あ' && c <= 'ん'
					|| c >= 'ア' && c <= 'ン') {
				result++;
			}
		}
		return result;
	}
	
	public void pause() {
		System.out.println();
		System.out.println(LanguageService.get("계속하시려면 엔터를 입력해주세요."));
		
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
	
	public String returnMenu() {
		return LanguageService.get("이전 메뉴로 돌아갑니다.");
	}
	
	public String returnMainMenu() {
		return LanguageService.get("메인 메뉴로 돌아갑니다.");
	}
	
	public String selectMenu() {
		return LanguageService.get("메뉴 선택") + " > ";
	}
	
	public String input() {
		return LanguageService.get("입력") + " > ";
	}
	
	public String getSeperator() {
		return "=================================================================="
				+ "======================================================\r\n";
	}
	public String getSeperatorThin() { //메뉴 외 구분선
		return "------------------------------------------------------------------"
				+ "------------------------------------------------------\r\n";
	}
}