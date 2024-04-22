package br.com.fintech.entity;

public class Investment extends Transference {
	private String investmentType;
	
	public Investment(double value, String description, boolean fixed, String investmentType) {
		super(value, description, fixed);
		this.setInvestmentType(investmentType);
	}

	public String getInvestmentType() {
		return investmentType;
	}

	public void setInvestmentType(String investmentType) {
		this.investmentType = investmentType;
	}
}
