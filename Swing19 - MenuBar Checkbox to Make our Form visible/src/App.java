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

// Video Start Time 2hr:53:50 to 3hr:00:14

/*
 * BLUF: We added a checkbox to our menu item to control the visibility of a
 * JComponent see MainFrame.Java. We also made it the default for this checkbox
 * to be enabled so that formPanel is visible at startup.
 * 
 * 
 */
