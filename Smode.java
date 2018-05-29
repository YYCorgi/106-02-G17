package tetris;

import java.awt.*;
import javax.swing.*;

public class Smode extends JFrame{

	public void set() {
		Gmodeframe gmode = new Gmodeframe();
		gmode.setTitle("Mode Setter");
		gmode.setSize(300,500);
		gmode.setVisible(true);
	}

}
