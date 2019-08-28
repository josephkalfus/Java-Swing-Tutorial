import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Toolbar extends JPanel {
	// class variables
	private JButton helloButton;
	private JButton goodbyeButton;
	
	// constructor
	public Toolbar() {
		helloButton = new JButton("Hello");
		goodbyeButton = new JButton("Goodbye");
		
		// use "FlowLayout" for toolbar to add from left to right (unlike borderLayout)
		// and align it to start on the LEFT
		setLayout(new FlowLayout(FlowLayout.LEFT));
		
		// add our buttons (declared in the class variables above) to our FlowLayout
		add(helloButton);
		add(goodbyeButton);
	}
}
