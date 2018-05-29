package tetris;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

public class Gaming implements KeyListener{

	final int MAXX = 20;
	final int MAXY = 10;
	int x = 0,y;
	int hold = 0;
	boolean gap;
	int numClears = 0;
	int check = 1;
	
	private Color[] tetraminoColors = {Color.cyan, Color.blue, Color.orange, Color.yellow, Color.green, Color.pink, Color.red};
	
	
	private Point pieceOrigin;
	private int currentPiece;
	private int rotation;
	private ArrayList<Integer> nextPieces = new ArrayList<Integer>();
	private long score;
	private Color[][] well;

	
	private final Point[][][] Tetraminos = {
			// I
			{
				{ new Point(0, 1), new Point(1, 1), new Point(2, 1), new Point(3, 1) },
				{ new Point(1, 0), new Point(1, 1), new Point(1, 2), new Point(1, 3) },
				{ new Point(0, 1), new Point(1, 1), new Point(2, 1), new Point(3, 1) },
				{ new Point(1, 0), new Point(1, 1), new Point(1, 2), new Point(1, 3) }
			},
			
			// J
			{
				{ new Point(0, 1), new Point(1, 1), new Point(2, 1), new Point(2, 0) },
				{ new Point(1, 0), new Point(1, 1), new Point(1, 2), new Point(2, 2) },
				{ new Point(0, 1), new Point(1, 1), new Point(2, 1), new Point(0, 2) },
				{ new Point(1, 0), new Point(1, 1), new Point(1, 2), new Point(0, 0) }
			},
			
			// L
			{
				{ new Point(0, 1), new Point(1, 1), new Point(2, 1), new Point(2, 2) },
				{ new Point(1, 0), new Point(1, 1), new Point(1, 2), new Point(0, 2) },
				{ new Point(0, 1), new Point(1, 1), new Point(2, 1), new Point(0, 0) },
				{ new Point(1, 0), new Point(1, 1), new Point(1, 2), new Point(2, 0) }
			},
			
			// O
			{
				{ new Point(0, 0), new Point(0, 1), new Point(1, 0), new Point(1, 1) },
				{ new Point(0, 0), new Point(0, 1), new Point(1, 0), new Point(1, 1) },
				{ new Point(0, 0), new Point(0, 1), new Point(1, 0), new Point(1, 1) },
				{ new Point(0, 0), new Point(0, 1), new Point(1, 0), new Point(1, 1) }
			},
			
			// S
			{
				{ new Point(1, 0), new Point(2, 0), new Point(0, 1), new Point(1, 1) },
				{ new Point(0, 0), new Point(0, 1), new Point(1, 1), new Point(1, 2) },
				{ new Point(1, 0), new Point(2, 0), new Point(0, 1), new Point(1, 1) },
				{ new Point(0, 0), new Point(0, 1), new Point(1, 1), new Point(1, 2) }
			},
			
			// T
			{
				{ new Point(1, 0), new Point(0, 1), new Point(1, 1), new Point(2, 1) },
				{ new Point(1, 0), new Point(0, 1), new Point(1, 1), new Point(1, 2) },
				{ new Point(0, 1), new Point(1, 1), new Point(2, 1), new Point(1, 2) },
				{ new Point(1, 0), new Point(1, 1), new Point(2, 1), new Point(1, 2) }
			},
			
			// Z 
			{
				{ new Point(0, 0), new Point(1, 0), new Point(1, 1), new Point(2, 1) },
				{ new Point(1, 0), new Point(0, 1), new Point(1, 1), new Point(0, 2) },
				{ new Point(0, 0), new Point(1, 0), new Point(1, 1), new Point(2, 1) },
				{ new Point(1, 0), new Point(0, 1), new Point(1, 1), new Point(0, 2) }
			}
	};
	
	public void setColor(int i) {
		switch(i) {
		case 1:
			break;
			
		case 2:
			Color[] tetraminoColors = {};
			break;
		}
	}
	

	public void setMode(int i) {
		// TODO Auto-generated method stub
		
	}

	public void start() {
		System.out.println("Game Time");
		JFrame frame = new JFrame("Game Time");
		frame.setSize(200, 400);
		frame.setVisible(true);
		frame.addKeyListener(this);
	}
	
	public void deleteRow(int row) {
		for (int j = row-1; j > 0; j--) {
			for (int i = 1; i < 11; i++) {
				//well[i][j+1] = well[i][j];
			}
		}
	}
	
	public void clearRows() {	
		for (int j = 21; j > 0; j--) {
			gap = false;
			for (int i = 1; i < 11; i++) {
				//if (well[i][j] == Color.BLACK) {
					//gap = true;
				//	break;
				//}
			}
			if (!gap) {
				deleteRow(j);
				j += 1;
				numClears += 1;
			}
		}
		
		switch (numClears) {
		case 1:
			score += 100;
			break;
		case 2:
			score += 300;
			break;
		case 3:
			score += 500;
			break;
		case 4:
			score += 800;
			break;
		}
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
        switch(e.getKeyCode())  {  
            case KeyEvent.VK_UP: 
            	System.out.println("Shape turn");
            	break;  
            case KeyEvent.VK_DOWN:   
            	System.out.println("Shape go down");
            	x++;
            	if(x >= MAXX) {
            		System.out.println("Hit Max X");
            	}
                break;  
            case KeyEvent.VK_LEFT:  
            	System.out.println("Shape go left");
            	y++;
            	if(y >= MAXY) {
            		y = MAXY;
            		System.out.println("Hit Max Y");
            	}
                break;  
            case KeyEvent.VK_RIGHT:  
            	System.out.println("Shape go right");
            	y--;
            	if(y <= 0) {
            		y = 0;
            		System.out.println("Hit min y");
            	}
                break;  
            case KeyEvent.VK_SHIFT:
            	System.out.println("Shape hold");
            	hold = 1;
            	break;
            case KeyEvent.VK_SPACE:
            	do {
                	System.out.println("Shape Fall");
                	x++;
            	}while(x <= MAXX);
            	System.out.println("Hit Max X");
            	break;
        }  
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
