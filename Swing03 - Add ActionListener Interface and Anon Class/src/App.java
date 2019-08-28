 import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class App {

	public static void main(String[] args) {
		
		// Good method for multiple threads, but who knows?
		SwingUtilities.invokeLater(new Runnable() { 

			public void run() {
				// calls child class "MainFrame.java"'s constructor 
				// located in another file
				// and sets up the GUI initialization of a window
				new MainFrame();

			}

		});

	}

}


// Video Start Time 21:57 to 26:14