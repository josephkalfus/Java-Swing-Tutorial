import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
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
	private FormListener formListener;
	private JList ageList; 

	// Constructors
	public FormPanel() {

		Dimension dim = getPreferredSize();
		dim.width = 250;
		setPreferredSize(dim);

		nameLabel = new JLabel("Name: ");
		occupationLabel = new JLabel("Occupation: ");
		nameField = new JTextField(10);
		occupationField = new JTextField(10);
		ageList = new JList();

		DefaultListModel ageModel = new DefaultListModel(); 
		ageModel.addElement(new AgeCategory(0, "Under 18")); // Add this to our small "utility class" at the bottom of this file					
		ageModel.addElement(new AgeCategory(1, "18 to 65"));
		ageModel.addElement(new AgeCategory(2, "65 or over"));
		ageList.setModel(ageModel); 
		
		ageList.setPreferredSize(new Dimension(110, 66)); 
		ageList.setBorder(BorderFactory.createEtchedBorder()); 
		ageList.setSelectedIndex(1); 

		okBtn = new JButton("OK");

		okBtn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				String name = nameField.getText();
				String occupation = occupationField.getText();
				AgeCategory ageCat = (AgeCategory) ageList.getSelectedValue(); // Now instead of casting to string, 
																		// cast it to new class AgeCategory at the bottom of this file
																		// along w/ the type AgeCategory
																		// Advantage of this is that is has access to String and ID,
																		// instead of just the hard-coded string (which may change)
				
				System.out.println(ageCat.getId()); // now output the ID in console for testing purposes (with method in our new class)

				FormEvent ev = new FormEvent(this, name, occupation, ageCat.getId());

				if (formListener != null) {
					formListener.formEventOccurred(ev);
				}
			}

		});

		Border innerBorder = BorderFactory.createTitledBorder("Add Person");
		Border outerBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
		setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));

		setLayout(new GridBagLayout());

		GridBagConstraints gc = new GridBagConstraints();

		// ----------------- First Row ---------------------------
		gc.weightx = 1;
		gc.weighty = 0.1;

		gc.gridx = 0;
		gc.gridy = 0;

		gc.anchor = GridBagConstraints.LINE_END;

		gc.fill = GridBagConstraints.NONE;
		gc.insets = new Insets(0, 0, 0, 5);
		add(nameLabel, gc);

		gc.gridx = 1;
		gc.gridy = 0;
		gc.insets = new Insets(0, 0, 0, 0);
		gc.anchor = GridBagConstraints.LINE_START;
		add(nameField, gc);

		// ----------------- Second Row ---------------------------
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

		// ----------------- Third Row ---------------------------
		gc.weightx = 1;
		gc.weighty = 0.2;

		gc.gridy = 2;
		gc.gridx = 1;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		add(ageList, gc); 

		// ----------------- Forth Row ---------------------------
		gc.weightx = 1;
		gc.weighty = 2.0;

		gc.gridy = 3;
		gc.gridx = 1;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		add(okBtn, gc);

	}

	public void setFormListener(FormListener listener) {
		this.formListener = listener;
	}

}

class AgeCategory { // small "utility class" for matching IDs to String
	// class variables
	private int id;
	private String text;
	
	// constructor
	public AgeCategory(int id, String text) {
		this.id = id;
		this.text = text;
	}
	
	public String toString() { // must override with this otherwise it will output 
		return text;			// actual object address in the list box GUI
	}
	
	public int getId() {
		return id;
	}
}




