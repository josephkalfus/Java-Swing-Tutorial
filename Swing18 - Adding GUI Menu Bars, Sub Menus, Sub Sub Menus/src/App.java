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

// Video Start Time 2hr:43:53 to 2hr:53:50

/*
 * BLUF: Basically, add a new method into your controller (MainFrame.java) which
 * returns a JMenuBar and you can add various top level, and sub level menus. In
 * the constructor of your controller (MainMenu.java) just call setJMenuBar and
 * pass in your newly created method you just wrote
 * 
 */
