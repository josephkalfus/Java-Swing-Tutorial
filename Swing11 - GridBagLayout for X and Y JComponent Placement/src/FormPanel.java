import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class FormPanel extends JPanel {
	// Class Variables
	private JLabel nameLabel;
	private JLabel occupationLabel;
	private JTextField nameField;
	private JTextField occupationField;
	private JButton okBtn;

	// Constructors
	public FormPanel() {

		Dimension dim = getPreferredSize();
		dim.width = 250;
		setPreferredSize(dim);

		nameLabel = new JLabel("Name: ");
		occupationLabel = new JLabel("Occupation: ");
		nameField = new JTextField(10);
		occupationField = new JTextField(10);

		okBtn = new JButton("OK");

		Border innerBorder = BorderFactory.createTitledBorder("Add Person");
		Border outerBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
		setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));

		setLayout(new GridBagLayout()); // new layout manager concept

		GridBagConstraints gc = new GridBagConstraints(); // use new class
		
		
		
		// initilize those "GridBagConstraints" fields
		
		//----------------- First Row ---------------------------
		gc.weightx = 1; // controls how much space it takes up in cell relative to cells
		gc.weighty = 0.1; // the number isn't important, but is important to relative other "weights"
		
		gc.gridx = 0; // start left, and work to right ie X-axis
		gc.gridy = 0;	// start top, and work down on the Y-axis (as seen below)


		gc.anchor = GridBagConstraints.LINE_END; // this alligns the controls
		
		gc.fill = GridBagConstraints.NONE; // how much cells take up space
		gc.insets = new Insets(0, 0, 0, 5); // controls the spacing around a component (top, left, bottom, right)
		add(nameLabel, gc); // add component, but if you pass in only one component, will take up entire cell

		gc.gridx = 1; // now moving onto next "cell"
		gc.gridy = 0;
		gc.insets = new Insets(0, 0, 0, 0);
		gc.anchor = GridBagConstraints.LINE_START;
		add(nameField, gc);
		
		
		//----------------- Second Row ---------------------------
		gc.weightx = 1; 
		gc.weighty = 0.1; 
		
		gc.gridy = 1;
		gc.gridx = 0;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = new Insets(0, 0, 0, 5); 
		add(occupationLabel, gc);

		gc.gridx = 1;
		gc.gridy = 1;
		gc.anchor = GridBagConstraints.LINE_START;
		gc.insets = new Insets(0, 0, 0, 0);
		add(occupationField, gc);
		
		//----------------- Third Row ---------------------------
		gc.weightx = 1; 
		gc.weighty = 2.0; // now button "weight" takes up more space relative to 0.1 dicated in other weights
		
		gc.gridy = 2;
		gc.gridx = 1;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		add(okBtn, gc);
		
		
	}

}
