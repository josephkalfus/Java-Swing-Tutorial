import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;


public class MainFrame extends JFrame {

	
	// class variables
	private TextPanel textPanel; 
	private JButton btn;
	private Toolbar toolbar; // a new Type of our new class Toolbar.java
	
	
	// Constructor
	public MainFrame() {
		super("Hello World");

		
		setLayout(new BorderLayout());
		
		toolbar = new Toolbar(); // calls our constructor in our new Toolbar.java class
		
		textPanel = new TextPanel(); 
		btn = new JButton("Click Me!");
		
		btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				textPanel.appendText("Hello\n"); 
				
			}
			
		});
		add(toolbar, BorderLayout.NORTH); // add our toolbar to the top but makes it a small size
		add(textPanel, BorderLayout.CENTER); 
		add(btn, BorderLayout.SOUTH);	
		setSize(600, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}
