import java.awt.Dimension;

import javax.swing.JPanel;

public class FormPanel extends JPanel{
	// Class Variables

	// Constructors
	public FormPanel() {
		
		// BorderLayout Manager doesn't respect the
		// height for our new FormPanel JComponent
		Dimension dim = getPreferredSize();
		System.out.println(dim);
		dim.width = 250;
		setPreferredSize(dim); // may also work w/ buttons in GridBackLayout Manager
	}
	// Getters Setters

	// Class Methods
}
