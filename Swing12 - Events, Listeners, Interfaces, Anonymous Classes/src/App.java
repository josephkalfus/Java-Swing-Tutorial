import javax.swing.SwingUtilities;

public class App {

	public static void main(String[] args) {

		SwingUtilities.invokeLater(new Runnable() {

			public void run() {

				new MainFrame();

			}

		});

	}

}

// Video Start Time 1hr:31:07 to 1hr:51:55

/*
 * BLUF: You want your controller to route communications (MainFrame.java).
 * MainFrame creates all the main components (Toolbar, TextPanel, FormPanel). In
 * this example, we will fill out form in FormPanel, and that info will get
 * routed to MainFrame, which will decide what to to w/ info and then output
 * into TextPanel.
 * 
 * STEP01- You need to respond to when a button is clicked (not when text fields
 * are entered). Add actionListener to button w/in FormPanel.java. Add a anon
 * class and add "unimplemented methods"
 * 
 * STEP02- Now you need to somehow pass the actionListener method info
 * (occupaiton, name) to MainFrame. Don't pass directly, but instead raise an
 * event that MainFrame will listen to.
 * 
 * STEP03- Create new class (FormEvent.java) that extends EventObject (which is
 * an overkill Swing parent class) and add the constructor to listen to the
 * "source" (ie the button in FormPanel). Add a few private class variables
 * (name, occupation). This is just a class to temporarly store this info.
 * 
 * STEP04- Generate default getters/setters for our new class (FormEvent.java)
 * and a custom constructor to pass in source, name, occupation.
 * 
 * STEP05- now w/in the anon class of our button addActionListener (within
 * FormPanel.java), create *new* instance of our newly created temp class
 * (FormEvent.java) to pass in this, name, occupation.
 * 
 * STEP06- now w/in your controller (MainFrame.java), make up some methods
 * within an anon class on the fly to listen to the formPanel with a made up on
 * the fly interface which you will create in a later step. Some good names to
 * use are "setFormListener". Pass in the event [e.getXXX]. Then within the same
 * anon class, you can talk to the textPanel to output whatever the form has
 * when the button is clicked.
 * 
 * STEP07- Create an interface that you used w/ your made up names w/in your
 * controller (FormListener.java). Copy and paste the method signature w/in you
 * Controller to be pasted into your new interface. Make it extend EventListener
 * (used by action listener).
 * 
 * STEP08- Now create private variable w/in your view (FormPanel.java) which is
 * of type interface (FormListener.java). Now make a new method w/in your view
 * (FormPanel.java) to setFormListener.
 * 
 * STEP09- Now w/in your view (FormPanel.java), you need to add w/in your anon
 * class for the btn, if (formListener != null) then call one method within the
 * interface (FormListener.java) and pass in the event
 * 
 * 
 */
