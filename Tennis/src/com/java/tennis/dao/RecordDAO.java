package com.java.tennis.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
import java.util.Stack;

import com.java.tennis.model.RecordDTO;
import com.java.tennis.view.RecordView;

public class RecordDAO {
	private RecordView view;
	private Scanner scan;
//	private RecordDTO dto;

	//
	private Stack<String> historyStack;
	private String currentPage;

	public RecordDAO() {
		this.view = new RecordView();
		this.scan = new Scanner(System.in);
//		this.dto = new RecordDTO();
	}

	private final String PATH = ".\\resource\\"; // 변경되면 안됌

	// 기록하는 메서드----------------------------------------------------------------

	public boolean recordAdd(RecordDTO dto) {

		// 간단한 점수 저장------------------------------------------
		// 일련번호, 날짜, 이름, 캐릭터 번호, 스코어1(나), 스코어2(컴퓨터)
		// 1,2024-04-03,현영석,3,2,0

		try {

			BufferedWriter writer = new BufferedWriter(new FileWriter(PATH + "record.txt", true)); // append모드로

			String line = String.format("%s,%s,%s,%s,%s,%s\n", dto.getNo()// 일련번호
					, dto.getDate() // 날짜
//												,dto.getCharacter().getName() //유저 이름
//												,dto.getCharacter().getNo() //캐릭터번호
					, dto.getScoreme() // 스코어 1
					, dto.getSocrecumputer());// 스코어 2

			writer.write(line); // 점수-간단한 추가
			writer.close(); // 파일 저장

		} catch (Exception e) {
			System.out.println("RecordDAO.record");
			e.printStackTrace();
		}

		// 상세한 점수 저장------------------------------------------
		// 일련번호, 세트번호, 게임번호, 스코어1, 스코어2
		// 1,1,1,4,0

		try {

			BufferedWriter writerSpec = new BufferedWriter(new FileWriter(PATH + "game.txt", true)); // append모드로

			String lineSpec = "";
//							String.format("%s,%s,%s,%s,%s\n"
//												,dto.getNo()// 일련번호
////												,dto.getTennis().getSet() // 세트번호
////												,dto.getTennis().getGamePoint() //게임번호
//												,dto.getTennis().getPoint() //스코어 1
//												,dto.getTennis().getPoint());// 스코어 2

			writerSpec.write(lineSpec); // 점수-상세한 추가
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

		String line = null;
		int count = 0;
		String[] temp = null;
		int num = 1;

		try {
			BufferedReader reader = new BufferedReader(new FileReader(PATH + "record.txt"));

			// 1,2024-04-03,현영석,3,2,0
			// 번호 날짜 닉네임 캐릭터 스코어 점수
			//
			while ((line = reader.readLine()) != null) {

//						System.out.println(line);

				temp = line.split(",");

				String character = "";
//						character = charname(temp[3]);
				if (temp[3].equals("1")) {
					character = "호랑이";
				} else if (temp[3].equals("2")) {
					character = "병아리";
				} else if (temp[3].equals("3")) {
					character = "강아지";
				} else {
					character = "고양이";
				}

				String score = "";
				score = temp[4] + " : " + temp[5];

				String list = String.format("\t%2s\t\t%s\t%s\t\t%s\t\t%s", temp[0], temp[1], temp[2], character, score);

				System.out.println(list);
//						System.out.println("-----------------------------------------------------------------------------------------");

//						System.out.println();
				count++;
//						num++;
				if (count == 10) { // 10줄만 보이고 싶어
					break;
				}

			}

			view.dividingLine(); // 구분선
			System.out.println();

		} catch (Exception e) {
			System.out.println("RecordDAO.get");
			e.printStackTrace();
		}

	}

	// 상세한 정보 불러오기
	public void getSpec(String num) {
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(PATH + "game.txt"));

			String line = null;

			while ((line = reader.readLine()) != null) {

				if (line.startsWith(num)) {
//							System.out.println(line);

					String[] temp = line.split(",");

					// 1,1,1,4,0
					// 번호 세트 게임 스코어점수
					//

					String score = "";
					score = temp[3] + " : " + temp[4];

					String win = "";
					if ((temp[3].compareTo(temp[4])) > 0) {
						win = "승";
					} else {
						win = "패";
					}

					String list = String.format("\t%s세트\t\t%s게임\t\t%s\t\t %s", temp[1], temp[2], score, win);

					System.out.println(list);
//							System.out.println("-----------------------------------------------------------------------------------------");

//							System.out.println();

				}

			}
		} catch (Exception e) {
			System.out.println("입입력 오류");
			e.printStackTrace();
		}

	}

	// 검색 기능 : 이름 검색하면 불러올 수 있는 기능
	public String recordSearch(String name) {

		// 간단한 점수 저장------------------------------------------
		// 일련번호, 날짜, 이름, 캐릭터 번호, 스코어1(나), 스코어2(컴퓨터)
		// 1,2024-04-03,현영석,3,2,0
		String result = "";
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(PATH + "record.txt"));
			
			String line = null;

			while ((line = reader.readLine()) != null) {
				String[] temp = line.split(",");

				if (temp[2].equals(name)) {

					String character = "";
					if (temp[3].equals("1")) {
						character = "호랑이";
					} else if (temp[3].equals("2")) {
						character = "병아리";
					} else if (temp[3].equals("3")) {
						character = "강아지";
					} else {
						character = "고양이";
					}
					
					String score = "";
					score = temp[4] + " : " + temp[5];

					result += String.format("\t%2s\t\t%s\t%s\t\t%s\t\t%s", temp[0], temp[1], temp[2], character,
							score);

//								System.out.println("-----------------------------------------------------------------------------------------");

//								System.out.println(line);
//								System.out.println();
				}
			}
		} catch (Exception e) {
			System.out.println("RecordDAO.recordSearch");
			e.printStackTrace();
		}
		return result;
	}

	// 검색 기능 : 이름 검색하면 불러올 수 있는 기능 <><><><><><><><><><><><><>
	public void recordSearch22(String name) {

		// 간단한 점수 저장------------------------------------------
		// 일련번호, 날짜, 이름, 캐릭터 번호, 스코어1(나), 스코어2(컴퓨터)
		// 1,2024-04-03,현영석,3,2,0

//		System.out.print("아이디 입력 : ");
//		String id = scan.nextLine();

		try {

			BufferedReader reader = new BufferedReader(new FileReader(PATH + "record.txt"));
			String line = null;

			while ((line = reader.readLine()) != null) {
				String[] temp = line.split(",");

				if (temp[2].equals(name)) {

					String character = "";
//							character =charname(temp[3]);

					if (temp[3].equals("1")) {
						character = "호랑이";
					} else if (temp[3].equals("2")) {
						character = "병아리";
					} else if (temp[3].equals("3")) {
						character = "강아지";
					} else {
						character = "고양이";
					}

					String score = "";
					score = temp[4] + " : " + temp[5];

					String list = String.format("\t%2s\t\t%s\t%s\t\t%s\t\t%s", temp[0], temp[1], temp[2], character,
							score);

					System.out.println(list);

				} else if (!temp[2].equals(name)) {

					String line2 = null;

					System.out.println("ddddd");

					System.out.print("아이디 입력 : ");
					String id = scan.nextLine();

					while ((line2 = reader.readLine()) != null) {
						String[] temp2 = line.split(",");

						if (temp2[2].equals(id)) {

							String character = "";
//									character =charname(temp[3]);

							if (temp2[3].equals("1")) {
								character = "호랑이";
							} else if (temp2[3].equals("2")) {
								character = "병아리";
							} else if (temp2[3].equals("3")) {
								character = "강아지";
							} else {
								character = "고양이";
							}

							String score = "";
							score = temp2[4] + " : " + temp2[5];

							String list = String.format("\t%2s\t\t%s\t%s\t\t%s\t\t%s", temp2[0], temp2[1], temp2[2],
									character, score);

							System.out.println(list);
						}
					}
				}
			}
		} catch (Exception e) {
			System.out.println("입력이 올바르지 않습니다.");
		}
	}

	public String gameId() {

//		System.out.print("아이디 입력 : ");
		String result = null;

		try {
			BufferedReader reader = new BufferedReader(new FileReader(PATH + "record.txt"));
			String line = null;


			System.out.print("아이디 입력 : ");
			String id = scan.nextLine();

			while ((line = reader.readLine()) != null) {
				String[] temp = line.split(",");
				
				if (temp[2].equals(id)) {

					return id;

				} else {
//					System.out.println("입력값이 올바르지 않습니다.");
				}

			}
		} catch (Exception e) {
			System.out.println("RecordDAO.recordSearch");
			e.printStackTrace();
		}
		return result;
	}

	public String gameNum() {

		System.out.print("번호 입력 : ");
		String num = scan.nextLine();

		return num;

	}

	public void gameSearch(String identification) {

		// 아이디를 입력받아 우승정보를 검색 후 출력하시오.
		try {

			BufferedReader recordreader = new BufferedReader(new FileReader(PATH + "record.txt"));
			BufferedReader gamereader = new BufferedReader(new FileReader(PATH + "game.txt"));

			String line = null;
			String num = "";

			String id = identification;

			while ((line = recordreader.readLine()) != null) {

				String[] temp = line.split(",");

				if (temp[2].equals(id)) {
//								System.out.println(line);

					num = temp[0];
					break;
					// 1,1,1,4,0
					// 번호 세트 게임 스코어점수
					//
				}
			}

			if (!num.equals("")) {

				while ((line = gamereader.readLine()) != null) {

					String[] score = line.split(",");
					String win = "";

					if (num.equals(score[0])) {

						String total = score[3] + " : " + score[4];

						if ((score[3].compareTo(score[4])) > 0) {
							win = "승";
						} else {
							win = "패";
						}

						String list = String.format("\t%s세트\t\t%s게임\t\t%s\t\t %s", score[1], score[2], total, win);

						System.out.println(list);
//								System.out.println("-----------------------------------------------------------------------------------------");

//								System.out.println();
					}
				}

			}
			recordreader.close();
			gamereader.close();

		} catch (Exception e) {
			System.out.println("Q122_grades.main");
			e.printStackTrace();

		}

	}

	public void getTotal() {

		String line = null;

		String[] temp = null;
		int num = 1;

		try {
			BufferedReader reader = new BufferedReader(new FileReader(PATH + "record.txt"));

			// 1,2024-04-03,현영석,3,2,0
			// 번호 날짜 닉네임 캐릭터 스코어 점수
			//
			while ((line = reader.readLine()) != null) {

//						System.out.println(line);

				temp = line.split(",");

				String character = "";
//						character = charname(temp[3]);
				if (temp[3].equals("1")) {
					character = "호랑이";
				} else if (temp[3].equals("2")) {
					character = "병아리";
				} else if (temp[3].equals("3")) {
					character = "강아지";
				} else {
					character = "고양이";
				}

				String score = "";
				score = temp[4] + " : " + temp[5];

				String list = String.format("\t%2s\t\t%s\t%s\t\t%s\t\t%s", num, temp[1], temp[2], character, score);

				System.out.println(list);
//						System.out.println("-----------------------------------------------------------------------------------------");

//						System.out.println();

				num++;

			}

			view.dividingLine(); // 구분선
			System.out.println();

		} catch (Exception e) {
			System.out.println("RecordDAO.get");
			e.printStackTrace();
		}

	}

	public void sort(int number) {
		String line = null;
		String lineTemp = null;
		String[] temp = null;
		int num = 1;

		try {
			// 일련번호, 날짜, 이름, 캐릭터 번호, 스코어1(나), 스코어2(컴퓨터)
			// 1,2024-04-03,현영석,3,2,0
			ArrayList<RecordDTO> list = new ArrayList<RecordDTO>();
			BufferedReader reader = new BufferedReader(new FileReader(PATH + "record.txt"));
			while ((line = reader.readLine()) != null) {

				temp = line.split(",");
				temp[1] = temp[1].replace("-", "");
				RecordDTO dto = new RecordDTO();
				dto.setNo(temp[0]); // 일련번호
				dto.setDate(temp[1]); // 날짜
				dto.setName(temp[2]); // 이름
				dto.setCharacterno(temp[3]); // 캐릭터 > 번호를 이름으로 변경하는 메서드 만들어야 함
				dto.setScoreme(temp[4]); // 내 점수
				dto.setSocrecumputer(temp[5]); // 컴퓨터 점수

				list.add(dto);

//					

			}

			stack(list);

			int i = 1;
			for (RecordDTO record : list) {

				String dump = record.getDate();
				dump = dump.substring(0, 4) + "-" + dump.substring(4, 6) + "-" + dump.substring(6);

				String character = "";
				if (record.getCharacterno().equals("1")) {
					character = "호랑이";
				} else if (record.getCharacterno().equals("2")) {
					character = "병아리";
				} else if (record.getCharacterno().equals("3")) {
					character = "강아지";
				} else {
					character = "고양이";
				}

				String tempRecord = "";
				tempRecord = String.format("%d\t%s\t%s\t%s\t%s : %S", i, dump, record.getName(), character,
						record.getScoreme(), record.getSocrecumputer());
				System.out.println(tempRecord);

				i++;
			}

			reader.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	public void stack(ArrayList<RecordDTO> list) {
		view.sortMenu();
		int sort = scan.nextInt();

		if (sort == 1) {
			list.sort(Comparator.comparing(RecordDTO::getDate)); // 정렬(오름차순)

		} else {
			list.sort(Comparator.comparing(RecordDTO::getDate).reversed()); // 정렬(내림차순)
		}
	}

	public void check(String num) {
		
		try {
			
			BufferedReader reader = new BufferedReader(new FileReader(PATH + "record.txt"));
			String line = null;

			while ((line = reader.readLine()) != null) {
				String[] temp = line.split(",");

				if (temp[2].equals(num)) {

					

				} else {
					
				}

			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}

//	public String charname(String charno) {
//		
//		String character= "";
//		if(charno.equals("1")) {
//			character = "호랑이";
//		} else if(charno.equals("2")) {
//			character = "병아리";
//		} else if(charno.equals("3")) {
//			character = "강아지";
//		} else {
//			character = "고양이";
//		}
//		
//		
//		
//		return character;
//	}

//	public void date(RecordDTO dto) {
//		list.sort(Comparator.comparing(RecordDTO::getDate)); // 정렬
//	}
//
//	public void nameNick(RecordDTO dto) {
//		list.sort(Comparator.comparing(RecordDTO::getName));
//	}
//	
//	public void nameChar(RecordDTO dto) {
//		list.sort(Comparator.comparing(RecordDTO::getCharactername)); // 정렬
//	}
