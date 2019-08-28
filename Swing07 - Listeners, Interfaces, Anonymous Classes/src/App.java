 import javax.swing.SwingUtilities;

public class App {

	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable() { 

			public void run() {

				new MainFrame();

			}

		});

	}

}


// Video Start Time 50:46 to 1hr:02:25
// See step by step comments in "MainFrame.java" for
// Listener classes, anonymous class implementations within MVC concept