package tetris;

public class Main {

	public static void main(String[] args) {
		StartFrame game = new StartFrame();
		game.setTitle("Tetris");
		game.setSize(300, 500);
		game.setVisible(true);
		game.setDefaultCloseOperation(game.EXIT_ON_CLOSE);
	}

}
