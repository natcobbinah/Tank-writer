import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class GotolineDialog extends JDialog {
	
	private JLabel linelabel;
	public JTextField linetxtfd;
	public JButton gobtn;
	
	public GotolineDialog(JFrame parent) {
		super(parent,"Goto", false);
		
		setLocationRelativeTo(parent);
		
		layoutdesign();
		
		setSize(400,200);
		
		//setVisible(true);
	}
	
	public void layoutdesign() {
		setLayout(new GridBagLayout());
		
		GridBagConstraints gc = new GridBagConstraints();
		
		linelabel = new JLabel("Line:");
		
		linetxtfd = new JTextField(25);
		
		gobtn = new JButton("Go");
		
		//--laying out components
		gc.gridx=0;
		gc.gridy=0;
		gc.ipadx=5;
		gc.ipady=5;
		gc.insets=new Insets(4,4,4,4);
		gc.anchor=GridBagConstraints.NORTHWEST;
		add(linelabel,gc);
		
		gc.gridx=1;
		gc.gridy=0;
		gc.anchor=GridBagConstraints.NORTHWEST;
		add(linetxtfd,gc);
		
		gc.gridx=1;
		gc.gridy=1;
		gc.ipadx=2*24;
		gc.anchor=GridBagConstraints.NORTHWEST;
		add(gobtn,gc);
	}

}
