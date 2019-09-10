import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MainFrame extends JFrame {

	
	// class variables
	private TextPanel textPanel; 
	private Toolbar toolbar; 
	private FormPanel formPanel; 
	
	
	// Constructor
	public MainFrame() {
		super("Hello World");

		
		setLayout(new BorderLayout());
		
		toolbar = new Toolbar(); 
		
		textPanel = new TextPanel(); 
		
		formPanel = new FormPanel(); 
		
		setJMenuBar(createMenuBar()); 

		toolbar.setStringListener(new StringListener() { 

			public void textEmitted(String text) {
				textPanel.appendText(text); 
			}	
			
			
		}); 
		
		formPanel.setFormListener(new FormListener() {  
			public void formEventOccurred(FormEvent e) {
				String name = e.getName();
				
				String occupation = e.getOccupation();
				int ageCat = e.getAgeCategory(); 
				String empCat = e.getEmploymentCategory(); 
				
				textPanel.appendText(name + ": " + occupation + ": " + ageCat
						+ ", " + empCat + "\n"); 
				
				System.out.println(e.getGender()); 
			}
		});
		

		add(formPanel, BorderLayout.WEST);
		add(toolbar, BorderLayout.NORTH); 
		add(textPanel, BorderLayout.CENTER); 

		setSize(600, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	private JMenuBar createMenuBar() { 
		JMenuBar menuBar = new JMenuBar();
		
		JMenu fileMenu = new JMenu("File"); 
		JMenuItem exportDataItem = new JMenuItem("Export Data..."); 
		JMenuItem importDataItem = new JMenuItem("Import Data..."); 
		JMenuItem exitItem = new JMenuItem("Exit"); 
		
		fileMenu.add(exportDataItem); 
		fileMenu.add(importDataItem);
		fileMenu.addSeparator(); 
		fileMenu.add(exitItem);
		
		JMenu windowMenu = new JMenu("Window"); 
		JMenu showMenu = new JMenu("Show"); 
		JCheckBoxMenuItem showFormItem = new JCheckBoxMenuItem("Person Form"); // Adds a "checkbox" to this menu item
		showFormItem.setSelected(true); // defaults to tru
		
		showMenu.add(showFormItem); 
		windowMenu.add(showMenu);
		
		menuBar.add(fileMenu); 
		menuBar.add(windowMenu);
		
		showFormItem.addActionListener(new ActionListener() { // add action listener

			public void actionPerformed(ActionEvent ev) {
				JCheckBoxMenuItem menuItem = (JCheckBoxMenuItem)ev.getSource(); // cast your "event" ev as the class of what you're listening to
																				// as in Class varName (ie JCheckBoxMenuItem showFormItem)
				formPanel.setVisible(menuItem.isSelected()); // now you can show/hide your formPanel created in this class's instance vars based
															// on if menuItem is selected
			}
			
		});
		
		return menuBar;
	}
}
