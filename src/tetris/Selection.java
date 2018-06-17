package tetris;
import d0602.InsertData;
public class Selection {

	private int select;
	
	final int CSTART = 1;
	final int LEADERBOARD = 3;
	final int DSTART = 2;
	
	private Gaming game = new Gaming();
	private InsertData leader = new InsertData();
	private DGaming g = new DGaming();
	
	public void setSelection(int select) {
		switch(select) {
		case CSTART:
			game.start();
			break;
			
		case DSTART:
			g.start();
			break;
			
			
		case LEADERBOARD:
			leader.fxxk();
			break;
		}
	}
}
