import java.util.EventObject;

public class FormEvent extends EventObject {
	// Class Variables
	private String name;
	private String occupation;
	private int ageCategory;
	private String empCat;
	private String taxID; // new instance var in this temp data store class
	private boolean usCitizen; // new instance var

	// Constructors
	public FormEvent(Object source) {
		super(source);
	}

	public FormEvent(Object source, String name, String occupation, int ageCat, 
			String empCat, String taxID, boolean usCitizen) { // modify constructor to accept new params
		super(source);

		this.name = name;
		this.occupation = occupation;
		this.ageCategory = ageCat;
		this.empCat = empCat;
		this.taxID = taxID; // assign to private class vars above
		this.usCitizen = usCitizen; // assign to private class vars above
	}

	public String getTaxID() { // generate getters with Eclipse short cut
		return taxID;
	}

	public boolean isUsCitizen() { // generate getters with Eclipse short cut
		return usCitizen;
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

	public String getEmploymentCategory() {
		return empCat;
	}

	// Class Methods
}
