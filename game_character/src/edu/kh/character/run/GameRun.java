package edu.kh.character.run;

import edu.kh.character.model.service.GameService;

public class GameRun {

	public static void main(String[] args) {
		GameService service = new GameService();
		
		service.jobsCategory();
		service.initializin();
		service.menuBar();
	}

}
