package tetris;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Dead extends JPanel {
	
	public static long ftime;
	public static long fscore;
	
	public static void result(long score,long time) {
		ftime = time;
		fscore = score;
	}
	
	public static void Tnewframe() {
		JFrame tdf = new JFrame();
		tdf.setSize(300, 300);
		tdf.setTitle("Game over!");
		tdf.setVisible(true);
		
		Dead td = new Dead();
		tdf.add(td);
	}

	public static void Rnewframe() {

		JFrame rdf = new JFrame();
		rdf.setSize(300,300);
		rdf.setVisible(true);
		rdf.setTitle("Game ovar!");
		
		Dead rd = new Dead();	
		rdf.add(rd);
	}
	
	
	public void paintComponent(Graphics g){
		g.setColor(Color.gray);
		g.fillRect(0, 0, 300, 270);
		g.setColor(Color.WHITE);
		g.drawString("Your Score is:" + fscore, 40, 40);
		g.drawString("Your Time is:" + ftime, 40, 100);
		
		repaint();
	}
}
