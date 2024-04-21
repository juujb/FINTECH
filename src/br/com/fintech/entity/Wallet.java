package br.com.fintech.entity;

public class Wallet extends AuditableDocument {
    private String name;
    private String financialInstitution;
    private String description;
    
    public Wallet(String name, String financialInstituition, String description) {
    	super();
    	this.setName(name);
    	this.setFinancialInstitution(financialInstituition);
    	this.setDescription(description);
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFinancialInstitution() {
		return financialInstitution;
	}

	public void setFinancialInstitution(String financialInstitution) {
		this.financialInstitution = financialInstitution;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}