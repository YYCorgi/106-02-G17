package tetris;
import java.awt.*;
import java.awt.Color;
import java.awt.Graphics;

public class GamingFrame extends Gaming {
	private int i,j;
	private Color[][] well;
	
	public GamingFrame() {
		super();
		//init();
	}
	public void init() {
		  well = new Color[10][20];
		  for (int i = 0; i < 11; i++) {
		   for (int j = 0; j < 21; j++) {
		    if (i == 0 || i == 10 || j == 20) {
		     well[i][j] = Color.GRAY;
		    } else {
		     well[i][j] = Color.BLACK;
		    }
		   }
		  }
		  //newPiece();
		 }
}
