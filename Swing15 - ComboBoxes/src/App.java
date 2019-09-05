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

// Video Start Time 2hr:11:42 to 2hr:24:21

/*
 * BLUF: We added a combo box (that can be edited) into our FormPanel.java. We
 * also rearranged our code in FormPanel.java and moved the row/column set up
 * into its own method.
 * 
 * PRO-TRICK: Another trick we learned is to increment gridy with ++ operator to
 * advance our row instead of hard coding the the row column (gridy)
 * 
 * JAVA-BUG: For some reason when using GridBagLayout, it sort of messes up the
 * text fields when adding a JComboBox / DefaultComboBoxModel. If you comment
 * out the setEditable(true) within FormPanel.java, it makes the text fields
 * tiny.
 * 
 */
