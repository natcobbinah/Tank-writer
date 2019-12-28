import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JToolBar;

public class ToolBar extends JToolBar {

	private JButton newFileButton;
	private JButton saveButton;
	private JButton exportButton;
	private JButton findButton;
	private JButton cutButton;
	private JButton pasteButton;
	private JButton undoButton;
	private JButton redoButton;
	private JButton printButton;
	private JButton FontButton;
	private JButton panecolorButton;
	private JButton txtstyleButton;

	private JButton aligncenterbtn;
	private JButton alignjustifybtn;
	private JButton alignleftbtn;
	private JButton alighrightbtn;

	private JButton boldbtn;
	private JButton italicbtn;
	private JButton underlinebtn;

	private JButton fontplus;
	private JButton fontminus;
	

	public ToolBar() {

		layoutdesign();

		setVisible(true);
	}

	public void layoutdesign() {
		setLayout(new FlowLayout(FlowLayout.LEFT));

		// Border innerBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
		// Border outerBorder = BorderFactory.createEtchedBorder();

		// Border compoundBorder = BorderFactory.createCompoundBorder(innerBorder,
		// outerBorder);
		// setBorder(compoundBorder);

		newFileButton = new JButton();
		saveButton = new JButton();
		exportButton = new JButton();
		findButton = new JButton();
		cutButton = new JButton();
		pasteButton = new JButton();
		undoButton = new JButton();
		redoButton = new JButton();
		printButton = new JButton();

		aligncenterbtn = new JButton();
		alignjustifybtn = new JButton();
		alignleftbtn = new JButton();
		alighrightbtn = new JButton();

		boldbtn = new JButton();
		italicbtn = new JButton();
		underlinebtn = new JButton();

		fontplus = new JButton();
		fontminus = new JButton();

		newFileButton.setIcon(Utils.createIcon("/images/New24.gif"));
		newFileButton.setToolTipText("New File");

		saveButton.setIcon(Utils.createIcon("/images/Save24.gif"));
		saveButton.setToolTipText("Refresh");

		exportButton.setIcon(Utils.createIcon("/images/Export24.gif"));
		exportButton.setToolTipText("Export");

		findButton.setIcon(Utils.createIcon("/images/Find24.gif"));
		findButton.setToolTipText("Find");

		cutButton.setIcon(Utils.createIcon("/images/Cut24.gif"));
		cutButton.setToolTipText("Cut");

		pasteButton.setIcon(Utils.createIcon("/images/Paste24.gif"));
		pasteButton.setToolTipText("Paste");

		undoButton.setIcon(Utils.createIcon("/images/Undo24.gif"));
		undoButton.setToolTipText("Undo");

		redoButton.setIcon(Utils.createIcon("/images/Redo24.gif"));
		redoButton.setToolTipText("Redo");

		printButton.setIcon(Utils.createIcon("/images/Print24.gif"));
		printButton.setToolTipText("Print");

		aligncenterbtn.setIcon(Utils.createIcon("/images/AlignCenter24.gif"));
		aligncenterbtn.setToolTipText("Align-Center");

		alignjustifybtn.setIcon(Utils.createIcon("/images/AlignJustify24.gif"));
		alignjustifybtn.setToolTipText("Justify");

		alignleftbtn.setIcon(Utils.createIcon("/images/AlignLeft24.gif"));
		alignleftbtn.setToolTipText("Align-Left");

		alighrightbtn.setIcon(Utils.createIcon("/images/AlignRight24.gif"));
		alighrightbtn.setToolTipText("Align-Right");

		boldbtn.setIcon(Utils.createIcon("/images/Bold24.gif"));
		boldbtn.setToolTipText("Bold");

		italicbtn.setIcon(Utils.createIcon("/images/Italic24.gif"));
		italicbtn.setToolTipText("Italic");

		underlinebtn.setIcon(Utils.createIcon("/images/Underline24.gif"));
		underlinebtn.setToolTipText("Underline");
		
		fontplus.setIcon(Utils.createIcon("/images/fblack.png"));
		fontplus.setToolTipText("Increase Font");
		
		fontminus.setIcon(Utils.createIcon("/images/fredt.png"));
		fontminus.setToolTipText("Decrease Font");


		add(newFileButton);
		add(saveButton);
		add(exportButton);
		add(findButton);
		add(cutButton);
		add(pasteButton);
		add(undoButton);
		add(redoButton);
		add(printButton);

		add(aligncenterbtn);
		add(alignjustifybtn);
		add(alignleftbtn);
		add(alighrightbtn);
		add(boldbtn);
		add(italicbtn);
		add(underlinebtn);
	
		add(fontplus);
		add(fontminus);
		
	}

}
