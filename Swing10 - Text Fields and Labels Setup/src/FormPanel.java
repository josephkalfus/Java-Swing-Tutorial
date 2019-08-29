import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class FormPanel extends JPanel{
	// Class Variables
	private JLabel nameLabel; // Set up all your labels/fields with private class vars
	private JLabel occupationLabel;
	private JTextField nameField;
	private JTextField occupationField;
	private JButton okBtn;

	// Constructors
	public FormPanel() {

		Dimension dim = getPreferredSize();
		dim.width = 250;
		setPreferredSize(dim); 
		
		nameLabel = new JLabel("Name: "); // Start instantiating your labels and text fields within the constructor
		occupationLabel = new JLabel("Occupation: ");
		nameField = new JTextField(10); // Important to specify how many chars wide this text field should be
		occupationField = new JTextField(10);
		
		okBtn = new JButton("OK");
		
		Border innerBorder = BorderFactory.createTitledBorder("Add Person");
		Border outerBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
		setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));
		
		
	}

}
