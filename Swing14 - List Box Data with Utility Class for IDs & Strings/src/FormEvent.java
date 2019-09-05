import java.util.EventObject;

public class FormEvent extends EventObject { 
	// Class Variables
	private String name; 
	private String occupation;
	private int ageCategory; // new private variable for our temp storage
	
	// Constructors
	public FormEvent(Object source) {
		super(source);
	}
	
	public FormEvent(Object source, String name, String occupation, int ageCat) {
		super(source);
		
		this.name = name;
		this.occupation = occupation;
		this.ageCategory = ageCat; // just assign variable w/in 
									// this constructor to private class var above
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
	
	public int getAgeCategory() {
		return ageCategory;
	}

	
	
	// Class Methods
}
