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
	private Writer writepane2;
	private Writer writepane3;
	private Writer writepane4;
	private Writer writepane5;
	private Writer writepane6;
	private Writer writepane7;
	private Writer writepane8;
	private Writer writepane9;
	private Writer writepane10;
	private Writer writepane11;
	private Writer writepane12;
	private Writer writepane13;
	private Writer writepane14;
	private Writer writepane15;
	private Writer writepane16;
	private Writer writepane17;
	private Writer writepane18;
	private Writer writepane19;
	private Writer writepane20;
	private Writer writepane21;
	private Writer writepane22;
	private Writer writepane23;
	private Writer writepane24;
	private Writer writepane25;
	private Writer writepane26;
	private Writer writepane27;
	private Writer writepane28;
	private Writer writepane29;
	private Writer writepane30;
	private Writer writepane31;
	private Writer writepane32;
	private Writer writepane33;
	private Writer writepane34;
	private Writer writepane35;
	private Writer writepane36;
	private Writer writepane37;
	private Writer writepane38;
	private Writer writepane39;
	private Writer writepane40;
	private Writer writepane41;
	private Writer writepane42;
	private Writer writepane43;
	private Writer writepane44;
	private Writer writepane45;
	private Writer writepane46;
	private Writer writepane47;
	private Writer writepane48;
	private Writer writepane49;
	private Writer writepane50;
	private Writer writepane51;
	private Writer writepane52;
	private Writer writepane53;
	private Writer writepane54;
	private Writer writepane55;
	private Writer writepane56;
	private Writer writepane57;
	private Writer writepane58;
	private Writer writepane59;
	private Writer writepane60;
	private Writer writepane61;
	private Writer writepane62;
	private Writer writepane63;
	private Writer writepane64;
	private Writer writepane65;
	private Writer writepane66;
	private Writer writepane67;
	private Writer writepane68;
	private Writer writepane69;
	private Writer writepane70;
	private Writer writepane71;
	private Writer writepane72;
	private Writer writepane73;
	private Writer writepane74;
	private Writer writepane75;
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
		writepane2 = new Writer();
		writepane3 = new Writer();
		writepane4 = new Writer();
		writepane5 = new Writer();
		writepane6 = new Writer();
		writepane7 = new Writer();
		writepane8 = new Writer();
		writepane9 = new Writer();
		writepane10 = new Writer();
		writepane11 = new Writer();
		writepane12 = new Writer();
		writepane13 = new Writer();
		writepane14 = new Writer();
		writepane15 = new Writer();
		writepane16 = new Writer();
		writepane17 = new Writer();
		writepane18 = new Writer();
		writepane19 = new Writer();
		writepane20 = new Writer();
		writepane21 = new Writer();
		writepane22 = new Writer();
		writepane23 = new Writer();
		writepane24 = new Writer();
		writepane25 = new Writer();
		writepane26 = new Writer();
		writepane27 = new Writer();
		writepane28 = new Writer();
		writepane29 = new Writer();
		writepane30 = new Writer();
		writepane31 = new Writer();
		writepane32 = new Writer();
		writepane33 = new Writer();
		writepane34 = new Writer();
		writepane35 = new Writer();
		writepane36 = new Writer();
		writepane37 = new Writer();
		writepane38 = new Writer();
		writepane39 = new Writer();
		writepane40 = new Writer();
		writepane41 = new Writer();
		writepane42 = new Writer();
		writepane43 = new Writer();
		writepane44 = new Writer();
		writepane45 = new Writer();
		writepane46 = new Writer();
		writepane47 = new Writer();
		writepane48 = new Writer();
		writepane49 = new Writer();
		writepane50 = new Writer();
		writepane51 = new Writer();
		writepane52 = new Writer();
		writepane53 = new Writer();
		writepane54 = new Writer();
		writepane55 = new Writer();
		writepane56 = new Writer();
		writepane57 = new Writer();
		writepane58 = new Writer();
		writepane59 = new Writer();
		writepane60 = new Writer();
		writepane61 = new Writer();
		writepane62 = new Writer();
		writepane63 = new Writer();
		writepane64 = new Writer();
		writepane65 = new Writer();
		writepane66 = new Writer();
		writepane67 = new Writer();
		writepane68 = new Writer();
		writepane69 = new Writer();
		writepane70 = new Writer();
		writepane71 = new Writer();
		writepane72 = new Writer();
		writepane73 = new Writer();
		writepane74 = new Writer();
		writepane75 = new Writer();
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
		tpane.add(writepane,"Sheet1");
		tpane.add(writepane2);
		tpane.add(writepane3);
		tpane.add(writepane4);
		tpane.add(writepane5);
		tpane.add(writepane6);
		tpane.add(writepane7);
		tpane.add(writepane8);
		tpane.add(writepane9);
		tpane.add(writepane10);
		tpane.add(writepane11);
		tpane.add(writepane12);
		tpane.add(writepane13);
		tpane.add(writepane14);
		tpane.add(writepane15);
		tpane.add(writepane16);
		tpane.add(writepane17);
		tpane.add(writepane18);
		tpane.add(writepane19);
		tpane.add(writepane20);
		tpane.add(writepane21);
		tpane.add(writepane22);
		tpane.add(writepane23);
		tpane.add(writepane24);
		tpane.add(writepane25);
		tpane.add(writepane26);
		tpane.add(writepane27);
		tpane.add(writepane28);
		tpane.add(writepane29);
		tpane.add(writepane30);
		tpane.add(writepane31);
		tpane.add(writepane32);
		tpane.add(writepane33);
		tpane.add(writepane34);
		tpane.add(writepane35);
		tpane.add(writepane36);
		tpane.add(writepane37);
		tpane.add(writepane38);
		tpane.add(writepane39);
		tpane.add(writepane40);
		tpane.add(writepane41);
		tpane.add(writepane42);
		tpane.add(writepane43);
		tpane.add(writepane44);
		tpane.add(writepane45);
		tpane.add(writepane46);
		tpane.add(writepane47);
		tpane.add(writepane48);
		tpane.add(writepane49);
		tpane.add(writepane50);
		tpane.add(writepane51);
		tpane.add(writepane52);
		tpane.add(writepane53);
		tpane.add(writepane54);
		tpane.add(writepane55);
		tpane.add(writepane56);
		tpane.add(writepane57);
		tpane.add(writepane58);
		tpane.add(writepane59);
		tpane.add(writepane60);
		tpane.add(writepane61);
		tpane.add(writepane61);
		tpane.add(writepane63);
		tpane.add(writepane64);
		tpane.add(writepane65);
		tpane.add(writepane66);
		tpane.add(writepane67);
		tpane.add(writepane68);
		tpane.add(writepane69);
		tpane.add(writepane70);
		tpane.add(writepane71);
		tpane.add(writepane72);
		tpane.add(writepane73);
		tpane.add(writepane74);
		tpane.add(writepane75);

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

		openfilemenuitem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
			}
		});

		savefilemenuitem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
			}
		});

		saveasfilemenuitem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
			}
		});

		exitmenuitem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(TankMainFrame.this, "Do you really want to quit");

				if (result == JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			}
		});

		virtualkboarditem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

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

			}
		});

		takescrnshotitem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

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

		increaseFont.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				writepane.doBiggerFontSizeAction();
			}
		});

		decreaseFont.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				writepane.doSmallerFontSizeAction();
			}
		});

		JMenu helpmenu = new JMenu("Help");
		JMenuItem aboutmenuitem = new JMenuItem("About");
		JMenuItem tankedithelp = new JMenuItem("TANKEDIT help");

		aboutmenuitem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abttnkedit.setVisible(true);
			}
		});

		helpmenu.add(aboutmenuitem);
		helpmenu.add(tankedithelp);

		JMenu othersmenu = new JMenu("Others");
		JMenuItem printitem = new JMenuItem("Print");
		JMenu showMenu = new JMenu("Show");
		JCheckBoxMenuItem showItem = new JCheckBoxMenuItem("Side-Panel");
		showMenu.add(showItem);

		JMenu thememenu = new JMenu("Themes");
		JMenuItem blackeye = new JMenuItem("BlackEye");
		JMenuItem classy = new JMenuItem("ClassyLook");
		JMenuItem bluelight = new JMenuItem("Lightblue");
		JMenuItem orangemetal = new JMenuItem("OrangeMetal");
		JMenuItem aluoxide = new JMenuItem("AluOxide");
		JMenuItem greendream = new JMenuItem("GreenDream");
		JMenuItem blackmoon = new JMenuItem("BlackMoon");
		JMenuItem blackstar = new JMenuItem("BlackStar");
		JMenuItem blueice = new JMenuItem("BlueIce");
		JMenuItem bluemoon = new JMenuItem("BlueMoon");
		JMenuItem bluesteel = new JMenuItem("BlueSteel");
		JMenuItem mauvemetal = new JMenuItem("MauveMetal");
		JMenuItem plain = new JMenuItem("PLAIN");
		JMenuItem silvermoon = new JMenuItem("SilverMoon");
		JMenuItem simple2d = new JMenuItem("Simple2D");
		JMenuItem skymetal = new JMenuItem("SkyMetal");
		JMenuItem whitevision = new JMenuItem("WhiteVision");
		thememenu.add(blackeye);
		thememenu.add(classy);
		thememenu.add(bluelight);
		thememenu.add(orangemetal);
		thememenu.add(greendream);
		thememenu.add(blackmoon);
		thememenu.add(blackstar);
		thememenu.add(blueice);
		thememenu.add(bluemoon);
		thememenu.add(bluesteel);
		thememenu.add(mauvemetal);
		thememenu.add(plain);
		thememenu.add(silvermoon);
		thememenu.add(simple2d);
		thememenu.add(skymetal);
		thememenu.add(whitevision);
		thememenu.add(aluoxide);

		blackeye.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					UIManager.setLookAndFeel(new SyntheticaBlackEyeLookAndFeel());
					SwingUtilities.updateComponentTreeUI(TankMainFrame.this);
				} catch (UnsupportedLookAndFeelException | ParseException ee) {
					// TODO Auto-generated catch block
				}
			}
		});

		classy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					UIManager.setLookAndFeel(new SyntheticaClassyLookAndFeel());
					SwingUtilities.updateComponentTreeUI(TankMainFrame.this);
				} catch (UnsupportedLookAndFeelException | ParseException ee) {
					// TODO Auto-generated catch block
				}
			}
		});

		bluelight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					UIManager.setLookAndFeel(new SyntheticaBlueLightLookAndFeel());
					SwingUtilities.updateComponentTreeUI(TankMainFrame.this);
				} catch (UnsupportedLookAndFeelException | ParseException ee) {
					// TODO Auto-generated catch block
				}
			}
		});

		orangemetal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					UIManager.setLookAndFeel(new SyntheticaOrangeMetallicLookAndFeel());
					SwingUtilities.updateComponentTreeUI(TankMainFrame.this);
				} catch (UnsupportedLookAndFeelException | ParseException ee) {
					// TODO Auto-generated catch block
				}
			}
		});

		greendream.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					UIManager.setLookAndFeel(new SyntheticaGreenDreamLookAndFeel());
					SwingUtilities.updateComponentTreeUI(TankMainFrame.this);
				} catch (UnsupportedLookAndFeelException | ParseException ee) {
					// TODO Auto-generated catch block
				}
			}
		});

		blackmoon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					UIManager.setLookAndFeel(new SyntheticaBlueMoonLookAndFeel());
					SwingUtilities.updateComponentTreeUI(TankMainFrame.this);
				} catch (UnsupportedLookAndFeelException | ParseException ee) {
					// TODO Auto-generated catch block
				}
			}
		});

		blackstar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					UIManager.setLookAndFeel(new SyntheticaBlackStarLookAndFeel());
					SwingUtilities.updateComponentTreeUI(TankMainFrame.this);
				} catch (UnsupportedLookAndFeelException | ParseException ee) {
					// TODO Auto-generated catch block
				}
			}
		});

		blueice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					UIManager.setLookAndFeel(new SyntheticaBlueIceLookAndFeel());
					SwingUtilities.updateComponentTreeUI(TankMainFrame.this);
				} catch (UnsupportedLookAndFeelException | ParseException ee) {
					// TODO Auto-generated catch block
				}
			}
		});

		bluemoon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					UIManager.setLookAndFeel(new SyntheticaBlueMoonLookAndFeel());
					SwingUtilities.updateComponentTreeUI(TankMainFrame.this);
				} catch (UnsupportedLookAndFeelException | ParseException ee) {
					// TODO Auto-generated catch block
				}
			}
		});

		bluesteel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					UIManager.setLookAndFeel(new SyntheticaBlueSteelLookAndFeel());
					SwingUtilities.updateComponentTreeUI(TankMainFrame.this);
				} catch (UnsupportedLookAndFeelException | ParseException ee) {
					// TODO Auto-generated catch block
				}
			}
		});

		mauvemetal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					UIManager.setLookAndFeel(new SyntheticaMauveMetallicLookAndFeel());
					SwingUtilities.updateComponentTreeUI(TankMainFrame.this);
				} catch (UnsupportedLookAndFeelException | ParseException ee) {
					// TODO Auto-generated catch block
				}
			}
		});

		plain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					UIManager.setLookAndFeel(new SyntheticaPlainLookAndFeel());
					SwingUtilities.updateComponentTreeUI(TankMainFrame.this);
				} catch (UnsupportedLookAndFeelException | ParseException ee) {
					// TODO Auto-generated catch block
				}
			}
		});

		silvermoon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					UIManager.setLookAndFeel(new SyntheticaSilverMoonLookAndFeel());
					SwingUtilities.updateComponentTreeUI(TankMainFrame.this);
				} catch (UnsupportedLookAndFeelException | ParseException ee) {
					// TODO Auto-generated catch block
				}
			}
		});

		simple2d.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					UIManager.setLookAndFeel(new SyntheticaSimple2DLookAndFeel());
					SwingUtilities.updateComponentTreeUI(TankMainFrame.this);
				} catch (UnsupportedLookAndFeelException | ParseException ee) {
					// TODO Auto-generated catch block
				}
			}
		});

		skymetal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					UIManager.setLookAndFeel(new SyntheticaSkyMetallicLookAndFeel());
					SwingUtilities.updateComponentTreeUI(TankMainFrame.this);
				} catch (UnsupportedLookAndFeelException | ParseException ee) {
					// TODO Auto-generated catch block
				}
			}
		});

		whitevision.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					UIManager.setLookAndFeel(new SyntheticaWhiteVisionLookAndFeel());
					SwingUtilities.updateComponentTreeUI(TankMainFrame.this);
				} catch (UnsupportedLookAndFeelException | ParseException ee) {
					// TODO Auto-generated catch block
				}
			}
		});

		aluoxide.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					UIManager.setLookAndFeel(new SyntheticaAluOxideLookAndFeel());
					SwingUtilities.updateComponentTreeUI(TankMainFrame.this);
				} catch (UnsupportedLookAndFeelException | ParseException ee) {
					// TODO Auto-generated catch block
				}
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
