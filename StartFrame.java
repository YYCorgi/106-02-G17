package tetris;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class StartFrame extends JFrame implements ActionListener{

	private Selection selection = new Selection();
	private GridBagConstraints gbc= new GridBagConstraints();
	
	private JPanel Action;
	private JButton start;
	private JButton leaderboard;
	private JButton setting;

	final int START = 1;
	final int SETTING = 2;
	final int LEADERBOARD = 3;
	
	public StartFrame(){
		super();
		System.out.println("Enter Game mode");
		Action = new JPanel(new GridBagLayout());
		
		
		start = new JButton("Start");
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridheight = 2;
		gbc.gridwidth = 2;
		gbc.fill = GridBagConstraints.BOTH;
		start.addActionListener(this);
		Action.add(start,gbc);
		
		setting = new JButton("Setting");
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridheight = 2;
		gbc.gridwidth = 2;
		gbc.fill = GridBagConstraints.BOTH;
		setting.addActionListener(this);
		Action.add(setting,gbc);
		
		leaderboard = new JButton("Leaderboard");
		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.gridheight = 2;
		gbc.gridwidth = 2;
		gbc.fill = GridBagConstraints.BOTH;
		leaderboard.addActionListener(this);
		Action.add(leaderboard,gbc);
		
		add(Action, BorderLayout.CENTER);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==start){
			selection.setSelection(START);
		}
		if(e.getSource()==setting){
			selection.setSelection(SETTING);
		}
		if(e.getSource() == leaderboard) {
			selection.setSelection(LEADERBOARD);
		}
	}

}

