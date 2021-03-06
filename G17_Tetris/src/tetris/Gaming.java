package tetris;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;


public class Gaming extends JPanel{

	public long time = 120;
	boolean gap;
	boolean los = false;
	int numClears = 0;
	private ArrayList<Integer> nextshape = new ArrayList<Integer>();
	MP3 m = new MP3();
	
	private int picCount = 0;
	
	private Color[] OtetraminoColors = {Color.RED, Color.blue, Color.orange, Color.yellow, Color.MAGENTA, Color.CYAN, Color.GREEN};	
	private Point pieceOrigin;
	private Point nextPic;
	private int currentPiece;
	private int nextcurrentPiece;
	private int rotation;
	private ArrayList<Integer> nextPieces = new ArrayList<Integer>();
	protected long score = 0;
	private long cs;
	public long fscore;
	private Color[][] wall;
	
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
	
	public void start() {
		System.out.println("Game Time");
		JFrame f = new JFrame();
		f.setTitle("Game Time");
		f.setSize((40*18)+5,(40*25)-15);
		f.setVisible(true);
		f.setResizable(false);
		
		Gaming g = new Gaming();

		g.init();
		f.add(g);

		f.addKeyListener(new KeyListener() {
			public void keyTyped(KeyEvent e) {
			}
			
			public void keyPressed(KeyEvent e) {
				switch (e.getKeyCode()) {
				case KeyEvent.VK_UP:
					g.rotate(-1);
					break;
				case KeyEvent.VK_DOWN:
					g.dropDown();
					g.score++;
					cs = g.score;
					break;
				case KeyEvent.VK_LEFT:
					g.move(-1);
					break;
				case KeyEvent.VK_RIGHT:
					g.move(+1);
					break;
				} 
			}
			
			public void keyReleased(KeyEvent e) {
			}
		});
	
		new Thread() {
			@Override public void run() {
				while (los != true) {
					try {
						g.los = false;
						Thread.sleep(1000);
						g.time--;
						time = g.time;
						if(time == 0) {
							g.los = true;
							GG(1);
							break;
						}
					}catch(InterruptedException e) {
						
					}
				}
			}
		}.start();
		
		new Thread() {
			@Override public void run() {
				while (los == false) {
					try {
						g.death();
						Thread.sleep(1000);
						g.dropDown();
						if(g.los == true) {
							break;
						}
					} catch ( InterruptedException e ) {}
				}
			}
		}.start();
	}

	public void init() {
		wall = new Color[18][24];
		
		for(int i = 0;i < 7;i++) {
			for(int j = 0;j < 8;j++) {
				if(i == 0 || i == 6 || j == 0 || j == 1 || j == 7) {
					wall[i][j] = Color.BLACK;
				}else {
					wall[i][j] = Color.WHITE;
				}
			}
		}
		
		for(int m = 6;m < 17;m++) {
			for(int n = 0;n < 24;n++) {
				if(m == 6 || m == 17 || n == 0 || n == 23) {
					wall[m][n] = Color.BLACK;
				}else {
					wall[m][n] = Color.WHITE;
				}
			}
		}
		newPiece();
		nextPiece();
	}
	
	private boolean collidesAt(int x, int y, int rotation) {
		for (Point p : Tetraminos[currentPiece][rotation]) {
			if (wall[p.x + x][p.y + y] != Color.WHITE) {
				return true;
			}
		}
		return false;
	}

	public void rotate(int i) {
		int newRotation = (rotation + i) % 4;
		if (newRotation < 0) {
			newRotation = 3;
		}
		if (!collidesAt(pieceOrigin.x, pieceOrigin.y, newRotation)) {
			rotation = newRotation;
		}
		repaint();
	}

	public void move(int i) {
		if (!collidesAt(pieceOrigin.x + i, pieceOrigin.y, rotation)) {
			pieceOrigin.x += i;	
		}
		repaint();
	}
	
	public void dropDown() {
		if (!collidesAt(pieceOrigin.x, pieceOrigin.y + 1, rotation)) {
			pieceOrigin.y += 1;
		} else {
			fixToWell();
		}	
		repaint();
	}
	
	public void fixToWell() {
		for (Point p : Tetraminos[currentPiece][rotation]) {
			wall[pieceOrigin.x + p.x][pieceOrigin.y + p.y] = OtetraminoColors[currentPiece];
		}
		clearRows();	
		death();
		newPiece();
		nextPiece();
	}
	
	public void deleteRow(int row) {
		for (int j = row-1; j > 0; j--) {
			for (int i = 6; i < 17; i++) {
				wall[i][j+1] = wall[i][j];
			}
		}
	}
	
	public void GG(int n) {
		m.setLoop(false);
		m.GGplay();
		Name name = new Name(fscore);
		switch(n) {
		case 1:
			fscore = cs;
			System.out.println("Out of time");
			System.out.println("" + fscore);
			name = new Name(fscore);
			name.enter();
			break;
				
		case 2:
			System.out.println("Reach the roof top");
			System.out.println("" + fscore);
			name = new Name(fscore);
			name.enter();
			break;
		}
	}
	
	public void death() {
		for (int i = 7; i < 17; i++) {
			if (wall[i][1] != Color.WHITE) {
				los = true;
				GG(2);
				break;
			}
		}	
	}
	
	public void clearRows() {	
		for (int j = 22; j > 0; j--) {
			gap = false;
			for (int i = 6; i < 17; i++) {
				if (wall[i][j] == Color.WHITE) {
					gap = true;
					break;
				}
			}
			if (!gap) {
				deleteRow(j);
				j += 1;
				numClears += 1;
				System.out.println("clear");
			}
		}
		
		switch (numClears) {
		case 1:
			m.setLoop(false);
			m.clearplay();
			score += 100;
			cs = score;
			break;
		case 2:
			m.setLoop(false);
			m.clearplay();
			score += 200;
			cs = score;
			break;
		case 3:
			m.setLoop(false);
			m.clearplay();
			score += 400;
			cs = score;
			break;
		case 4:
			m.setLoop(false);
			m.clearplay();
			score += 700;
			cs = score;
			break;
		}
		numClears = 0;
	}
	
	private void drawPiece(Graphics g) {
		g.setColor(OtetraminoColors[currentPiece]);
		for (Point p : Tetraminos[currentPiece][rotation]) {
			g.fillRect((p.x + pieceOrigin.x) * 40, (p.y + pieceOrigin.y) * 40, 39, 39);
		}	
		
		
		g.setColor(OtetraminoColors[nextcurrentPiece]);
		for (Point p : Tetraminos[nextcurrentPiece][0]) {
			g.fillRect((p.x + nextPic.x) * 40, (p.y + nextPic.y) * 40, 39, 39);
		}
	}
	
	public void paintComponent(Graphics g){	
		g.fillRect(0, 0, 40*18, 40*24);
		for (int i = 0; i < 18; i++) {
			for (int j = 0; j < 24; j++) {
				g.setColor(wall[i][j]);
				g.fillRect(40*i, 40*j, 39, 39);
			}
		}
		
		g.setColor(Color.WHITE);
		g.drawString("NEXT", 123,70);
		g.drawString("States",123,420);
		g.drawString("Your Score:",80,490);
		g.drawString("Time Left:",80,525);
		g.drawString("Pieces Count:", 80, 560);
		g.drawString("" + score, 180, 490);
		g.drawString("" + time, 180, 525);
		g.drawString("" + picCount, 180, 560);
		
		repaint();
		drawPiece(g);
	}

	public void nextPiece() {
		nextPic = new Point(2,3);
		rotation = 0;
		if (nextshape.isEmpty()) {
			Collections.addAll(nextshape, 0, 1, 2, 3, 4, 5, 6);
			Collections.shuffle(nextshape);
		}
		nextcurrentPiece = nextshape.get(0);
		nextshape.remove(0);
	}
	
	public void newPiece() {
		picCount++;
		pieceOrigin = new Point(10, 1);
		rotation = 0;
		if(nextPieces.isEmpty()) {
			Collections.addAll(nextPieces, nextcurrentPiece);
		}
		currentPiece = nextPieces.get(0);
		nextPieces.remove(0);	
	}

	public Gaming() {

	}
}
