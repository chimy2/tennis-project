package com.java.tennis;


import java.util.ArrayList;
import java.util.Scanner;

import com.java.tennis.service.RecordService;
import com.java.tennis.view.RecordView;

public class temp {

	public static void main(String[] args) {
		RecordService service =  new RecordService();
		RecordView view =  new RecordView();
		ArrayList<String> list = new ArrayList<String>();
		Scanner scan = new Scanner(System.in);
		
//		view.mainMenu();
//		int num = scan.nextInt();
		
		
		service.getSpec();
		
//		if(num ==1) {
//			service.get();
//		}else if(num ==2) {
//			service.getSpec(); // 한번은 보이고
//			//정렬하시겠습니까? 물어보기
//			
//		}else if(num ==3) {
//			service.getTotal(); // 전체 최신기록
//			service.getSort();
//			
//			
//			
//		}else {
//			
//		}
		
		
		
	}
	
	
	
	
}
