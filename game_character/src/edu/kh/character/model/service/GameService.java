package edu.kh.character.model.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import edu.kh.character.model.dto.GameCharacter;

public class GameService {

	Scanner sc = new Scanner(System.in);
	List<GameCharacter> characters = new ArrayList<GameCharacter>();
	Map<Integer, String> jobs = new HashMap<Integer, String>();
	
	public void jobsCategory() {
		jobs.put(1, "전사");
		jobs.put(2, "궁수");
		jobs.put(3, "도적");
		jobs.put(4, "마법사");
		jobs.put(5, "해적");
	}
			
	
	public void initializin() {
		characters.add(new GameCharacter("타락파워전사", jobs.get(1), 200));
		characters.add(new GameCharacter("앙잉웅", jobs.get(3), 181));
		characters.add(new GameCharacter("싸비", jobs.get(4), 112));
		characters.add(new GameCharacter("페이커", jobs.get(2), 290));
		
	}
	
	public void menuBar() {
		int num = -1;
		
		while(num != 0) {
			System.out.println("==== 메뉴 선택 창 ====");
			System.out.println("1. 캐릭터 조회");
			System.out.println("2. 캐릭터 생성");
			System.out.println("3. 캐릭터 정보 수정");
			System.out.println("4. 캐릭터 삭제");
			System.out.println("0. 시스템 종료");
			System.out.println("====================");
			System.out.print("메뉴 선택 : ");
			try {
				num = sc.nextInt();
				
				switch(num) {
				case 1: cSearch(); break;
				case 2: cCreate(); break;
				case 3: cFix(); break;
				case 4: cDel(); break;
				case 0: System.out.println("<< 프로그램 종료 >>"); break;
				default: System.out.println("0~5사이 숫자만 입력");
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}



	/**
	 * 1. 캐릭터 조회
	 */
	public void cSearch() throws Exception{
		System.out.println("<< 캐릭터 목록 >>");
		for(int i = 0 ; i < characters.size(); i++) {
			System.out.println(characters.get(i).toString());
		}
		System.out.println();
	}

	
	/**
	 * 2. 캐릭터 생성
	 */
	public void cCreate() throws Exception{
		System.out.println("<< 캐릭터 생성 >>");
		System.out.print("캐릭터 이름 : ");
		String name = sc.next();
		
		boolean flag = false;
		
		for(int i = 0; i< characters.size(); i++) {
			if(name.equals(characters.get(i).getName())) {
				System.out.println("이미 존재하는 닉네임입니다");
				System.out.println();
				flag = true;
			}
		}
		
		if(flag) return;
		
		System.out.println("< 직업 선택 >");
		for(Map.Entry<Integer, String> entry : jobs.entrySet()) {
			System.out.println(entry.getKey() + ". " + entry.getValue());
		}
		System.out.println("----------------------");
		System.out.print("직업 선택(번호 입력) : ");
		int job = sc.nextInt();
		
		characters.add(new GameCharacter(name, jobs.get(job), 1));
		System.out.println("캐릭터 [ " + name + " ]가 생성되었습니다");
		System.out.println();
		
	}

	
	/**
	 * 3. 캐릭터 정보 수정
	 */
	public void cFix() throws Exception{
		System.out.println("<< 캐릭터 닉네임 수정 >>");
		System.out.print("변경할 캐릭터 입력 : ");
		String originName = sc.next();
		
		boolean flag = false;
		String newName;
		
		for(GameCharacter chr : characters) {
			if(chr.getName().equals(originName)) {
				flag = true;
				break;
			}
		}
		
		if(flag) {
			System.out.print("새로운 닉네임 입력 : ");
			newName = sc.next();
			
			boolean exist = false;
			
			for(int i = 0; i< characters.size(); i++) {
				if(newName.equals(characters.get(i).getName())) {
					exist = true;
					break;
				}
			}
			
			if(!exist) {
				for(int i = 0; i < characters.size(); i++) {
					if(characters.get(i).getName().equals(originName)) {
						characters.get(i).setName(newName);
						System.out.println("성공적으로 변경되었습니다");
						System.out.println();
						break;
					}
				}
			}else {
				System.out.println("이미 존재하는 닉네임입니다");
				System.out.println();
			}
			
			
			
			
		}else {
			System.out.println("해당하는 닉네임의 캐릭터가 없습니다");
			System.out.println();
		}
	}
	
	
	
	/**
	 * 4. 캐릭터 삭제
	 */
	public void cDel() throws Exception{
		System.out.println("<< 캐릭터 삭제 >>");
		System.out.print("삭제할 캐릭터 입력 : ");
		String originName = sc.next();
		
		boolean flag = false;
		
		for(GameCharacter chr : characters) {
			if(chr.getName().equals(originName)) {
				characters.remove(chr);
				flag = true;
				break;
			}
		}
		
		if(flag) {
			System.out.println("캐릭터 [ " + originName + " ]가 삭제되었습니다");
			System.out.println();
		}else {
			System.out.println("해당하는 닉네임의 캐릭터가 없습니다");
			System.out.println();
		}
	}
}
