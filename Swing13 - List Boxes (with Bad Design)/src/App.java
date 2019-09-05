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

// Video Start Time 1hr:51:55 to 2hr:01:59

/*
 * BLUF: We set up a list box in FormPanel.java which lists some strings
 * and attributes (borders, size, default value, etc). Added it to our
 * actionListener to sysout so we can test. Bad design to put in logic into
 * the view. Bad design to rely on Strings (for selection w/in the list box) 
 * instead of IDs 
 * 
 */
