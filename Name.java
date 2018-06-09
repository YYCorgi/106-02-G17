package tetris;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Name extends JPanel{

	final int MAX = 100;
	Dead d = new Dead();
	
	public void enter() {
		JFrame f = new JFrame("Enter Player");
		JTextField t = new JTextField();
		f.setSize(250,250);
		f.setVisible(true);
		
		t.setColumns(MAX);
		f.add(t);

		String name = t.getText();
		t.setText(name);
		System.out.println(name);
		
		d.name(name);
		
		
	}	
}
