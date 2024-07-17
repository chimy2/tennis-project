package com.java.tennis.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

import com.java.tennis.model.RecordDTO;

public class RecordDAO {
	
	private final String PATH = ".\\Tennis\\resource\\"; //변경되면 안됌
	
	// 기록하는 메서드----------------------------------------------------------------
	
		public boolean recordAdd(RecordDTO dto) {

			// 간단한 점수 저장------------------------------------------
			// 일련번호, 날짜, 이름, 캐릭터 번호, 스코어1(나), 스코어2(컴퓨터)
			// 1,2024-04-03,현영석,3,2,0


			try {
				
				BufferedWriter writer = new BufferedWriter(new FileWriter(PATH+"record.txt",true)); // append모드로
				
				String line = String.format("%s,%s,%s,%s,%s,%s\n"
											,dto.getNo()// 일련번호
											,dto.getDate() // 날짜
//											,dto.getCharacter().getName() //유저 이름
//											,dto.getCharacter().getNo() //캐릭터번호
											,dto.getScoreme() //스코어 1
											,dto.getSocrecumputer());// 스코어 2
				
				
				writer.write(line); //점수-간단한 추가
				writer.close(); // 파일 저장
				
				
				
			} catch (Exception e) {
				System.out.println("RecordDAO.record");
				e.printStackTrace();
			}
			
			// 상세한 점수 저장------------------------------------------
			// 일련번호, 세트번호, 게임번호, 스코어1, 스코어2
			// 1,1,1,4,0 
			
			try {
				
				BufferedWriter writerSpec = new BufferedWriter(new FileWriter(PATH+"game.txt",true)); // append모드로
				
				String lineSpec = String.format("%s,%s,%s,%s,%s\n"
											,dto.getNo()// 일련번호
//											,dto.getTennis().getSet() // 세트번호
//											,dto.getTennis().getGamePoint() //게임번호
											,dto.getTennis().getPoint() //스코어 1
											,dto.getTennis().getPoint());// 스코어 2
				
				
				writerSpec.write(lineSpec); //점수-상세한 추가
				writerSpec.close(); // 파일 저장
				
				
			} catch (Exception e) {
				System.out.println("RecordDAO.record");
				e.printStackTrace();
			}
			
			System.out.println("\n 우승자 정보를 넣었습니다.");
			
			return true; // 간단한 정보 저장되면 true
		}


		
	// 정보 불러오는 메서드----------------------------------------------------------------
	
		// 간단한 정보 불러오기
		public void get() {
			
			try {
				BufferedReader reader = new BufferedReader(new FileReader(PATH+"record.txt"));
				
				String line = null;
				int count = 0;
				
				while((line = reader.readLine())!=null) {
					
					System.out.println(line);
//					System.out.println();
					count++;
					
					if(count==10) { // 10줄만 보이고 싶어
						break;
					}
					
				}
			} catch (Exception e) {
				System.out.println("RecordDAO.get");
				e.printStackTrace();
			}
			
		}
	
		// 상세한 정보 불러오기
		public void getSpec(String num) {
			
			try {
				BufferedReader reader = new BufferedReader(new FileReader(PATH+"game.txt"));
				
				String line = null;
				
				
				while ((line = reader.readLine()) != null) {
					if (line.startsWith(num)) {
						System.out.println(line);
//						System.out.println();
					}
				}
			} catch (Exception e) {
				System.out.println("RecordDAO.getSpec");
				e.printStackTrace();
			}
			
		}
		
		
		// 검색 기능 : 이름 검색하면 불러올 수 있는 기능
		public void recordSearch(String name) {

			// 간단한 점수 저장------------------------------------------
			// 일련번호, 날짜, 이름, 캐릭터 번호, 스코어1(나), 스코어2(컴퓨터)
			// 1,2024-04-03,현영석,3,2,0


			try {
				BufferedReader reader = new BufferedReader(new FileReader(PATH+"game.txt"));
				
				String line = null;
				
			
				while ((line = reader.readLine()) != null) {
					String[] temp = line.split(",");
					if (temp[1].equals(name)) {
						System.out.println(line);
						System.out.println();
					}
				}
			} catch (Exception e) {
				System.out.println("RecordDAO.recordSearch");
				e.printStackTrace();
			}
		}
		
		
		
		
		
		
		
		
		
		
		

}
