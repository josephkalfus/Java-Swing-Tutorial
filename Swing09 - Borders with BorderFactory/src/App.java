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


// Video Start Time 1hr:07:37 to 1hr:10:54

/* BLUF: To create a border, you must set it up in the constructor
 * of the JComponent class you have. The default border is very
 * thin, so just use a two border solution and combine them with
 * the help of the BorderFactory class (see FormPanel.java)
 * 
 */

