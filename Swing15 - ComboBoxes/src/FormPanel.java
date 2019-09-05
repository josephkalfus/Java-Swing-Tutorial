import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
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
	private JComboBox empCombo; // new private variable 

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
		empCombo = new JComboBox();
		
		// Set up list box
		DefaultListModel ageModel = new DefaultListModel(); 
		ageModel.addElement(new AgeCategory(0, "Under 18")); 					
		ageModel.addElement(new AgeCategory(1, "18 to 65"));
		ageModel.addElement(new AgeCategory(2, "65 or over"));
		ageList.setModel(ageModel); 
		
		ageList.setPreferredSize(new Dimension(110, 70)); 
		ageList.setBorder(BorderFactory.createEtchedBorder()); 
		ageList.setSelectedIndex(1); 
		
		// set up combo box
		DefaultComboBoxModel empModel = new DefaultComboBoxModel(); // our ComboBox setup
		empModel.addElement("employed");
		empModel.addElement("self-employed");
		empModel.addElement("unemployed");
		empCombo.setModel(empModel);
		empCombo.setSelectedIndex(0);
		empCombo.setEditable(true); // allow to edit the combo box
									// JAVA BUG: For some reason, when setEditable is true,
									// then the Name and Occupation text fields show up correctly
									// but when false, or not defined, then they are tiny text fields
		
		

		okBtn = new JButton("OK");

		okBtn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				String name = nameField.getText();
				String occupation = occupationField.getText();
				AgeCategory ageCat = (AgeCategory) ageList.getSelectedValue(); 
				String empCat = (String)empCombo.getSelectedItem();
				
				
				System.out.println(empCat); 

				FormEvent ev = new FormEvent(this, name, occupation, ageCat.getId(), empCat);

				if (formListener != null) {
					formListener.formEventOccurred(ev);
				}
			}

		});

		Border innerBorder = BorderFactory.createTitledBorder("Add Person");
		Border outerBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
		setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));
		
		layoutComponents(); // we moved all our GridBagLayout stuff into its own method and
							// now we have to call it here so we can lay everything out. 

		

	}
	
	public void layoutComponents() { // Just moved our stuff into a method 
		setLayout(new GridBagLayout());

		GridBagConstraints gc = new GridBagConstraints();

		// ----------------- First Row ---------------------------
		
		gc.gridy = 0; // New Technique, just increment gridy w/ ++
						// this allows us to add components without renumbering them
		
		gc.weightx = 1;
		gc.weighty = 0.1;

		gc.gridx = 0;
		
		gc.fill = GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.LINE_END;

		
		gc.insets = new Insets(0, 0, 0, 5);
		add(nameLabel, gc);

		gc.gridx = 1;
		gc.gridy = 0;
		gc.insets = new Insets(0, 0, 0, 0);
		gc.anchor = GridBagConstraints.LINE_START;
		add(nameField, gc);

		// ----------------- Next Row ---------------------------
		gc.gridy++; // INCREMENT (and etc++ belows)
		
		gc.weightx = 1;
		gc.weighty = 0.1;
		gc.gridx = 0;
		gc.insets = new Insets(0, 0, 0, 5);
		gc.anchor = GridBagConstraints.LINE_END;
		add(occupationLabel, gc);


		gc.gridx = 1;
		gc.insets = new Insets(0, 0, 0, 0);
		gc.anchor = GridBagConstraints.LINE_START;
		add(occupationField, gc);

		// ----------------- Next Row ---------------------------
		gc.gridy++;
		
		gc.weightx = 1;
		gc.weighty = 0.2;
		
		gc.gridx = 0;
		gc.insets = new Insets(0, 0, 0, 5);
		gc.anchor = GridBagConstraints.FIRST_LINE_END;
		add(new JLabel("Age: "), gc);
		
		gc.gridx = 1;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		gc.insets = new Insets(0, 0, 0, 0);
		add(ageList, gc); 
		
		// ----------------- Next Row ---------------------------
		gc.gridy++;
		
		gc.weightx = 1;
		gc.weighty = 0.2;
		
		gc.gridx = 0;
		gc.insets = new Insets(0, 0, 0, 5);
		gc.anchor = GridBagConstraints.FIRST_LINE_END;
		add(new JLabel("Employment: "), gc);
		
		gc.gridx = 1;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		gc.insets = new Insets(0, 0, 0, 0);
		add(empCombo, gc); 

		// ----------------- Next Row ---------------------------
		gc.gridy++;
		
		gc.weightx = 1;
		gc.weighty = 2.0;
		gc.gridx = 1;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		gc.insets = new Insets(0, 0, 0, 0);
		add(okBtn, gc);
	}

	public void setFormListener(FormListener listener) {
		this.formListener = listener;
	}

}

class AgeCategory { // Utility Class
	// class variables
	private int id;
	private String text;
	
	// constructor
	public AgeCategory(int id, String text) {
		this.id = id;
		this.text = text;
	}
	
	public String toString() { 
		return text;			
	}
	
	public int getId() {
		return id;
	}
}




