import java.awt.BorderLayout;

import javax.swing.JFrame;

public class MainFrame extends JFrame {

	
	// class variables
	private TextPanel textPanel; 
	private Toolbar toolbar; 
	private FormPanel formPanel; // new class variable for our new class
	
	
	// Constructor
	public MainFrame() {
		super("Hello World");

		
		setLayout(new BorderLayout());
		
		toolbar = new Toolbar(); 
		
		textPanel = new TextPanel(); 
		
		formPanel = new FormPanel(); // instantiate new class 

		toolbar.setStringListener(new StringListener() { 

			public void textEmitted(String text) {
				textPanel.appendText(text); 
			}	
			
			
		}); 
		
		// layout manager determines the size of
		// newly added component. You can get the preferred size
		// by calling Dimension getPreferredSize() (as we did in FormPanel.java)
		add(formPanel, BorderLayout.WEST); // add it to the left hand side
		add(toolbar, BorderLayout.NORTH); 
		add(textPanel, BorderLayout.CENTER); 

		setSize(600, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}
