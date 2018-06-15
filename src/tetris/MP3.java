package tetris;

import java.io.BufferedInputStream;
import java.io.FileInputStream;

import javazoom.jl.player.Player;

public class MP3 {
    private String filename;
    private Player player; 
    private boolean loop=false;
    private FileInputStream BGM,clear,GG;
    private BufferedInputStream bis;
    
    private static Thread audioThread;
  
    public MP3() {
    }
    
    public MP3(String filename) {
        this.filename = filename;
    }

    public void setLoop(boolean loop) {
    	this.loop = loop;
    }
    
    public void stop() {
    	loop = false;
    	audioThread.stop();
    }

    public void GGplay() {
        audioThread = new Thread(new Runnable() {
            public void run() {
            	do {
                    try {
                        GG = new FileInputStream("src/music/GG.mp3");
                        bis = new BufferedInputStream(GG);
                        player = new Player(bis);
                    }
                    catch (Exception e) {
                        System.out.println(e);
                    }

            		try { player.play(); }
                    catch (Exception e) { 
                    	
                    }            		
            	}while(loop);
            }
        });
        audioThread.start();
        
    }
    
    public void clearplay() {
        audioThread = new Thread(new Runnable() {
            public void run() {
            	do {
                    try {
                        clear = new FileInputStream("src/music/clear.mp3");
                        bis = new BufferedInputStream(clear);
                        player = new Player(bis);
                    }
                    catch (Exception e) {
                        System.out.println(e);
                    }

            		try { player.play(); }
                    catch (Exception e) { 
                    	
                    }            		
            	}while(loop);
            }
        });
        audioThread.start();
        
    }
    
    public void BGMplay() {
        audioThread = new Thread(new Runnable() {
            public void run() {
            	do {
                    try {
                        BGM = new FileInputStream("src/music/dejavu.mp3");
                        bis = new BufferedInputStream(BGM);
                        player = new Player(bis);
                    }
                    catch (Exception e) {
                        System.out.println(e);
                    }

            		try { player.play(); }
                    catch (Exception e) { 
                    	
                    }            		
            	}while(loop);
            }
        });
        audioThread.start();
        
    }
}