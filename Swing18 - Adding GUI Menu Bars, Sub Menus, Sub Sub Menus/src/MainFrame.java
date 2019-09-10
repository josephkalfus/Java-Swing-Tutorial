import java.awt.BorderLayout;

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
		
		setJMenuBar(createMenuBar()); // STEP 2: call your new method written below

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
	
	private JMenuBar createMenuBar() { // STEP 1- Add in your menubar method to your Controller
		JMenuBar menuBar = new JMenuBar();
		
		JMenu fileMenu = new JMenu("File"); // create your various "menus" TOP LEVEL
		JMenuItem exportDataItem = new JMenuItem("Export Data..."); // New "menu" items SUB LEVEL
		JMenuItem importDataItem = new JMenuItem("Import Data..."); // Note the text naming convention w/ capitaliztion and elipse...
		JMenuItem exitItem = new JMenuItem("Exit"); 
		
		fileMenu.add(exportDataItem); // Add above vars to actual GUI
		fileMenu.add(importDataItem);
		fileMenu.addSeparator(); // that thin line seperator which seperates the various categories of menus
		fileMenu.add(exitItem);
		
		JMenu windowMenu = new JMenu("Window"); // Another TOP LEVEL menu
		JMenu showMenu = new JMenu("Show"); // A SUB LEVEL menu located within the "Window" menu ie Window > Show
		JMenuItem showFormItem = new JMenuItem("Person Form"); // A SUB SUB LEVEL menu ie Window > Show > Person Form
		
		showMenu.add(showFormItem); // Add to GUI
		windowMenu.add(showMenu);
		
		menuBar.add(fileMenu); // add your various menus to the GUI (TOP LEVEL) last
		menuBar.add(windowMenu);
		
		return menuBar;
	}
}
