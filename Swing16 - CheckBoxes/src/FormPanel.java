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
import javax.swing.JCheckBox;
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
	private JComboBox empCombo;  
	private JCheckBox citizenCheck; // our new checkbox
	private JTextField taxField; // if checkbox is checked, enter tax ID
	private JLabel taxLabel; // just a label placeholder

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
		citizenCheck = new JCheckBox(); // instantiate our new instance vars
		taxField = new JTextField(10); // text field is 10 wide
		taxLabel = new JLabel("Tax ID: "); // instantiate our label place holder
		
		// Set up Tax ID
		taxLabel.setEnabled(false); // disable by default
		taxField.setEnabled(false);
		
		citizenCheck.addActionListener(new ActionListener() { // this will be invoked if
			public void actionPerformed(ActionEvent e) {	// cizenbox check is ticked/unticked
				boolean isTicked = citizenCheck.isSelected(); // returns T/F and stores in local var
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
				String taxId = taxField.getText();					// make new vars that reference instance
				boolean usCitizen = citizenCheck.isSelected();		// variables above and pass them into
																	// the FormEvent class's constructor below
				
				System.out.println(empCat); 

				FormEvent ev = new FormEvent(this, name, occupation, 
						ageCat.getId(), empCat, taxId, usCitizen); // pass in new vars created above which will 
																// then be passed in the constructor in FormEvent.javaG
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
		
		// ----------------- Next Row --------------------------- // just copy and paste from above
		gc.gridy++;												// and change add/label method
																// to add our US Citizen checkbox
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
		
		// ----------------- Next Row --------------------------- // same thing, copy/paste from above
		gc.gridy++;												// and modify as needed. This will display
																// Tax ID text field, and will be greyed out
		gc.weightx = 1;											// at first, until you checkmark US citizen
		gc.weighty = 0.2;										// see above code comments in constructor's
																// anon class/actionListener
		gc.gridx = 0;
		gc.insets = new Insets(0, 0, 0, 5);
		gc.anchor = GridBagConstraints.FIRST_LINE_END;
		add(taxLabel, gc);
		
		gc.gridx = 1;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		gc.insets = new Insets(0, 0, 0, 0);
		add(taxField, gc); 

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