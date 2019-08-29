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


// Video Start Time 1hr:02:25 to 1hr:07:37

/* BLUF: Layout manager sets size of component to default.
 * Must override the default size in the constructor
 * of your new JComponent class.
 * 
 */

