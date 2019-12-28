import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class BottomPane extends JPanel {
	public JLabel wordlabel;
	public JTextField wordcount;

	public BottomPane() {
		
		layoutdesign();
		
		setVisible(true);
	}
	
	public void layoutdesign() {
		setLayout(new FlowLayout());
		
		Border innerBorder = BorderFactory.createEtchedBorder();
		Border outerBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
		
		Border compoundBorder = BorderFactory.createCompoundBorder(innerBorder, outerBorder);
		
		setBorder(compoundBorder);
		
		wordlabel = new JLabel("Words Count:");
		
		wordcount = new JTextField(25);
		wordcount.setEditable(false);
		
		add(wordlabel);
		add(wordcount);
	}
}
