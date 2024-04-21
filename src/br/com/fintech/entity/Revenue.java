package br.com.fintech.entity;

public class Revenue extends Transference {
	private String typeOfEntry;

	public Revenue(double value, String description, boolean fixed, String typeOfEntry) {
        super(value, description, fixed);
        this.setTypeOfEntry(typeOfEntry);
    }
 
	public String getTypeOfEntry() {
		return typeOfEntry;
	}
	
	public void setTypeOfEntry(String typeOfEntry) {
		this.typeOfEntry = typeOfEntry;
	}
}