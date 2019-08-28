import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

// JPanel is like a grey canvas that you can 
// add other components to
public class TextPanel extends JPanel {
	
	// class variables
	private JTextArea textArea;
	
	// constructor
	public TextPanel() {
		textArea = new JTextArea();
		
		// set layout of textpanel
		setLayout(new BorderLayout());
		
		
		// takes up entire area of panel with scroll bars when filled up with text
		add(new JScrollPane(textArea), BorderLayout.CENTER); 
	}
	
	
	// Custom method for our custom TextPanel class
	public void appendText(String text) {
		// this links back to the class variables textArea declared above
		textArea.append(text);
	}
}
