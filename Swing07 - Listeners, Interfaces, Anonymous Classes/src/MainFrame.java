import java.awt.BorderLayout;

import javax.swing.JFrame;
/*
 * STEP-BY-STEP when designing and implementing listeners, anon classes:
 * Must seperate components in J compoenets.
 * You want all communication to go through controller (MainFrame.java)
 * You do NOT want GUI components talking to each other directly
 * 
 * Step01 - Code a simple interface (ie StringListener.java) and have a public method
 * like textEmitted. This means that anything that includes the interface
 * MUST have the methods declared in the interface become coded into the class
 * which includes that interface
 * 
 * Step02 - Within your J Component GUI class (Toolbar.java), you make a private class
 * variable of Type Interface that you just created in previous step (StringListener interface)
 * 
 * Step03 - Now within your J Component GUI class (Toolbar.java) you need to make a method (doesn't
 * matter the name) and pass in the parameters of Type Interface into it. Within the method,
 * you will reference the private class variable in the previous step (this.textListener = 
 * method parameter variable) 
 * 
 * Step04 - Within your controller (MainFrame.java) now you can reference your J component variable
 * and call the method you made in the previous step and make an anon class within your Controller.
 * Your IDE will complain because you need to "add unimplemented methods" because thats what the
 * interface is for (textEmitted()). 
 * 
 * Step05 - Within your view (Toolbar.java) you just do a nested if statement first checking
 * if the JComponent was clicked, and the inner if to ensure that textListener != null then pass
 * in a String into your View's class variable and using your interface method like so with some
 * pseudoCode:
 * -----
 * IF (J_Component clicked) THEN // must be implemented for all J component buttons to work properly
 * if (view_instance_var != null) THEN
 * view_instance_var.interface_method("Some Random String") // which will output to textPanel if interface is implemented
 * -----
 * 
 * Step06 - Go back into your controller (MainFrame.java) and within your anon class in a previous step,
 * you must actually implement your interface (remember the "add unimplemented methods" part?). So in that,
 * you put your J Component variable in there, and call the method where the output will be. So within the anon
 * class it would be something like:
 * -----
 * textPanel.appendText(text);
 * ----
 * 
 */

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

		
		// This creates an "anonymous class" which doesn't have a class
		// name and is sort of like a "one time use" class. So instead of
		// subclassing a class already made (which inherits a bunch of junk)
		// you may not need, just do a anon class
		// Usually it's used in INTERFACES
		// You can also use it to override methods declared in the NEW instance
		// of class but it's really not the parent class
		// You can not instantiate an anon class tho
		toolbar.setStringListener(new StringListener() { // use our new interface but must IMPLEMENT our interface methods here

			public void textEmitted(String text) {
				textPanel.appendText(text); // this outputs to our textpanel the "hello" and "goodbye"
				//System.out.println(text); // sysout implementation of our method that is declared in our new interface
			}	
			
			
		}); // this anon class "listens" within our "MainFrame" CONTROLLER only
		
		add(toolbar, BorderLayout.NORTH); 
		add(textPanel, BorderLayout.CENTER); 

		setSize(600, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}
