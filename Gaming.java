package tetris;

import java.awt.Frame;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class Gaming extends JFrame implements KeyListener{

	final int MAXX = 20;
	final int MAXY = 10;
	int x = 0,y = 0;

	public Gaming() {
	}

	public void start() {
		System.out.println("Game Time");
		JFrame frame = new JFrame("Game Time");
		frame.setSize(200, 400);
		frame.setVisible(true);
		frame.addKeyListener(this);
	}

	
	public void Gaming() {
		
	}
	
	public void move() {
		
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
            		System.out.println("Hit Max Y");
            	}
                break;  
            case KeyEvent.VK_RIGHT:  
            	System.out.println("Shape go right");
            	y--;
            	if(y == 0) {
            		System.out.println("Hit min y");
            	}
                break;  
            case KeyEvent.VK_SHIFT:
            	System.out.println("Shape hold");
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
