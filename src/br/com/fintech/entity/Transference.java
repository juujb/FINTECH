package br.com.fintech.entity;

import java.time.OffsetDateTime;

class Transference extends AuditableDocument {
	private double value;
	private OffsetDateTime efetivationDate;
	private boolean fixed = false;
	private String description;
	
	public Transference(double value, String description, boolean fixed) {
		super();
		this.setValue(value);
		this.setDescription(description);
		this.setFixed(fixed);
	}
	
	public OffsetDateTime getEfetivationDate() {
		return efetivationDate;
	}
	
	public void validateOperation() {
		if (efetivationDate == null)
			efetivationDate = OffsetDateTime.ofInstant(instant, zoneOffset);
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public boolean isFixed() {
		return fixed;
	}

	public void setFixed(boolean fixed) {
		this.fixed = fixed;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
