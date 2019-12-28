package VirtualKeyboard;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.text.ParseException;
import java.util.Enumeration;
import java.util.Locale;
import java.util.Properties;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import de.javasoft.plaf.synthetica.SyntheticaAluOxideLookAndFeel;

public class VkeyboardTestFrame extends JFrame {

	private VirtualKeyboardDialog vkeybddialog;

	// ----------------------------------
	private JTextField txtfield;
	private JLabel txtfieldlabel;
	private JComboBox enumcbo;
	private JCheckBox chkautoup;
	private JCheckBox chkshiftbs;
	// ----------------------------------

	Properties langProp = null;
	Locale locale = null;

	public VkeyboardTestFrame() {

		try {
			UIManager.setLookAndFeel(new SyntheticaAluOxideLookAndFeel());
		} catch (UnsupportedLookAndFeelException | ParseException e) {
			// TODO Auto-generated catch block
		}

		layoutdesign();
		locale = Locale.getDefault();
		try {
			langProp = new Properties();
			langProp.load(getClass().getResourceAsStream("/VirtualKeyboard/Keyboard_lang.properties"));

			for (Enumeration e = langProp.propertyNames(); e.hasMoreElements();) {
				// System.out.println(e.nextElement().toString());
				enumcbo.addItem(e.nextElement().toString());
			}
			enumcbo.setSelectedItem("de");
		} catch (IOException e) {
			System.err.println(e);
		}

		vkeybddialog = new VirtualKeyboardDialog(this, true);

		setSize(400, 200);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void layoutdesign() {

		setLayout(new FlowLayout());

		txtfield = new JTextField(10);

		txtfieldlabel = new JLabel("Text");
		enumcbo = new JComboBox();
		chkautoup = new JCheckBox("AutoUp");
		chkshiftbs = new JCheckBox("ShiftBs");

		add(txtfieldlabel);
		add(txtfield);
		add(enumcbo);
		add(chkautoup);
		add(chkshiftbs);

		txtfield.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				vkeybddialog = new VirtualKeyboardDialog(VkeyboardTestFrame.this, false, txtfield);
				vkeybddialog.setPoitToUp(chkautoup.isSelected());
				vkeybddialog.setPoitToUp(chkshiftbs.isSelected());
				vkeybddialog.setLocale(locale);
			}
		});

		txtfield.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				vkeybddialog = new VirtualKeyboardDialog(VkeyboardTestFrame.this, false, txtfield);
				vkeybddialog.setPoitToUp(chkautoup.isSelected());
				vkeybddialog.setPoitToUp(chkshiftbs.isSelected());
				vkeybddialog.setLocale(locale);
			}
		});

		enumcbo.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				locale = new Locale((String) enumcbo.getSelectedItem());
			}
		});
	}
}
