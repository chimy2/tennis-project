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
		result += getSubTitle("시작 메뉴");
		result += getSeperator();
		result += setNumRowMargin("게임 시작하기", "명예의 전당", "게임 설명", "환경 설정", "게임 종료");
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
		result = setRowMargin(title);
		return result;
	}

	public String getSubTitle(String title, String addition) {
		String result = "";
		result = setRowMarginNotTrans(LanguageService.get(title) + " " + addition);
		return result;
	}
	
	public String getSubTitleNotTrans(String... titles) {
		String result = "";
		for(int i=0; i<titles.length; i++) {
			result += titles[i];
		}
		result = setRowMarginNotTrans(result);
		return result;
	}
		
	
	public String addRowMarginMultiLine(String multiLine) {
		String result = "";
		String[] lines = multiLine.split("(\r)?\n");
		
		for(String line : lines) {
			result += setRowMarginNotTrans(line);
		}
		
		return result;
	}
	
//	public String addMenuMarginCenter(String... menus) {
//		String result = "";
//		int len = menus.length;
//		
//		for(int i=0; i<len; i++) {
//			String menu = LanguageService.get(menus[i]);
//			result += String.format("%d. %s", i + 1, menu);
//			if(i != len - 1) {
//				result += " ".repeat(3);
//			}
//		}
//		
//		result = setRowMargin(result);
//		
//		return result;
//	}
	
	public String setRowMargin(String... rows) {
		
		for(int i=0; i<rows.length; i++) {
			rows[i] = LanguageService.get(rows[i]);
		}

		StringBuilder sb = new StringBuilder();
		
	    for (int i=0; i<rows.length; i++) {
	        sb.append(arrangeRow(rows[i], rows.length));
	    }
	    sb.append("\r\n");
	    
	    return sb.toString();
	}
	
	
	public String setRowMarginNotTrans(String... rows) {
		StringBuilder sb = new StringBuilder();
		
	    for (int i=0; i<rows.length; i++) {
	        sb.append(arrangeRow(rows[i], rows.length));
	    }
	    
	    sb.append("\r\n");
	    
	    return sb.toString();
	}
	
	public String setNumRowMargin(String row) {
		int count = 1;
		StringBuilder sb = new StringBuilder();

	    for (int i=0; i<count; i++) {
	        sb.append(arrangeRow(String.format("%d. %s", (i + 1), LanguageService.get(row)), count));
	    }
	    
	    sb.append("\r\n");
	    
	    return sb.toString();
	}
	
	public String setNumRowMarginNotTrans(String... rows) {

		StringBuilder sb = new StringBuilder();

	    for (int i=0; i<rows.length; i++) {
	        sb.append(arrangeRow(String.format("%d. %s", (i + 1), rows[i]), rows.length));
	    }
	    
	    sb.append("\r\n");
	    
	    return sb.toString();
	}
	
	public String setNumRowMargin(String... rows) {
		
		for(int i=0; i<rows.length; i++) {
			rows[i] = LanguageService.get(rows[i]);
		}

		StringBuilder sb = new StringBuilder();

	    for (int i=0; i<rows.length; i++) {
	        sb.append(arrangeRow(String.format("%d. %s", (i + 1), rows[i]), rows.length));
	    }
	    
	    sb.append("\r\n");
	    
	    return sb.toString();
	}
	
	public String setNumRowMargin(String row, int... nums) {
		StringBuilder sb = new StringBuilder();

	    for (int i=0; i<nums.length; i++) {
	    	sb.append(arrangeRow(String.format(
	    			"%d. %d %s", 
	    			(i + 1), nums[i], LanguageService.get(row)), nums.length
	    			));
	    }
	    
	    sb.append("\r\n");
	    
	    return sb.toString();
	}
	
	public String arrangeRow(String text, int len) {
		double lineLength = 122.0;
	    int padding = (int)(lineLength / len - calcKRJPStringCount(text) - text.length())/ 2 ;
	    if(padding < 0) {
	    	padding = 0;
	    }
	    // 패딩을 추가하여 텍스트를 가운데로 정렬
	    StringBuilder sb = new StringBuilder();
        sb.append(" ".repeat(padding));
	    sb.append(text);
	    sb.append(" ".repeat(padding));
//	    sb.append(" ".repeat(padding > 0 ? padding -1 : 0));
//	    sb.append("|");
	    return sb.toString();
	}
	
	public String addMenuMarginCenter(String menu, int... nums) {
		String result = "";
		int len = nums.length;
		String str = LanguageService.get(menu);
		
		for(int i=0; i<len; i++) {
			result += String.format("%d. %d%s", i + 1, nums[i], str);
			if(i != len - 1) {
				result += " ".repeat(3);
			}
		}
		result = setRowMargin(result);
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
		double result = 0;
//		기본 폰트에 맞춰 크기 설정 하기
		for(int i=0; i<str.length(); i++) {
			char c = str.charAt(i);
			if(c >= '가' && c <= '힣') {
//				한국어
				result += 1.1;
			} else if(c >= 'あ' && c <= 'ん'
					|| c >= 'ア' && c <= 'ン') {
//				일본어
				result += 1.2;
//			} else if(c >= '一' && c <= '龻'
//					|| c >= '㐀' && c <= '䶿'
//					|| c >= '𠀀' && c <= '𪛟'
//					|| c >= '𪜀' && c <= '𫜿'
//					|| c >= '𫝀' && c <= ''
//					|| c >= '' && c <= '') {
//				한자
			}
		}
		return (int) result;
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
		result += "\r\n";
		result += "\r\n";
		result += " /###           /                                                                              \r\n"
				+ " /  ############/                                  #                                            \r\n"
				+ "/     #########                                   ###                                           \r\n"
				+ "#     /  #                                         #                                            \r\n"
				+ " ##  /  ##                                                                                      \r\n"
				+ "    /  ###          /##  ###  /###   ###  /###   ###        /###                                \r\n"
				+ "   ##   ##         / ###  ###/ #### / ###/ #### / ###      / #### /                             \r\n"
				+ "   ##   ##        /   ###  ##   ###/   ##   ###/   ##     ##  ###/                              \r\n"
				+ "   ##   ##       ##    ### ##    ##    ##    ##    ##    ####                                   \r\n"
				+ "   ##   ##       ########  ##    ##    ##    ##    ##      ###                                  \r\n"
				+ "    ##  ##       #######   ##    ##    ##    ##    ##        ###                                \r\n"
				+ "     ## #      / ##        ##    ##    ##    ##    ##          ###                              \r\n"
				+ "      ###     /  ####    / ##    ##    ##    ##    ##     /###  ##                              \r\n"
				+ "       ######/    ######/  ###   ###   ###   ###   ### / / #### /                               \r\n"
				+ "         ###       #####    ###   ###   ###   ###   ##/     ###/                                \r\n"
				+ "                                                                                                \r\n"
				+ "                                                                                                \r\n"
				+ "                                                                                                \r\n"
				+ "      #######                                    ###                                            \r\n"
				+ "    /       ###  #                                ###                                           \r\n"
				+ "   /         ## ###                                ##                  #                        \r\n"
				+ "   ##        #   #                                 ##                 ##                        \r\n"
				+ "    ###                                            ##                 ##                        \r\n"
				+ "   ## ###      ###   ### /### /###   ##   ####     ##      /###     ######## /###   ###  /###   \r\n"
				+ "    ### ###     ###   ##/ ###/ /##  / ##    ###  / ##     / ###  / ######## / ###  / ###/ #### /\r\n"
				+ "      ### ###    ##    ##  ###/ ###/  ##     ###/  ##    /   ###/     ##   /   ###/   ##   ###/ \r\n"
				+ "        ### /##  ##    ##   ##   ##   ##      ##   ##   ##    ##      ##  ##    ##    ##        \r\n"
				+ "          #/ /## ##    ##   ##   ##   ##      ##   ##   ##    ##      ##  ##    ##    ##        \r\n"
				+ "           #/ ## ##    ##   ##   ##   ##      ##   ##   ##    ##      ##  ##    ##    ##        \r\n"
				+ "            # /  ##    ##   ##   ##   ##      ##   ##   ##    ##      ##  ##    ##    ##        \r\n"
				+ "  /##        /   ##    ##   ##   ##   ##      /#   ##   ##    /#      ##  ##    ##    ##        \r\n"
				+ " /  ########/    ### / ###  ###  ###   ######/ ##  ### / ####/ ##     ##   ######     ###       \r\n"
				+ "/     #####       ##/   ###  ###  ###   #####   ##  ##/   ###   ##     ##   ####       ###      \r\n"
				+ "|                                                                                               \r\n"
				+ " \\)                                                                                             ";
		
		
		MainService.printLine(result, 220, 5);
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

	public String setWinner(int countSet, int pointSet1, int pointSet2, String p1, String p2) {
		
		String text = "";
		
		if (pointSet1 > pointSet2) {
			
			text += getSeperator();
			text += getSubTitle(String.format("%d세트의 승자는 %s입니다.\r\n", countSet, p1));
			text += getSubTitle(String.format("현재 세트 스코어는 [%d-%d] 입니다.\r\n", pointSet1, pointSet2));
			text += getSeperator();
			text += getSubTitle("다음세트를 시작합니다.");
			text += getSeperatorThin();
			text += getSubTitle("[확인]");
			text += getSeperatorThin();	
		} else {
			text += getSeperator();
			text += getSubTitle(String.format("%d세트의 승자는 %s입니다.\r\n", countSet, p2));
			text += getSubTitle(String.format("현재 세트 스코어는 [%d-%d] 입니다.\r\n", pointSet1, pointSet2));
			text += getSeperator();
			text += getSubTitle("다음세트를 시작합니다.");
			text += getSeperatorThin();
			text += getSubTitle("[확인]");
			text += getSeperatorThin();	

		}
		return text;
	}

	public String pointDisplay(int p1, int p2) {
		
		String text = "";
		text += getSeperator();
		text += getSubTitle(pointName(p1, p2), "(계속하시려면 엔터를 입력해주세요.)");
//		text += getSubTitle(p1 + "-" + p2);
		text += getSeperator();
		text += getSubTitle("[확인]");
		text += getSeperatorThin();
		
		return text;
		
	}

	private String pointName(int p1, int p2) {
			
			String[] pointNames = {"러브", "피프틴", "써티", "포티"	};
			String text;

			if (p1 == p2) {
				if (p1 < 3) {
					text = pointNames[p1] + "-올";
				} else {
					text = "듀스";
				}
			} else if (p1 > 3 || p2 > 3) {

				int diff = p1 - p2;
					
				if (diff == 1) {
					text = "애드 플레이어 1";
				} else if ( diff == -1 ) {
					text = "애드 플레이어 2";
				} else if (diff >= 2) {
					text = "게임 플레이어 1";
				} else {
					text = "게임 플레이어 2";
				}
			} else {
					text = pointNames[p1] + "-" + pointNames[p2];
			}
			return text;
	}
	
}