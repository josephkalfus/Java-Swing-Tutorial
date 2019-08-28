import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

// MainFrame is acting as a "controller" in a MVC design
// and is hooking the components up and telling them what to 
// do
public class MainFrame extends JFrame {

	
	// class variables
	private TextPanel textPanel; 
	private Toolbar toolbar; 
	
	
	// Constructor
	public MainFrame() {
		super("Hello World");

		
		setLayout(new BorderLayout());
		
		toolbar = new Toolbar(); 
		
		textPanel = new TextPanel(); 

		

		toolbar.setTextPanel(textPanel); // passes to TextPanel class a custom method w/in the class
		
		add(toolbar, BorderLayout.NORTH); 
		add(textPanel, BorderLayout.CENTER); 

		setSize(600, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}
