package com.java.tennis.service;

import java.util.Arrays;

public class MainService {
	public static void printLines(String txt, int sumLineCount) {
		try {
			String[] lines = txt.split("\r?\n");
			for(int i=0; i<Math.ceil((double) lines.length / sumLineCount); i++) {
				StringBuilder sb = new StringBuilder();
				for(int j=0; i * sumLineCount + j < lines.length && j<sumLineCount; j++) {
					sb.append(lines[i * sumLineCount + j]);
					sb.append("\r\n");
				}
				System.out.print(sb.toString());
				Thread.sleep(1000);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void printLine(String txt) {
		try {
			String[] lines = txt.split("\r?\n");
			
			for(int i=0; i<lines.length; i++) {
				if(i == lines.length - 1) {
					System.out.print(lines[i]);
				} else {
					System.out.println(lines[i]);
				}
				Thread.sleep(100);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void printLine(String txt, int millis) {
		try {
			String[] lines = txt.split("\r?\n");
			
			for(int i=0; i<lines.length; i++) {
				if(i == lines.length - 1) {
					System.out.print(lines[i]);
				} else {
					System.out.println(lines[i]);
				}
				Thread.sleep(millis);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void printLine(String txt, int millis, int var) {
		try {
			String[] lines = txt.split("\r?\n");
			
			for(int i=0; i<lines.length; i++) {
				if(i == lines.length - 1) {
					System.out.print(lines[i]);
				} else {
					System.out.println(lines[i]);
				}
				if (millis - (var * (i + 1)) > 0) {
					Thread.sleep(millis - (var * (i + 1)));
				} else {
					Thread.sleep(10);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
}
