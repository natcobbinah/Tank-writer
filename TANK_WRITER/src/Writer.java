import java.awt.Event;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.text.Document;
import javax.swing.undo.CannotRedoException;
import javax.swing.undo.UndoManager;

import Wordmanipulations.Tokenizer;

public class Writer extends JPanel {

	// -----------------------------------------------------------------
	private Document txtareadocument;

	protected UndoHandler undoHandler = new UndoHandler();
	protected UndoManager undoManager = new UndoManager();

	private UndoAction undoAction = null;
	private RedoAction redoAction = null;

	// -----------------------------------------------------------------

	public  JTextArea txtarea;
	private Font font;
	

	public Writer() {

		layoutdesign();

		setVisible(true);
	}

	private void layoutdesign() {
		setLayout(new FlowLayout());

		font = new Font("Monospace", Font.PLAIN, 17);

		txtarea = new JTextArea(35,65);

		txtarea.setFont(font);
		
		txtarea.setLineWrap(true);
		txtarea.setWrapStyleWord(true);
		
		
		// -----------------------------------------------------------can be deleted
		txtareadocument = txtarea.getDocument();
		txtareadocument.addUndoableEditListener(undoHandler);

		KeyStroke undoKeystroke = KeyStroke.getKeyStroke(KeyEvent.VK_Z, Event.META_MASK);
		KeyStroke redoKeystroke = KeyStroke.getKeyStroke(KeyEvent.VK_Y, Event.META_MASK);

		undoAction = new UndoAction();
		txtarea.getInputMap().put(undoKeystroke, "undoKeystroke");
		txtarea.getActionMap().put("undoKeyStroke", undoAction);

		redoAction = new RedoAction();
		txtarea.getInputMap().put(redoKeystroke, "redoKeystroke");
		txtarea.getActionMap().put("redoKeystroke", redoAction);

		// -------------------------------------------------------------
		add(new JScrollPane(txtarea));
	}

	// ------------------------------------------------------------------

	// java udo and redo action classes
	public class UndoHandler implements UndoableEditListener {

		// Messaged when the document has created an edit, the edit is added to
		// <code>undoManager</code>, an instance of undoManager

		public UndoHandler() {

		}

		public void undoableEditHappened(UndoableEditEvent e) {
			undoManager.addEdit(e.getEdit());
			undoAction.update();
			redoAction.update();
		}
	}

	class UndoAction extends AbstractAction {

		public UndoAction() {
			super("Undo");
			setEnabled(false);
		}

		public void actionPerformed(ActionEvent e) {
			try {
				undoManager.undo();
			} catch (CannotRedoException ex) {
				// ex.printStackTRace();
			}
			update();
			redoAction.update();
		}

		protected void update() {
			if (undoManager.canUndo()) {
				setEnabled(true);
				putValue(Action.NAME, undoManager.getUndoPresentationName());
			} else {
				setEnabled(false);
				putValue(Action.NAME, "Undo");
			}
		}
	}

	class RedoAction extends AbstractAction {
		public RedoAction() {
			super("Redo");
			setEnabled(false);
		}

		public void actionPerformed(ActionEvent e) {
			try {
				undoManager.redo();
			} catch (CannotRedoException ex) {
				ex.printStackTrace();
			}
			update();
			undoAction.update();
		}

		protected void update() {
			if (undoManager.canRedo()) {
				setEnabled(true);
				putValue(Action.NAME, undoManager.getRedoPresentationName());
			} else {
				setEnabled(false);
				putValue(Action.NAME, "Redo");
			}
		}
		// ------------------------------------------------------------------
	}

	// decrease font class
	public void doSmallerFontSizeAction() {
		// get the current font
		Font f = txtarea.getFont();

		// create a new, smaller font from the current font
		Font f2 = new Font(f.getName(), f.getStyle(), f.getSize() - 1);

		// set the new font in the text area
		txtarea.setFont(f2);
	}

	// increase font class
	public void doBiggerFontSizeAction() {
		// get the current font
		Font f = txtarea.getFont();

		// create a new, bigger font from the current font
		Font f2 = new Font(f.getName(), f.getStyle(), f.getSize() + 1);

		// set the new font in the text area
		txtarea.setFont(f2);
	}
}
