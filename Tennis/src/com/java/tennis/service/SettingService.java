package com.java.tennis.service;

import java.awt.Desktop;
import java.net.URI;
import java.util.Scanner;

import com.java.tennis.App;
import com.java.tennis.dao.SettingDAO;
import com.java.tennis.view.MainView;
import com.java.tennis.view.SettingView;

public class SettingService {
	private SettingView view;
	private SettingDAO dao;
	private Scanner scan;
	private LanguageService languageService;
	private MainView mainView;

	
	public SettingService() {
		view = new SettingView();
		dao = new SettingDAO();
		scan = new Scanner(System.in);
		languageService = new LanguageService();
		mainView = new MainView();
	}
	
	public void main() {
		while(true) {
			view.mainView();
			String input = scan.nextLine();
			
			if(input.equals("1")) {
//				언어 설정
				setLang();
			} else if(input.equals("2")) {
//				난이도 설정
				setDifficulty();
			} else if(input.equals("3")) {
//				만든 사람들
				getDevelopers();
			} else if(input.equals("4")) {
//				디스코드
				getDiscord();
			} else if(input.equals("5")) {
//				개발자에게 기부
				getPaypal();
			} else if(input.equals("6")) {
				break;
			} else {
				mainView.errorInput();
			}
		}
	}

	public void setLang() {
		while(true) {
			view.setLang();
			System.out.print(mainView.selectMenu());
			
			String input = scan.nextLine();
			try {
				int num = Integer.parseInt(input.trim());
				
				if(num >= 1 && num <= 3) {
					languageService.set(num);
					break;
				} else if(num == 4) {
					break;
				} else {
					throw new Exception("잘못된 입력");
				}
			} catch (Exception e) {
				mainView.errorInput();
			}
		}
	}
	
	public void setDifficulty() {
		while(true) {
			view.setDiff();
			view.getDiff();
			System.out.print(mainView.selectMenu());
			String input = scan.nextLine();

			try {
				int num = Integer.parseInt(input.trim());
				
				if(num >= 1 && num <= 3) {
					App.difficulty = num;
					break;
				} else if(num == 4) {
					break;
				} else {
					throw new Exception("잘못된 입력");
				}
			} catch (Exception e) {
				mainView.errorInput();
			}
		}
	}
	
	public void getDevelopers() {
		System.out.println(dao.getDevelopers());
	}
	
	public void getDiscord() {
		String url = "https://discord.com/";
		
		try {
			Desktop.getDesktop().browse(new URI(url));
		} catch (Exception e) {
			System.out.println("SettingService.getDiscord");
			e.printStackTrace();
		}
	}
	
	public void getPaypal() {
		String url = "https://www.paypal.com/";
		
		if(App.langIndex == 0) {
			url += "kr/home?locale.x=ko_KR";
		} else if(App.langIndex == 1) {
			url += "us";
		} else if(App.langIndex == 2) {
			url += "jp";
		} 
		
		try {
			Desktop.getDesktop().browse(new URI(url));
		} catch (Exception e) {
			System.out.println("SettingService.getPaypal");
			e.printStackTrace();
		}
	}
	
}
