package tetris;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Csetframe extends JFrame implements ActionListener{

	private JPanel Color;
	private JButton Classic;
	private JButton Custom;

	private GridBagConstraints gbc= new GridBagConstraints();
	private Gaming game = new Gaming();
	
	public Csetframe() {
		super();
		Color = new JPanel(new GridBagLayout());
		Classic = new JButton("Classic");
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridheight = 1;
		gbc.gridwidth = 2;
		gbc.fill = GridBagConstraints.BOTH;
		Classic.addActionListener(this);
		Color.add(Classic,gbc);
		
		Custom = new JButton("Black n'White");
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridheight = 1;
		gbc.gridwidth = 2;
		gbc.fill = GridBagConstraints.BOTH;
		Custom.addActionListener(this);
		Color.add(Custom,gbc);
		
		add(Color,BorderLayout.CENTER);
	
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == Classic) {
			System.out.println("Classic");
			game.setColor(1);
		}
		if(e.getSource() == Custom){
			System.out.println("Black n'White");
			game.setColor(2);
		}
	}
	
}
