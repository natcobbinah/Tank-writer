package ScreenCapture;

import javax.swing.SwingUtilities;

public class ScreenCaptureUIexe {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new ScreenCaptureUIMainFrame();
			}
		});
	}

}
