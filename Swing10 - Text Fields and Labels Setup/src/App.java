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


// Video Start Time 1hr:10:54 to 1hr:14:58

/* BLUF: Add your labels and text fields into the class variables
 * section of your custom JComponent class. Then within the constructor,
 * instantiate those labels (with the new keyword). This will not display
 * the labels or textfields just yet. (see FormPanel.java)
 * 
 */

