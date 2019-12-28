import javax.swing.SwingUtilities;

public class Tankexe {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
			   new 	TankMainFrame();	
			}
		});
	}

}
