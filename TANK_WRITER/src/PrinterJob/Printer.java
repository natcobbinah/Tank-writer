package PrinterJob;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Printer implements Printable,ActionListener{
	
	public int print(Graphics g, PageFormat pf, int page) throws PrinterException {
		if(page > 0) {
			return NO_SUCH_PAGE;
		}
		
		Graphics2D g2d = (Graphics2D)g;
		g2d.translate(pf.getImageableX(), pf.getImageableY());
		
		g.drawString("Hello World", 100,100);
		
		return PAGE_EXISTS;
	}
	
	public void actionPerformed(ActionEvent e) {
		PrinterJob job = PrinterJob.getPrinterJob();
		job.setPrintable(this);
		
		boolean ok = job.printDialog();
		
		if(ok) {
			try {
				job.print();
			}catch(PrinterException ex) {
				//
			}
		}
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("Hello");
		
		JButton printbtn = new JButton("Print");
		
		printbtn.addActionListener( new Printer());
	
		
		frame.setSize(300, 300);
		frame.add("Center",printbtn);
		frame.setVisible(true);
	}

}


