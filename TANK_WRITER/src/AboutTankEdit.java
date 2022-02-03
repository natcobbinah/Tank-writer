import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.Border;

public class AboutTankEdit extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel imagepanel;
	private JPanel infopanel;
	private JPanel closepanel;
	private JButton closebutton;
	private JTextArea txtarea;

	private Font font;

	public AboutTankEdit() {
		super("About TANK-EDIT");

		layoutdesign();

		setSize(400, 300);
		setResizable(false);

	}

	private void layoutdesign() {
		setLayout(new BorderLayout());

		Border outerBorder = BorderFactory.createEtchedBorder();
		Border innerBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);

		Border compoundBorder = BorderFactory.createCompoundBorder(outerBorder, innerBorder);

		imagepanel = new JPanel();
		imagepanel.setBackground(Color.BLUE);
		imagepanel.setSize(100, 0);
		imagepanel.setLayout(new FlowLayout());
		imagepanel.setBorder(compoundBorder);

		txtarea = new JTextArea(15, 1);
		txtarea.setBackground(Color.WHITE);
		String AboutTankEditmsg =        "Version 1.0" + "\n" 
		                         + "Author: Nathaniel Cobbinah" + "\n"
				                + "Email:fmg3ckali@ggmail.com" + "\n" 
				                + "Email2:baby.hugo74@yahoo.com" + "\n"
				                + "(c) Copyright Tank Contributors and Others 2017" + "\n"
			                 	+ "All rights reserved. This product includes software" + "\n"
				                + "developed by other projects " + "\n"
				                + "including synthetica libraries" + "\n"
			                  	+ "From Jyloo Softwares(http://synthetica.com)" + "\n"
			                	+ "Modified incorporated keyboard by "+"\n"
			                    + "Vladimir Petrenko(sourceforge.net)";
		txtarea.setEditable(false);

		font = new Font("Monospace", Font.PLAIN, 11);

		txtarea.setFont(font);
		txtarea.setText(AboutTankEditmsg);

		infopanel = new JPanel();
		infopanel.add(txtarea);
		infopanel.setBackground(Color.red);

		closebutton = new JButton("Close");
		
		closebutton.addActionListener((ActionEvent e) -> {
			 setVisible(false);
		});

		closepanel = new JPanel();
		closepanel.add(closebutton);
		closepanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		closepanel.setBorder(compoundBorder);

		add(imagepanel, BorderLayout.WEST);
		add(closepanel, BorderLayout.SOUTH);
		add(infopanel, BorderLayout.CENTER);
	}

}
