package tetris;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import d0602.InsertData;

public class Name extends JFrame implements ActionListener{

	JButton con = new JButton("Confirm");
	
	JTextField ti = new JTextField();
	JTextField tan = new JTextField();
	JTextField tas = new JTextField();

	JLabel jln = new JLabel("Player:"); 
	JLabel jls = new JLabel("Score:");
	
	public static long fs;
	public static String user_name;

	public Name(long fscore) {
		this.fs = fscore;
	}
	
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
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == con || e.getSource() == ti) { 
			String area; 
			area = ti.getText(); 
			String stArea = String.valueOf(area); 
			if(stArea != null) {
				user_name = stArea;
			}else {
				user_name = "Unnamed";
			}
			System.out.println(user_name);
			
			tan.setText("" + stArea ); 
			InsertData it=new InsertData();
			it.fxxk();
			
		}
	} 
		
}	
