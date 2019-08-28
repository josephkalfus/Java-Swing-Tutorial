import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;


// MainFrame, you can add all sorts of "components" and then morph into
// a model view controller (MVC) paradigm
public class MainFrame extends JFrame {

	
	
	private TextPanel textPanel; // This references the new TextPanel.java class we just created
	private JButton btn;
	
	
	// Constructor
	public MainFrame() {
		super("Hello World");

		
		setLayout(new BorderLayout());
		
		textPanel = new TextPanel(); // invoke constructor of our newly created TextPanel Class 
		btn = new JButton("Click Me!");
		
		btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				textPanel.appendText("Hello\n"); // this is our custom method in TextPanel.java class
				
			}
			
		});
		

		add(textPanel, BorderLayout.CENTER); // change this to now reference the new TextPanel variable
		add(btn, BorderLayout.SOUTH);
		
		setSize(600, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}
