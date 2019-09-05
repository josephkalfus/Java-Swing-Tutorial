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

// Video Start Time 2hr:01:59 to 2hr:11:42

/*
 * BLUF: We made a small "utility class" at the bottom of FormPanel.java which
 * created some private "class" vars that included the ID and age category. We
 * then created new instances of this with our DefaultListModel w/in
 * FormPanel.java and w/in our addActionListener anon class, we just Typed and
 * Casted the getSelectedValue when the GUI button is clicked. We then went to
 * our "temporary" data class and created a private class var and passed in a
 * new parameter in our constructor signature with a getter too. Finally, within
 * MainFrame.java (our Controller), we just passed in the string to our textPanel
 * 
 */
