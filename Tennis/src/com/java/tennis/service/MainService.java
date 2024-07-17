package com.java.tennis.service;

public class MainService {
	public static void printLine(String txt) {
		try {
			for(String line : txt.split("\r?\n")) {
				System.out.println(line);
				Thread.sleep(100);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void printLine(String txt, int millis) {
		try {
			for(String line : txt.split("\r?\n")) {
				System.out.println(line);
				Thread.sleep(millis);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
