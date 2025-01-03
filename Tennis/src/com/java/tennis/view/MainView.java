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
	
//	public String addRowMarginMultiLine(String[][] rows) {
//		String result = "";
////		String[] lines = multiLine.split("(\r)?\n");
////		
////		for(String line : lines) {
////			result += setRowMarginNotTrans(line);
////		}
//		int[] len = new int[rows.length];
//		
////		각 열별 최대 길이 값
//		for(int i=0; i<rows[0].length; i++) {
//			for(int j=0; j<rows.length; j++) {
//				len[i] = Math.max(len[i], rows[j][i].length() + calcKRJPStringCount(rows[j][i]));
//			}
//		}
//		
//		for(int i=0; i<rows.length; i++) {
//			for(int j=0; j<rows[i].length; j++) {
//				result += rows[i][j])
//			}
//		}
//		return result;
//	}
		
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
		double width = lineLength / len; 
	    int padding = (int)(lineLength / len - calcKRJPStringCount(text) - text.length())/ 2 ;
	    if(padding < 0) {
	    	padding = 0;
	    }
	    // 패딩을 추가하여 텍스트를 가운데로 정렬
	    StringBuilder sb = new StringBuilder();
//        sb.append(" ".repeat((int) (width - padding)));
//	    if(padding >= 4) {
//	    	System.out.println(sb.append("\t"));
//	    }
        sb.append(" ".repeat(padding));
	    sb.append(text);
	    sb.append(" ".repeat(padding));
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
				result += 1.00;
			} else if(c >= 'あ' && c <= 'ん'
					|| c >= 'ア' && c <= 'ン') {
//				일본어
				result += 0.5;
			} else if(c >= 0x4E00 && c <= 0x9FFF 
					|| c >= 0x3400 && c <= 0x4DBF
					|| c >= 0x20000 && c <= 0x2A6DF
					|| c >= 0x2A700 && c <= 0x2B73F
					|| c >= 0x2B740 && c <= 0x2B81F
					|| c >= 0x2B820 && c <= 0x2CEAF 
					|| c >= 0x2CEB0 && c <= 0x2EBEF
					|| c >= 0xF900 && c <= 0xFAFF) {
//				한자
				result += 0.8;
			}
		}
		return (int) result;
	}
	
	public void pause() {
		String result = "";
		result += "\r\n";
		result += getSeperator();
		result += getSubTitle("계속하시려면 엔터를 입력해주세요.");
		result += getSeperator();
		System.out.print(result);
		scan.nextLine();	//Block
		System.out.println();
	}
	
	public void end() {
		String result = "";
		result += getSeperator();
		result += getSubTitle("게임을 종료합니다.");
		result += getSubTitle("안녕히 가십시오.");
		result += getSeperator();
		result += "\r\n";
		result += addRowMarginMultiLine("  /###           /                                                                              \r\n"
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
				+ " \\)                                                                                             ");
		
		
		MainService.printLine(result, 220, 5);
	}
	
	public void errorInput() {
		String result = "";
		result += getSeperator();
		result += getSubTitle("잘못 입력 하셨습니다.");
		result += getSubTitle("다시 입력해주세요.");
		result += getSeperator();
		System.out.print(result);
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