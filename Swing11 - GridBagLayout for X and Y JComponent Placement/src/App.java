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


// Video Start Time 1hr:14:58 to 1hr:31:07

/* BLUF: We use the GridBagLayout in FormPanel.java. We also use 
 * GridBagConstraints to set the attributes of each "cell". Basically
 * you set up a X,Y axis layout and can set all sorts of ways to position
 * your components. 
 * 
 */

