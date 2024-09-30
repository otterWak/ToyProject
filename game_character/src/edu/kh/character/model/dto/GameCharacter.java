package edu.kh.character.model.dto;

public class GameCharacter {

	private String name; // 캐릭터이름
	private String job; // 직업
	private int level; // 레벨
	
	public GameCharacter() {}

	public GameCharacter(String name, String job, int level) {
		super();
		this.name = name;
		this.job = job;
		this.level = level;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	
	
	@Override
	public String toString() {
		return "[ " + name + " ] 직업 : " + job + " / Level : " + level; 
		
	}

	
	
}
