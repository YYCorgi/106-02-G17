package tetris;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Gaming implements KeyListener{

	public void start() {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
        switch(e.getKeyCode())  {  
            case KeyEvent.VK_UP: 
            	System.out.println("Shape turn");
                break;  
            case KeyEvent.VK_DOWN:  
            	System.out.println("Shape Fall");
                break;  
            case KeyEvent.VK_LEFT:  
            	System.out.println("Shape go left");
                break;  
            case KeyEvent.VK_RIGHT:  
            	System.out.println("Shape go right");
                break;  
            case KeyEvent.VK_SHIFT:
            	System.out.println("Shape hold");
            	break;
            case KeyEvent.VK_SPACE:
            	System.out.println("Shape fall to ground");
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
