import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
		
		// create a "new" ActionListener anonymous class
		// ActionListener is an interface
		// You must add "unimplemented methods" that the interface provides
		// The method actionPerformed is run whenever the button is clicked
		// So we are "listening" to the button (btn) and then performing
		// whatever is inside actionPerformed method within the anon class
		btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				textArea.append("Hello\n");
				
			}
			
		});
		
		// Pass in control (textarea/button) and then where it should go in layout manager
		add(textArea, BorderLayout.CENTER); 
		add(btn, BorderLayout.SOUTH);
		
		setSize(600, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}
