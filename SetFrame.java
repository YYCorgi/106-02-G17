package tetris;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class SetFrame extends JFrame implements ActionListener{

	public Setsel setsel = new Setsel();
	
	public Csetframe csetframe;
	public Gmodeframe gmodeframe;
	
	private JPanel Setter;
	private JButton cset;
	private JButton gmode;
	
	private GridBagConstraints gbc= new GridBagConstraints();
	
	
	public SetFrame() {
		super();
		Setter = new JPanel(new GridBagLayout());
		cset = new JButton("Set Color");
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridheight = 1;
		gbc.gridwidth = 2;
		gbc.fill = GridBagConstraints.BOTH;
		cset.addActionListener(this);
		Setter.add(cset,gbc);
		
		gmode = new JButton("Change Game Mode");
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridheight = 1;
		gbc.gridwidth = 2;
		gbc.fill = GridBagConstraints.BOTH;
		gmode.addActionListener(this);
		Setter.add(gmode,gbc);
		
		add(Setter,BorderLayout.CENTER);
	
	
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == cset) {
			setsel.select(1);
		}
		if(e.getSource() == gmode) {
			setsel.select(2);
		}
		
	}

	
	
}
