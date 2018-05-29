package tetris;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Gmodeframe extends JFrame implements ActionListener{

	private JPanel Mode;
	private JButton time;
	private JButton GG;
	
	private GridBagConstraints gbc= new GridBagConstraints();
	private Gaming game = new Gaming();
	
	public Gmodeframe() {
		super();
		Mode = new JPanel(new GridBagLayout());
		time = new JButton("Time Mode");
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridheight = 1;
		gbc.gridwidth = 2;
		gbc.fill = GridBagConstraints.BOTH;
		time.addActionListener(this);
		Mode.add(time,gbc);
		
		GG = new JButton("Death Mode");
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridheight = 1;
		gbc.gridwidth = 2;
		gbc.fill = GridBagConstraints.BOTH;
		GG.addActionListener(this);
		Mode.add(GG,gbc);
		
		add(Mode,BorderLayout.CENTER);
	
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == time) {
			System.out.println("Time Mode");
			game.setMode(1);
		}else {
			System.out.println("Death Mode");
			game.setMode(2);
		}
	}

}
