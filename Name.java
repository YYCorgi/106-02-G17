package tetris;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Name extends JFrame implements ActionListener{

	JButton con = new JButton("Confirm");
	
	JTextField ti = new JTextField();
	JTextField tan = new JTextField();
	JTextField tas = new JTextField();

	JLabel jln = new JLabel("Player:"); 
	JLabel jls = new JLabel("Score:");
	
	private long fs;

	public Name(long fscore) {
		this.fs = fscore;
	}

	public Name() {}

	public void enter() {
		jln.setBounds(20,40,100,20); 
		add(jln); 
		jls.setBounds(20, 70, 100, 20);
		add(jls);
		
		ti.addActionListener(this); 
		ti.setBounds(70,40,100,20); 
		add(ti); 
		
		tas.setEditable(false);
		tas.setBounds(70, 70, 40, 20);
		add(tas);
		
		tan.setEditable(false); 
		tan.setBounds(70,40,100,20); 
		add(tan); 
		
		con.addActionListener(this); 
		con.setBounds(75,110,70,20); 
		add(con);

		tas.setText(""+fs);
		
		setTitle("Game Over"); 
		setLayout(null); 
		setBounds(100, 100, 220, 180); 
		setVisible(true); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == con || e.getSource() == ti) { 
			String area; 
			area = ti.getText(); 
			String stArea = String.valueOf(area); 
			tan.setText("" + stArea ); 
		}
	} 
		
}	