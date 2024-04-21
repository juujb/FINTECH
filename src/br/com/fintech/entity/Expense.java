package br.com.fintech.entity;

import java.time.OffsetDateTime;

public class Expense extends Transference {
	private int installments = 1;
	private boolean paidStatus = false;
	private OffsetDateTime dueDate;
	
	public Expense(double value, boolean fixed, String description, int installments, OffsetDateTime dueDate) {
		super(value, description, fixed);
		this.setInstallments(installments);
		this.setDueDate(dueDate);
	}
	
	public boolean getPaidStatus() {
		return paidStatus;
	}
	
	public void setPaidStatus(boolean paidStatus) {
		this.paidStatus = paidStatus;
	}

	public int getInstallments() {
		return installments;
	}

	public void setInstallments(int installments) {
		this.installments = installments;
	}

	public OffsetDateTime getDueDate() {
		return dueDate;
	}

	public void setDueDate(OffsetDateTime dueDate) {
		this.dueDate = dueDate;
	}
}
