import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
/*
 * This here is bad design because you want your components to know as little about
 * each other. Below, the toolbar is explicitally linked with TextPanel.
 * In other words, the Toolbar is tightly "coupled" with the TextPanel (not reusuable)
 * You want your communication in your controller (ie MainFrame) because it will make debugging
 * a bit easier. In this example, there is communication that is going on where the text panel
 * and tool bar are communicating directly
 */

public class Toolbar extends JPanel implements ActionListener { // implement a Java Interface
	// class variables
	private JButton helloButton;
	private JButton goodbyeButton;
	private TextPanel textPanel;
	
	// constructor
	public Toolbar() {
		helloButton = new JButton("Hello");
		goodbyeButton = new JButton("Goodbye");
		
		helloButton.addActionListener(this); // calls actionListener interface
		goodbyeButton.addActionListener(this);
		
		setLayout(new FlowLayout(FlowLayout.LEFT));
		
		add(helloButton);
		add(goodbyeButton);
	}
	
	public void setTextPanel(TextPanel textPanel) { // a custom method
		this.textPanel = textPanel;
	}

	@Override
	public void actionPerformed(ActionEvent e) { // interface listener links communications
		JButton clicked = (JButton)e.getSource();
		
		if(clicked == helloButton) {
			textPanel.appendText("Hello\n");
			
			// System.out.println("Hello"); // test with sysout
		} else if (clicked == goodbyeButton) {
			textPanel.appendText("GoodBye\n");
			// System.out.println("GoodBye"); // test with sysout
		}
		
		//System.out.println("A button has been clicked"); // an initial test to ensure buttons been clicked with sysout
		
	}
}
