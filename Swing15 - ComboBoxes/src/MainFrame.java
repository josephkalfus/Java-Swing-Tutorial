import java.awt.BorderLayout;

import javax.swing.JFrame;

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
				String empCat = e.getEmploymentCategory(); // use getter in FormEvent.java
				
				textPanel.appendText(name + ": " + occupation + ": " + ageCat
						+ ", " + empCat + "\n"); 
			}
		});
		

		add(formPanel, BorderLayout.WEST);
		add(toolbar, BorderLayout.NORTH); 
		add(textPanel, BorderLayout.CENTER); 

		setSize(600, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}
