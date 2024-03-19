package wallet;

class Expense extends Transference {
	public int installments = 1;
	private boolean paid = false;
	public String dueDate;
	
	public Expense(double value, boolean fixed, String description, int installments, String dueDate) {
		super(value, description, fixed);
		this.installments = installments;
		this.dueDate = dueDate;
	}
	
	public boolean getPaid() {
		return paid;
	}
	
	public void pay() {
		paid = true;
		validateOperation();
	}

}
