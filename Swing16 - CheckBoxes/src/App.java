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

// Video Start Time 2hr:24:21 to 2hr:34:05

/*
 * BLUF: We added a checkbox to our program which then in turn enabled or
 * disabled a textfield.
 * 
 * --- Step by Step for Adding Combo Box and controlling textFields (MVC-way) --
 * 
 * STEP01- Add the JComponent(s) (JCheckBox) into your view (FormPanel.java) as
 * instance vars and instanciate them inside your view's consturctor. Also add
 * it to your GridBagConstraints to actually display it onto your GUI
 * 
 * STEP02- Within the consturctor, create an anon class w/ an ActionListener to
 * listen for true/false when checkbox is ticked/unticked
 * 
 * STEP03- Go to your temporary data store class (FormEvent.java) and add
 * instance vars, code into your consturctor, and put in getters
 * 
 * STEP04- Go back to your view (FormPanel.java) and add into your anon
 * ActionListener button temp vars to be passed into the constructor of your
 * temp data class (FormEvent.java)
 * 
 * (read more detailed comments in FormPanel.java and FormEvent.java...)
 */
