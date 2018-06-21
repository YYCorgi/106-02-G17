package tetris;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Dead extends JPanel {

	private long fscore,ftime;

	private String name;
	
	public void name(String s) {
		name = s;
	}
	
	public void result(long s, long t) {
		fscore = s;
		ftime = t;
	}
	
	private void newframe() {
		JFrame f = new JFrame("Result");
		f.setSize(250,250);
		f.setVisible(true);
		
		Dead d = new Dead();
		f.add(d);
	}
	
	public void paintComponent(Graphics g){	
		g.fillRect(0, 0, 250, 250);
		
		g.setColor(Color.WHITE);
		g.drawString("" + fscore, 20, 40);
		g.drawString("" + ftime, 20, 80);
		g.drawString("" + name, 20, 120);
		
		repaint();
	}
}
