import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;


public class Toolbar extends JPanel implements ActionListener { 
	// class variables
	private JButton helloButton;
	private JButton goodbyeButton;
	private StringListener textListener; // Use our newly created interface but will need a method for SETTING this listener
	
	// constructor
	public Toolbar() {
		helloButton = new JButton("Hello");
		goodbyeButton = new JButton("Goodbye");
		
		helloButton.addActionListener(this);
		goodbyeButton.addActionListener(this);
		
		setLayout(new FlowLayout(FlowLayout.LEFT));
		
		add(helloButton);
		add(goodbyeButton);
	}
	
	public void setStringListener(StringListener listener) { // implementing our newly created interface of type "StringListener"
		this.textListener = listener;
	}

	@Override
	public void actionPerformed(ActionEvent e) { 
		JButton clicked = (JButton)e.getSource();
		
		if(clicked == helloButton) {
			if(textListener != null) { // calls our method with our interface but implemented in MainFrame (controller)
				textListener.textEmitted("Hello\n");
			}
		} else if (clicked == goodbyeButton) {
			if(textListener != null) { // calls our method with our interface but implemented in MainFrame (controller)
				textListener.textEmitted("GoodBye\n");
			}
		}
		
	}
}
