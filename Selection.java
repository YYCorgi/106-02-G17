package tetris;

public class Selection {

	private int select;
	
	final int START = 1;
	final int SETTING = 2;
	final int LEADERBOARD = 3;
	
	public void setSelection(int select) {
		switch(select) {
		case 1:
			System.out.println("Start the game");
			//gaming(); 開始遊戲
			break;
			
		case 2:
			System.out.println("Setting");
			//setting(); 進入設定
			break;
			
		case 3:
			System.out.println("Leaderboard");
			//leaderboard(); 進入排行榜
			break;
		}
	}
}
