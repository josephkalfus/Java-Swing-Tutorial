import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


public class TextPanel extends JPanel {
	
	// class variables
	private JTextArea textArea;
	
	// constructor
	public TextPanel() {
		textArea = new JTextArea();
		
		setLayout(new BorderLayout());
		
		add(new JScrollPane(textArea), BorderLayout.CENTER); 
	}
	
	
	// Custom method for our custom TextPanel class
	public void appendText(String text) {

		textArea.append(text);
	}
}
