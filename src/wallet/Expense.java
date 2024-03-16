package wallet;

import java.time.LocalDateTime;

class Expense extends Transference {
	public int installments = 1;
	private boolean paid = false;
	public String dueDate;
	
	public Expense edit(Expense expense) {
		installments = expense.installments;
		dueDate =  expense.dueDate == null || expense.dueDate.isBlank() ?  dueDate : expense.dueDate;
		value = expense.value;
		fixed = expense.fixed;
		description = expense.description == null || expense.description.isEmpty() ?  description : expense.description;
		
		return this;
	}
	
	public boolean getPaid() {
		return paid;
	}
	
	public void pay() {
		paid = true;
		validateOperation();
	}
	

	public static void main(String[] args) {
		Expense expense = new Expense();
		expense.value = 10.50;  
		expense.description = "DESPESA FINTECH";
		
		expense.dueDate = LocalDateTime.now().plusDays(15).toLocalDate().toString();
		
		System.out.println("O código dessa depesa é: " + expense.getCode());
		System.out.println("Valor: R$" + expense.value);
		System.out.println("Data de Criação: " + expense.getCreatedDate());
		System.out.println("Descrição: " + expense.description);
		System.out.println("Data de Efetivação: " + expense.getEfetivationDate());
		System.out.println("Despesa Fixa: " + (expense.fixed ? "SIM" : "NÃO"));
		
		System.out.println("Parcelas: " + expense.installments);
		System.out.println("Paga: " + (expense.paid ? "SIM" : "NÃO"));
		System.out.println("Data de Vencimento: " + expense.dueDate);
		
		Expense newExpense = new Expense();
		newExpense.value = 31.00;
		newExpense.installments = 2;

		
		expense.edit(newExpense);
		
		System.out.println();
		System.out.println("Informações após realizar edição:");
		System.out.println();
		
		System.out.println("O código dessa depesa é: " + expense.getCode());
		System.out.println("Valor: R$" + expense.value);
		System.out.println("Data de Criação: " + expense.getCreatedDate());
		System.out.println("Descrição: " + expense.description);
		System.out.println("Data de Efetivação: " + expense.getEfetivationDate());
		System.out.println("Despesa Fixa: " + (expense.fixed ? "SIM" : "NÃO"));
		
		System.out.println("Parcelas: " + expense.installments);
		System.out.println("Paga: " + (expense.paid ? "SIM" : "NÃO"));
		System.out.println("Data de Vencimento: " + expense.dueDate);
		
		System.out.println();
		System.out.println("Informações após realizar pagamento:");
		System.out.println();
		
		expense.pay();
		System.out.println("Paga: " + (expense.paid ? "SIM" : "NÃO"));
		System.out.println("Data de Efetivação: " + expense.getEfetivationDate());
	}
}
