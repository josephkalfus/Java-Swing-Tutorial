import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;


// Basically, we divided into two different files / objects
public class MainFrame extends JFrame {
	// instance variables should be private so we can access later w/ setters getters
	private JTextArea textArea;
	private JButton btn;
	
	
	// Constructor
	public MainFrame() {
		super("Hello World");
		
		// set appropriate layout mangager Google "visual guide layout swing"
		// will experiment w/ border layout (most complex) allows to add components
		// with east, west etc
		
		setLayout(new BorderLayout());
		
		textArea = new JTextArea();
		btn = new JButton("Click Me!");
		
		// Pass in control (textarea/button) and then where it should go in layout manager
		add(textArea, BorderLayout.CENTER); 
		add(btn, BorderLayout.SOUTH);
		
		setSize(600, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}
