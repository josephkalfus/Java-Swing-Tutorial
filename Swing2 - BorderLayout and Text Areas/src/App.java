 import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class App {

	public static void main(String[] args) {
		
		// Good method for multiple threads, but who knows?
		SwingUtilities.invokeLater(new Runnable() { 

			public void run() {
				new MainFrame();

			}

		});

	}

}
