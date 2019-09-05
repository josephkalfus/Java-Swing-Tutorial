import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
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
	private JComboBox empCombo;  
	private JCheckBox citizenCheck; 
	private JTextField taxField; 
	private JLabel taxLabel; 
	
	private JRadioButton maleRadio; // must have seperate radio buttons for
	private JRadioButton femaleRadio; // each option unlike a single checkbox
	private ButtonGroup genderGroup; // must have to group two or more radio buttons together

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
		citizenCheck = new JCheckBox(); 
		taxField = new JTextField(10); 
		taxLabel = new JLabel("Tax ID: "); 
		
		maleRadio = new JRadioButton("male"); // instantiate our new private vars above
		femaleRadio = new JRadioButton("female");
		genderGroup = new ButtonGroup(); // comes from AWT instead of JComponent (notice no J)
		
		maleRadio.setActionCommand("male");  // Use this to pass into your Button's actionListener
		femaleRadio.setActionCommand("female"); 
		
		maleRadio.setSelected(true); // make the male radio button set by default
		
		// set up gender radios
		genderGroup.add(maleRadio); // must add the radio buttons to our group
		genderGroup.add(femaleRadio);
		
		// Set up Tax ID
		taxLabel.setEnabled(false); 
		taxField.setEnabled(false);
		
		citizenCheck.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {	
				boolean isTicked = citizenCheck.isSelected(); 
				taxLabel.setEnabled(isTicked);
				taxField.setEnabled(isTicked);
			}
			
		});
		
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
		DefaultComboBoxModel empModel = new DefaultComboBoxModel(); 
		empModel.addElement("employed");
		empModel.addElement("self-employed");
		empModel.addElement("unemployed");
		empCombo.setModel(empModel);
		empCombo.setSelectedIndex(0);
		empCombo.setEditable(true); 
		
		okBtn = new JButton("OK");

		okBtn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				String name = nameField.getText();
				String occupation = occupationField.getText();
				AgeCategory ageCat = (AgeCategory) ageList.getSelectedValue(); 
				String empCat = (String)empCombo.getSelectedItem();
				String taxId = taxField.getText();					
				boolean usCitizen = citizenCheck.isSelected();		
				
				String gender = genderGroup.getSelection().getActionCommand(); // returns male/female on the button group
																	
				
				System.out.println(empCat); 

				FormEvent ev = new FormEvent(this, name, occupation, 
						ageCat.getId(), empCat, taxId, usCitizen, gender); // pass in gender to our constructor of FormEvent.java 
																
				if (formListener != null) {
					formListener.formEventOccurred(ev);
				}
			}

		});

		Border innerBorder = BorderFactory.createTitledBorder("Add Person");
		Border outerBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
		setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));
		
		layoutComponents(); 

	}
	
	public void layoutComponents() { 
		setLayout(new GridBagLayout());

		GridBagConstraints gc = new GridBagConstraints();

		// ----------------- First Row ---------------------------
		
		gc.gridy = 0; 
		
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
		gc.gridy++; 
		
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
		gc.weighty = 0.2;
		
		gc.gridx = 0;
		gc.insets = new Insets(0, 0, 0, 5);
		gc.anchor = GridBagConstraints.FIRST_LINE_END;
		add(new JLabel("US Citizen: "), gc);
		
		gc.gridx = 1;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		gc.insets = new Insets(0, 0, 0, 0);
		add(citizenCheck, gc); 
		
		// ----------------- Next Row --------------------------- 
		gc.gridy++;												
																
		gc.weightx = 1;											
		gc.weighty = 0.2;										
																
		gc.gridx = 0;
		gc.insets = new Insets(0, 0, 0, 5);
		gc.anchor = GridBagConstraints.FIRST_LINE_END;
		add(taxLabel, gc);
		
		gc.gridx = 1;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		gc.insets = new Insets(0, 0, 0, 0);
		add(taxField, gc); 
		
		// ----------------- Next Row --------------------------- // Add our male radio button to GUI
		gc.gridy++;												
																
		gc.weightx = 1;											
		gc.weighty = 0.05;										
																
		gc.gridx = 0;
		gc.insets = new Insets(0, 0, 0, 5);
		gc.anchor = GridBagConstraints.LINE_END;
		add(new JLabel("Gender: "), gc);
		
		gc.gridx = 1;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		gc.insets = new Insets(0, 0, 0, 0);
		add(maleRadio, gc); 
		
		// ----------------- Next Row --------------------------- // Add female radio button to GUI (delete Gender label)
		gc.gridy++;												
																
		gc.weightx = 1;											
		gc.weighty = 0.2;										
																
		
		gc.gridx = 1;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		gc.insets = new Insets(0, 0, 0, 0);
		add(femaleRadio, gc); 

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

class AgeCategory { 
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