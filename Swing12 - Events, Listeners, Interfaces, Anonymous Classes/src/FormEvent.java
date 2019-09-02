import java.util.EventObject;

public class FormEvent extends EventObject { // EventObject is superclass to see which event fired
	// Class Variables
	private String name; // store this info temporarly and relay to mainframe
	private String occupation;
	
	// Constructors
	public FormEvent(Object source) {
		super(source);
	}
	
	public FormEvent(Object source, String name, String occupation) {
		super(source);
		
		this.name = name;
		this.occupation = occupation;
	}

	
	// Getters Setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	
	
	// Class Methods
}
