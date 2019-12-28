package ScreenCapture;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class ScreenCaptureUIMainFrame extends JFrame {
	
	private JButton Captureme;
	private JButton CapturethisFrame;
	private ScreenCaptureUIMeths screencapturemeths;
	
	public ScreenCaptureUIMainFrame() {
		layoutdesign();
		
		setSize(300,300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void layoutdesign() {
		setLayout(new FlowLayout());
		
		screencapturemeths = new ScreenCaptureUIMeths();
		
		Captureme = new JButton("Capture Me");
		CapturethisFrame = new JButton("Capture this Frame");
		
		add(Captureme);
		add(CapturethisFrame);
		
		Captureme.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == Captureme) {
					screencapturemeths.captureComponent(Captureme);
				}
			}
		});
		
		CapturethisFrame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == CapturethisFrame) {
					screencapturemeths.captureComponent(CapturethisFrame);
				}
			}
		});
	}

}
