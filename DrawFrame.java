package tetris;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class DrawFrame extends JFrame implements ActionListener{

	Selection selection = new Selection();
	
	private JPanel Action;
	private JButton start;
	private JButton leaderboard;
	private JButton setting;

	final int START = 1;
	final int SETTING = 2;
	final int LEADERBOARD = 3;
	
	public DrawFrame(){
		super();
		System.out.println("111");
		Action = new JPanel();
		start = new JButton("Start");
		start.addActionListener(this);
		Action.add(start);
		
		setting = new JButton("Setting");
		setting.addActionListener(this);
		Action.add(setting);
		
		leaderboard = new JButton("Leaderboard");
		leaderboard.addActionListener(this);
		Action.add(leaderboard);
		
		add(Action, BorderLayout.NORTH);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==start){
			selection.setSelection(1);
		}
		if(e.getSource()==setting){
			selection.setSelection(2);
		}
		if(e.getSource() == leaderboard) {
			selection.setSelection(3);
		}
	}

}

