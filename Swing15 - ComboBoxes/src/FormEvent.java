import java.util.EventObject;

public class FormEvent extends EventObject { 
	// Class Variables
	private String name; 
	private String occupation;
	private int ageCategory; 
	private String empCat; // new class variable in this temp data store
	
	// Constructors
	public FormEvent(Object source) {
		super(source);
	}
	
	public FormEvent(Object source, String name, String occupation, int ageCat, String empCat) { // pass in new private var
		super(source);
		
		this.name = name;
		this.occupation = occupation;
		this.ageCategory = ageCat; 
		this.empCat = empCat;
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
	
	public String getEmploymentCategory() { // standard new getter for our new class instance variable above
		return empCat;
	}

	
	
	// Class Methods
}
