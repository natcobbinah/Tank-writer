import java.awt.AWTException;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;
import java.util.Locale;
import java.util.Properties;

import javax.imageio.ImageIO;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import VirtualKeyboard.VirtualKeyboardDialog;
import Wordmanipulations.Tokenizer;
import de.javasoft.plaf.synthetica.SyntheticaAluOxideLookAndFeel;
import de.javasoft.plaf.synthetica.SyntheticaBlackEyeLookAndFeel;
import de.javasoft.plaf.synthetica.SyntheticaBlackStarLookAndFeel;
import de.javasoft.plaf.synthetica.SyntheticaBlueIceLookAndFeel;
import de.javasoft.plaf.synthetica.SyntheticaBlueLightLookAndFeel;
import de.javasoft.plaf.synthetica.SyntheticaBlueMoonLookAndFeel;
import de.javasoft.plaf.synthetica.SyntheticaBlueSteelLookAndFeel;
import de.javasoft.plaf.synthetica.SyntheticaClassyLookAndFeel;
import de.javasoft.plaf.synthetica.SyntheticaGreenDreamLookAndFeel;
import de.javasoft.plaf.synthetica.SyntheticaMauveMetallicLookAndFeel;
import de.javasoft.plaf.synthetica.SyntheticaOrangeMetallicLookAndFeel;
import de.javasoft.plaf.synthetica.SyntheticaPlainLookAndFeel;
import de.javasoft.plaf.synthetica.SyntheticaSilverMoonLookAndFeel;
import de.javasoft.plaf.synthetica.SyntheticaSimple2DLookAndFeel;
import de.javasoft.plaf.synthetica.SyntheticaSkyMetallicLookAndFeel;
import de.javasoft.plaf.synthetica.SyntheticaWhiteVisionLookAndFeel;

public class TankMainFrame extends JFrame {

	private ToolBar toolbar;
	private SidePane sidepane;
	////////////////////////////
	private Writer writepane;

	/////////////////////////////
	private BottomPane btmpane;
	private JComboBox enumcbo;

	public static int count = 0;

	private VirtualKeyboardDialog vkeybddialog;
	Properties langProp = null;
	Locale locale = null;

	private JFileChooser filechooser;

	private JTabbedPane tpane;

	private AboutTankEdit abttnkedit;

	private GotolineDialog godialog;

	private Tokenizer tk;

	TankMainFrame() {
		super("TANK-WORD");

		try {
			UIManager.setLookAndFeel(new SyntheticaAluOxideLookAndFeel());
		} catch (UnsupportedLookAndFeelException | ParseException e) {
			// TODO Auto-generated catch block
		}

		filechooser = new JFileChooser();
		tpane = new JTabbedPane();
		godialog = new GotolineDialog(TankMainFrame.this);

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

		setJMenuBar(createMenuBar());

		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

		setSize(dim.width, dim.height);

		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void layoutdesign() {
		setLayout(new BorderLayout());

		enumcbo = new JComboBox();

		abttnkedit = new AboutTankEdit();

		vkeybddialog = new VirtualKeyboardDialog(TankMainFrame.this, true);

		toolbar = new ToolBar();
		sidepane = new SidePane();
		/////////////////////////////////
		writepane = new Writer();

		////////////////////////////////
		btmpane = new BottomPane();
		tk = new Tokenizer();

		writepane.txtarea.addKeyListener(new KeyListener() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					String words = writepane.txtarea.getText();
					List<String> tokens = Tokenizer.wordsToList(words);

					List<String> totalcount = new ArrayList<String>();
					for (String token : tokens)
						totalcount.add(token);
					int totalwords = totalcount.size();
					btmpane.wordcount.setText(Integer.toString(totalwords));
				}
			}

			@Override
			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub

			}

		});

		tpane = new JTabbedPane();
		tpane.add(writepane, "Sheet1");

		add(toolbar, BorderLayout.NORTH);
		add(sidepane, BorderLayout.WEST);
		add(tpane, BorderLayout.CENTER);
		add(btmpane, BorderLayout.SOUTH);
	}

	private JMenuBar createMenuBar() {

		JMenuBar menuBar = new JMenuBar();

		JMenu filemenu = new JMenu("File");
		JMenuItem newFilemenuitem = new JMenuItem("New File");
		JMenuItem openfilemenuitem = new JMenuItem("OpenFile ...");
		JMenuItem savefilemenuitem = new JMenuItem("Save");
		JMenuItem saveasfilemenuitem = new JMenuItem("Save as");
		JMenuItem exitmenuitem = new JMenuItem("Exit");
		JMenuItem virtualkboarditem = new JMenuItem("Virtual Keyboard");
		JMenuItem takescrnshotitem = new JMenuItem("Take ScreenShot");

		newFilemenuitem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
		openfilemenuitem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
		savefilemenuitem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
		saveasfilemenuitem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.SHIFT_MASK));
		exitmenuitem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));
		virtualkboarditem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_K, ActionEvent.CTRL_MASK));
		takescrnshotitem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T, ActionEvent.CTRL_MASK));

		filemenu.add(newFilemenuitem);
		filemenu.add(openfilemenuitem);
		filemenu.add(savefilemenuitem);
		filemenu.add(saveasfilemenuitem);
		filemenu.add(exitmenuitem);
		filemenu.add(virtualkboarditem);
		filemenu.add(takescrnshotitem);

		newFilemenuitem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tpane.setSelectedIndex(count++);
			}
		});

		openfilemenuitem.addActionListener((ActionEvent e) -> {
			FileFilter ffilter_one = new FileNameExtensionFilter("Text Files", "txt");
			FileFilter ffilter_two = new FileNameExtensionFilter("XML Files", "xml");

			filechooser.addChoosableFileFilter(ffilter_one);
			filechooser.addChoosableFileFilter(ffilter_two);

			int returnValue = filechooser.showOpenDialog(TankMainFrame.this);

			if (returnValue == javax.swing.JFileChooser.APPROVE_OPTION) {
				java.io.File file = filechooser.getSelectedFile();

				String file_name = file.toString();

				try {
					ReadFile file_to_read = new ReadFile(file_name);

					String[] txtfileLength = file_to_read.openFile();

					int i;
					String theText = "";
					for (i = 0; i < txtfileLength.length; i++) {
						theText = theText + txtfileLength[i] + "\n";
					}
					writepane.txtarea.setText(theText);
				} catch (Exception e1) {

				}
				JOptionPane.showMessageDialog(TankMainFrame.this, file_name);
			}
		});

		savefilemenuitem.addActionListener((ActionEvent e) -> {
			FileFilter file_type = new FileNameExtensionFilter("Text Files", "txt");

			filechooser.addChoosableFileFilter(file_type);

			int returnValue = filechooser.showSaveDialog(TankMainFrame.this);

			if (returnValue == javax.swing.JFileChooser.APPROVE_OPTION) {
				java.io.File file_to_save = filechooser.getSelectedFile();

				String file_name = file_to_save.toString();

				try {
					WriteFile savefile = new WriteFile(file_name);

					String texttypedontxtarea = writepane.txtarea.getText();

					savefile.WriteToFile(texttypedontxtarea);

					JOptionPane.showMessageDialog(TankMainFrame.this, "File Saved");
				} catch (Exception e2) {

				}
			}
		});

		saveasfilemenuitem.addActionListener((ActionEvent e) -> {
			FileFilter file_type = new FileNameExtensionFilter("Text Files", "txt");

			filechooser.addChoosableFileFilter(file_type);

			int returnValue = filechooser.showSaveDialog(TankMainFrame.this);

			if (returnValue == javax.swing.JFileChooser.APPROVE_OPTION) {
				java.io.File file_to_save = filechooser.getSelectedFile();

				String file_name = file_to_save.toString();

				try {
					WriteFile savefile = new WriteFile(file_name);

					String texttypedontxtarea = writepane.txtarea.getText();

					savefile.WriteToFile(texttypedontxtarea);

					JOptionPane.showMessageDialog(TankMainFrame.this, "File Saved");
				} catch (Exception e2) {

				}
			}

		});

		exitmenuitem.addActionListener((ActionEvent e) -> {
			int result = JOptionPane.showConfirmDialog(TankMainFrame.this, "Do you really want to quit");

			if (result == JOptionPane.YES_OPTION) {
				System.exit(0);
			}
		});

		virtualkboarditem.addActionListener((ActionEvent e) -> {
			try {
				langProp = new Properties();
				langProp.load(getClass().getResourceAsStream("/VirtualKeyboard/Keyboard_lang.properties"));

				for (Enumeration ee = langProp.propertyNames(); ee.hasMoreElements();) {
					// System.out.println(e.nextElement().toString());
					enumcbo.addItem(ee.nextElement().toString());
				}
				enumcbo.setSelectedItem("de");
			} catch (IOException ee) {
				System.err.println(ee);
			}

			writepane.txtarea.addMouseListener(new MouseAdapter() {
				public void mousePressed(MouseEvent e) {
					vkeybddialog = new VirtualKeyboardDialog(TankMainFrame.this, false, writepane.txtarea);
					// vkeybddialog.setPoitToUp(chkautoup.isSelected());
					// vkeybddialog.setPoitToUp(chkshiftbs.isSelected());
					vkeybddialog.setLocale(locale);
				}
			});

			enumcbo.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent e) {
					locale = new Locale((String) enumcbo.getSelectedItem());
				}
			});
		});

		takescrnshotitem.addActionListener((ActionEvent e) -> {
			FileFilter file_type = new FileNameExtensionFilter("Png Files", "png");
			FileFilter file_type_two = new FileNameExtensionFilter("Jpg Files", "jpg");

			filechooser.addChoosableFileFilter(file_type);
			filechooser.addChoosableFileFilter(file_type_two);

			File file_to_save;

			int returnValue = filechooser.showSaveDialog(TankMainFrame.this);

			if (returnValue == javax.swing.JFileChooser.APPROVE_OPTION) {
				file_to_save = filechooser.getSelectedFile();

				try {
					Robot robot = new Robot();

					Rectangle rectangle = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
					BufferedImage bufferedImage = robot.createScreenCapture(rectangle);

					boolean status = ImageIO.write(bufferedImage, "png", file_to_save);

					file_to_save.getAbsolutePath();
				} catch (AWTException | IOException e1) {
					e1.printStackTrace();
				}
			}

			/*
			 * try { Robot robot = new Robot();
			 * 
			 * Rectangle rectangle = new
			 * Rectangle(Toolkit.getDefaultToolkit().getScreenSize()); BufferedImage
			 * bufferedImage = robot.createScreenCapture(rectangle);
			 * 
			 * File file = new File("/root/Desktop/screen-capture.png"); boolean status =
			 * ImageIO.write(bufferedImage, "png", file);
			 * 
			 * // System.out.println("Screen Captured ?" + status + "FIle Path:-" + //
			 * file.getAbsolutePath()); } catch (AWTException | IOException e1) {
			 * e1.printStackTrace(); }
			 */
		});

		JMenu editmenu = new JMenu("Edit");
		JMenuItem undomenuitem = new JMenuItem("Undo");
		JMenuItem redomenuitem = new JMenuItem("Redo");
		JMenuItem findndrplcitem = new JMenuItem("Find&Replace");
		JMenuItem gotolinemenuitem = new JMenuItem("Go to Line");
		JMenuItem selctallmenuitem = new JMenuItem("Select All");
		JMenuItem deletemenuitem = new JMenuItem("Delete");
		JMenuItem cutmenuitem = new JMenuItem("Cut");
		JMenuItem copymenuitem = new JMenuItem("Copy");
		JMenuItem pastemenuitem = new JMenuItem("Paste");
		JMenuItem uppercaseitem = new JMenuItem("To upperCase");
		JMenuItem lowercaseitem = new JMenuItem("To lowerCase");
		JMenuItem increaseFont = new JMenuItem("Font(+)");
		JMenuItem decreaseFont = new JMenuItem("Font(-)");

		undomenuitem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, ActionEvent.CTRL_MASK));
		redomenuitem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Y, ActionEvent.CTRL_MASK));
		findndrplcitem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, ActionEvent.SHIFT_MASK));
		gotolinemenuitem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G, ActionEvent.SHIFT_MASK));
		selctallmenuitem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));

		cutmenuitem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));
		copymenuitem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
		pastemenuitem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, ActionEvent.CTRL_MASK));
		increaseFont.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I, ActionEvent.SHIFT_MASK));
		decreaseFont.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.SHIFT_MASK));

		editmenu.add(undomenuitem);
		editmenu.add(redomenuitem);
		editmenu.add(findndrplcitem);
		editmenu.add(gotolinemenuitem);
		editmenu.add(selctallmenuitem);
		editmenu.add(deletemenuitem);
		editmenu.add(cutmenuitem);
		editmenu.add(copymenuitem);
		editmenu.add(pastemenuitem);
		editmenu.add(increaseFont);
		editmenu.add(decreaseFont);
		editmenu.add(uppercaseitem);
		editmenu.add(lowercaseitem);

		uppercaseitem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String uppercase = writepane.txtarea.getSelectedText();

				if (Character.isLowerCase(uppercase.charAt(uppercase.length() - 1))) {
					writepane.txtarea.setText(uppercase.toUpperCase());
				}
			}
		});

		lowercaseitem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String lowercase = writepane.txtarea.getSelectedText();

				if (Character.isUpperCase(lowercase.charAt(lowercase.length() - 1))) {
					writepane.txtarea.setText(lowercase.toUpperCase());
				}
			}
		});

		selctallmenuitem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				writepane.txtarea.selectAll();
			}
		});

		gotolinemenuitem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				godialog.setVisible(true);
			}
		});

		godialog.gobtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String linenumber = godialog.linetxtfd.getText();

				int index = Integer.parseInt(linenumber);

				writepane.txtarea.setCaretPosition(
						writepane.txtarea.getDocument().getDefaultRootElement().getElement(index - 1).getStartOffset());

				writepane.txtarea.requestFocusInWindow();

				godialog.dispose();

			}
		});

		increaseFont.addActionListener((ActionEvent e) -> {
			writepane.doBiggerFontSizeAction();
		});

		decreaseFont.addActionListener((ActionEvent e) -> {
			writepane.doSmallerFontSizeAction();
		});

		JMenu helpmenu = new JMenu("Help");
		JMenuItem aboutmenuitem = new JMenuItem("About");
		JMenuItem tankedithelp = new JMenuItem("TANKEDIT help");

		aboutmenuitem.addActionListener((ActionEvent e) -> {
			abttnkedit.setVisible(true);
		});

		helpmenu.add(aboutmenuitem);
		helpmenu.add(tankedithelp);

		JMenu othersmenu = new JMenu("Others");
		JMenuItem printitem = new JMenuItem("Print");
		JMenu showMenu = new JMenu("Show");
		JCheckBoxMenuItem showItem = new JCheckBoxMenuItem("Side-Panel");
		showMenu.add(showItem);

		JMenu thememenu = new JMenu("Themes");
		List<JMenuItem> themesItems = Arrays.asList(new JMenuItem("BlackEye"), new JMenuItem("ClassyLook"),
				new JMenuItem("Lightblue"), new JMenuItem("OrangeMetal"), new JMenuItem("AluOxide"),
				new JMenuItem("GreenDream"), new JMenuItem("BlackMoon"), new JMenuItem("BlackStar"),
				new JMenuItem("BlueIce"), new JMenuItem("BlueMoon"), new JMenuItem("BlueSteel"),
				new JMenuItem("MauveMetal"), new JMenuItem("PLAIN"), new JMenuItem("SilverMoon"),
				new JMenuItem("Simple2D"), new JMenuItem("SkyMetal"), new JMenuItem("WhiteVision"));
		
		for(JMenuItem items : themesItems) {
			thememenu.add(items);
		}

		themesItems.get(0).addActionListener((ActionEvent e) -> {
			try {
				UIManager.setLookAndFeel(new SyntheticaBlackEyeLookAndFeel());
				SwingUtilities.updateComponentTreeUI(TankMainFrame.this);
			} catch (UnsupportedLookAndFeelException | ParseException ee) {
				// TODO Auto-generated catch block
			}
		});

		themesItems.get(1).addActionListener((ActionEvent e) -> {
			try {
				UIManager.setLookAndFeel(new SyntheticaClassyLookAndFeel());
				SwingUtilities.updateComponentTreeUI(TankMainFrame.this);
			} catch (UnsupportedLookAndFeelException | ParseException ee) {
				// TODO Auto-generated catch block
			}
		});

		themesItems.get(2).addActionListener((ActionEvent e) -> {
			try {
				UIManager.setLookAndFeel(new SyntheticaBlueLightLookAndFeel());
				SwingUtilities.updateComponentTreeUI(TankMainFrame.this);
			} catch (UnsupportedLookAndFeelException | ParseException ee) {
				// TODO Auto-generated catch block
			}
		});

		themesItems.get(3).addActionListener((ActionEvent e) -> {
			try {
				UIManager.setLookAndFeel(new SyntheticaOrangeMetallicLookAndFeel());
				SwingUtilities.updateComponentTreeUI(TankMainFrame.this);
			} catch (UnsupportedLookAndFeelException | ParseException ee) {
				// TODO Auto-generated catch block
			}
		});

		themesItems.get(4).addActionListener((ActionEvent e) -> {
			try {
				UIManager.setLookAndFeel(new SyntheticaGreenDreamLookAndFeel());
				SwingUtilities.updateComponentTreeUI(TankMainFrame.this);
			} catch (UnsupportedLookAndFeelException | ParseException ee) {
				// TODO Auto-generated catch block
			}
		});

		themesItems.get(5).addActionListener((ActionEvent e) -> {
			try {
				UIManager.setLookAndFeel(new SyntheticaBlueMoonLookAndFeel());
				SwingUtilities.updateComponentTreeUI(TankMainFrame.this);
			} catch (UnsupportedLookAndFeelException | ParseException ee) {
				// TODO Auto-generated catch block
			}
		});

		themesItems.get(6).addActionListener((ActionEvent e) -> {
			try {
				UIManager.setLookAndFeel(new SyntheticaBlackStarLookAndFeel());
				SwingUtilities.updateComponentTreeUI(TankMainFrame.this);
			} catch (UnsupportedLookAndFeelException | ParseException ee) {
				// TODO Auto-generated catch block
			}
		});

		themesItems.get(7).addActionListener((ActionEvent e) -> {
			try {
				UIManager.setLookAndFeel(new SyntheticaBlueIceLookAndFeel());
				SwingUtilities.updateComponentTreeUI(TankMainFrame.this);
			} catch (UnsupportedLookAndFeelException | ParseException ee) {
				// TODO Auto-generated catch block
			}
		});

		themesItems.get(8).addActionListener((ActionEvent e) -> {
			try {
				UIManager.setLookAndFeel(new SyntheticaBlueMoonLookAndFeel());
				SwingUtilities.updateComponentTreeUI(TankMainFrame.this);
			} catch (UnsupportedLookAndFeelException | ParseException ee) {
				// TODO Auto-generated catch block
			}
		});

		themesItems.get(9).addActionListener((ActionEvent e) -> {
			try {
				UIManager.setLookAndFeel(new SyntheticaBlueSteelLookAndFeel());
				SwingUtilities.updateComponentTreeUI(TankMainFrame.this);
			} catch (UnsupportedLookAndFeelException | ParseException ee) {
				// TODO Auto-generated catch block
			}
		});

		themesItems.get(10).addActionListener((ActionEvent e) -> {
			try {
				UIManager.setLookAndFeel(new SyntheticaMauveMetallicLookAndFeel());
				SwingUtilities.updateComponentTreeUI(TankMainFrame.this);
			} catch (UnsupportedLookAndFeelException | ParseException ee) {
				// TODO Auto-generated catch block
			}
		});

		themesItems.get(11).addActionListener((ActionEvent e) -> {
			try {
				UIManager.setLookAndFeel(new SyntheticaPlainLookAndFeel());
				SwingUtilities.updateComponentTreeUI(TankMainFrame.this);
			} catch (UnsupportedLookAndFeelException | ParseException ee) {
				// TODO Auto-generated catch block
			}
		});

		themesItems.get(12).addActionListener((ActionEvent e) -> {
			try {
				UIManager.setLookAndFeel(new SyntheticaSilverMoonLookAndFeel());
				SwingUtilities.updateComponentTreeUI(TankMainFrame.this);
			} catch (UnsupportedLookAndFeelException | ParseException ee) {
				// TODO Auto-generated catch block
			}
		});

		themesItems.get(13).addActionListener((ActionEvent e) -> {
			try {
				UIManager.setLookAndFeel(new SyntheticaSimple2DLookAndFeel());
				SwingUtilities.updateComponentTreeUI(TankMainFrame.this);
			} catch (UnsupportedLookAndFeelException | ParseException ee) {
				// TODO Auto-generated catch block
			}
		});

		themesItems.get(14).addActionListener((ActionEvent e) -> {
			try {
				UIManager.setLookAndFeel(new SyntheticaSkyMetallicLookAndFeel());
				SwingUtilities.updateComponentTreeUI(TankMainFrame.this);
			} catch (UnsupportedLookAndFeelException | ParseException ee) {
				// TODO Auto-generated catch block
			}
		});

		themesItems.get(15).addActionListener((ActionEvent e) -> {
			try {
				UIManager.setLookAndFeel(new SyntheticaWhiteVisionLookAndFeel());
				SwingUtilities.updateComponentTreeUI(TankMainFrame.this);
			} catch (UnsupportedLookAndFeelException | ParseException ee) {
				// TODO Auto-generated catch block
			}
		});

		themesItems.get(16).addActionListener((ActionEvent e) -> {
			try {
				UIManager.setLookAndFeel(new SyntheticaAluOxideLookAndFeel());
				SwingUtilities.updateComponentTreeUI(TankMainFrame.this);
			} catch (UnsupportedLookAndFeelException | ParseException ee) {
				// TODO Auto-generated catch block
			}
		});

		othersmenu.add(printitem);
		othersmenu.add(showMenu);
		othersmenu.add(thememenu);

		menuBar.add(filemenu);
		menuBar.add(editmenu);
		menuBar.add(helpmenu);
		menuBar.add(othersmenu);

		return menuBar;
	}
}
