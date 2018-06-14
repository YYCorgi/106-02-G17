package tetris;
import d0602.InsertData;
public class Selection {

	private int select;
	
	final int START = 1;
	final int LEADERBOARD = 2;
	
	private Gaming game = new Gaming();
	private InsertData leader = new InsertData();
	
	
	public void setSelection(int select) {
		switch(select) {
		case START:
			System.out.println("Start the game");
			game.start();
			break;
			
		case LEADERBOARD:
			System.out.println("Leaderboard");
			leader.fxxk();
			break;
		}
	}
}
