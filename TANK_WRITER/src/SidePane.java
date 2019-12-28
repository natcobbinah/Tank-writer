import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class SidePane  extends JPanel{

	public SidePane() {
		
		layoutdesign();
		setVisible(false);
	}
	
	public void layoutdesign() {
		setLayout(new GridBagLayout());
		
		Border innerBorder = BorderFactory.createEtchedBorder();
		Border outerBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
		
		Border compoundBorder = BorderFactory.createCompoundBorder(innerBorder, outerBorder);
		
		setBorder(compoundBorder);
	}
}
