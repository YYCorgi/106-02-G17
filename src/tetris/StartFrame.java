package tetris;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class StartFrame extends JFrame implements ActionListener{

	private Selection selection = new Selection();
	private GridBagConstraints gbc= new GridBagConstraints();

	MP3 m = new MP3();
	
	private JPanel Action;
	private JButton start;
	private JButton leaderboard;
	private JButton classic;
	private JButton mic;

	Gaming g;
	
	private int micCount = 1;

	final int START = 1;
	final int CLASSIC = 2;
	final int LEADERBOARD = 3;
	
	public boolean music = false;
	
	public StartFrame(){
		super();
		System.out.println("Enter Game mode");
		Action = new JPanel(new GridBagLayout());
		
		start = new JButton("Time Mode");
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridheight = 2;
		gbc.gridwidth = 2;
		gbc.fill = GridBagConstraints.BOTH;
		start.addActionListener(this);
		Action.add(start,gbc);
		
		leaderboard = new JButton("Leaderboard");
		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.gridheight = 2;
		gbc.gridwidth = 2;
		gbc.fill = GridBagConstraints.BOTH;
		leaderboard.addActionListener(this);
		Action.add(leaderboard,gbc);

		classic = new JButton("Classic Mode");
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridheight = 2;
		gbc.gridwidth = 2;
		gbc.fill = GridBagConstraints.BOTH;
		classic.addActionListener(this);
		Action.add(classic,gbc);
		
		mic = new JButton("Music");
		gbc.gridx = 0;
		gbc.gridy = 6;
		gbc.gridheight = 2;
		gbc.gridwidth = 2;
		gbc.fill = GridBagConstraints.BOTH;
		mic.addActionListener(this);
		Action.add(mic,gbc);
		
		add(Action, BorderLayout.CENTER);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==start){
			selection.setSelection(START);
		}
		if(e.getSource() == leaderboard) {
			selection.setSelection(LEADERBOARD);
		}
		if(e.getSource() == classic) {
			selection.setSelection(CLASSIC);
		}
		if(e.getSource()==mic){
			if(micCount % 2 != 0) {
				music = true;
				m.setLoop(true);
				m.BGMplay();
				micCount++;
			}else {
				m.stop();
				music = false;
				micCount++;
			}
		}
	}

}

