package tetris;
import java.awt.*;

import javax.swing.JFrame;

public class GamingFrame{
	private int i,j;
	private Color[][] well;

	public void init() {
		well = new Color[12][24];
		for (int i = 0; i < 12; i++) {
			for (int j = 0; j < 23; j++) {
				if (i == 0 || i == 11 || j == 22) {
					well[i][j] = Color.GRAY;
				} else {
					well[i][j] = Color.BLACK;
				}
			}
		}
		newPiece();
	}
	public void newPiece() {

	}
	}
