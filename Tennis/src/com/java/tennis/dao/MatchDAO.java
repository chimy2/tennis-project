package com.java.tennis.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.java.tennis.model.MatchDTO;
import com.java.tennis.model.TennisDTO;

public class MatchDAO {
	
	final String PATH = ".\\resource\\record.txt";

	public void add(MatchDTO dto) {
		
		
		try {

			BufferedWriter writer = new BufferedWriter(new FileWriter(PATH, true));
			
			String line = String.format("%d,%tF,%s,%d,%d,%d\r\n"
					
								, dto.getNo()
								, dto.getDate()
								, dto.getName()
								, dto.getCharacter()
								, dto.getMePointSet()
								, dto.getCpuPointSet());

								writer.write(line);
								writer.close();
		
		} catch (Exception e) {
			System.out.println("MatchDAO.add");
			e.printStackTrace();
		}
	}
	
	public MatchDTO get() {
		try {
			
			
			BufferedReader reader = new BufferedReader(new FileReader(PATH));
			
			String line = null;
			
			while ((line = reader.readLine())!= null) {
				
				String[] temp = line.split(",");
				
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				Date date = sdf.parse(temp[1]);
				Calendar Calendar = java.util.Calendar.getInstance();
				Calendar.setTime(date);

				MatchDTO dto = new MatchDTO();
				dto.setNo(Integer.parseInt(temp[0]));
				dto.setDate(Calendar);
				dto.setName(temp[2]);
				dto.setCharacter(Integer.parseInt(temp[3]));
				dto.setMePointSet(Integer.parseInt(temp[4]));
				dto.setCpuPointSet(Integer.parseInt(temp[5]));
				
				return dto;
				
			}
			
		} catch (Exception e) {
			System.out.println("MatchDAO.get");
			e.printStackTrace();
		}
		return null;
	}
	
}
