package tetris;

public class Selection {

	private int select;
	
	final int START = 1;
	final int SETTING = 2;
	final int LEADERBOARD = 3;
	
	Gaming game;
	Setting set;
	Leader leader;
	
	public void setSelection(int select) {
		switch(select) {
		case START:
			System.out.println("Start the game");
			game.start();
			break;
			
		case SETTING:
			System.out.println("Setting");
			set.setter();
			break;
			
		case LEADERBOARD:
			System.out.println("Leaderboard");
			leader.leader();
			break;
		}
	}
}
