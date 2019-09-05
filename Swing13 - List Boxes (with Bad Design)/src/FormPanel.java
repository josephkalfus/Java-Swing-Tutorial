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
	private JList ageList; // For our new dropdown

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

		// For our new dropdown, as a "Model" and output our "data" below in the list
		// box
		DefaultListModel ageModel = new DefaultListModel(); // BAD DESIGN: To use Strings instead of IDs below
		ageModel.addElement("Under 18");					// BAD DESIGN: To have the view mingle with the logic (controller's job)
		ageModel.addElement("18 to 65");
		ageModel.addElement("65 or over");
		ageList.setModel(ageModel); // now we need to tell the listbox to use this model
		
		ageList.setPreferredSize(new Dimension(110, 66)); // set dimensions of your listbox
		ageList.setBorder(BorderFactory.createEtchedBorder()); // set border of your listbox
		ageList.setSelectedIndex(1); // Set default highlighted/selected option

		okBtn = new JButton("OK");

		okBtn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				String name = nameField.getText();
				String occupation = occupationField.getText();
				String ageCat = (String) ageList.getSelectedValue(); // to grab the value of our listbox (must typcast from Object to String)
				
				System.out.println(ageCat); // Just for TESTING PURPOSES

				FormEvent ev = new FormEvent(this, name, occupation);

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
		add(ageList, gc); // we add the "list" to the third row of our GUI

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
