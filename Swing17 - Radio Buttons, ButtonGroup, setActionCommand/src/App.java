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

// Video Start Time 2hr:34:05 to 2hr:43:53

/*
 * BLUF: We added a male/female radio button. One thing you need to do is also
 * add it into a group with a ButtonGroup (notice not prefixed w/ a J since it
 * comes from AWT). Also you must use setActionCommand to pass into your
 * Button's ActionListener. Do your typical stuff like adding it to your
 * GridBagLayout GUI, modify the constructor/private vars in your FormEvent temp
 * data class etc. Finally, you can test to ensure it works in your controller
 * (MainFrame.java) and sysout male or female to the console.
 * 
 * (see comments in FormPanel.java, FormEvent.java, and MainFrame.java)
 * 
 */
