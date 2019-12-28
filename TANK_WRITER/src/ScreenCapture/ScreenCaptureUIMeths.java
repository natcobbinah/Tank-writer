package ScreenCapture;

import java.awt.Component;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class ScreenCaptureUIMeths {

	public void  captureComponent(Component component) {
		Rectangle rect = component.getBounds();
		
		try {
			String format = "png";
			
			String fileName = component.getName() + "." + format;
			
			BufferedImage captureImage = new BufferedImage(rect.width,rect.height,BufferedImage.TYPE_INT_ARGB);
			
			component.paint(captureImage.getGraphics());
			
			ImageIO.write(captureImage, format, new File(fileName));
			System.out.printf("The screenshot of %s was saved:",component.getName());
		}catch(Exception e) {
			System.err.println(e);
		}
	}
}
