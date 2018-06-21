package tetris;

import javax.swing.JFrame;

public class Main {
	

	public static void main(String[] args) {
		StartFrame game = new StartFrame();
		game.setTitle("Tetris");
		game.setSize(300, 500);
		game.setVisible(true);
		game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

}
