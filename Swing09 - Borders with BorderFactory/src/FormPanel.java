import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class FormPanel extends JPanel{
	// Class Variables

	// Constructors
	public FormPanel() {

		Dimension dim = getPreferredSize();
		
		dim.width = 250;
		setPreferredSize(dim); 
		
		// Recommend to create two borders, one invisible, and one visible and
		// then combine in another method like below
		Border innerBorder = BorderFactory.createTitledBorder("Add Person");
		Border outerBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
		
		setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));
		
		
	}

}
