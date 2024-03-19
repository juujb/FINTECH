package wallet;

import java.time.LocalDateTime;

public class Test {
	public static void main(String[] args) {
		System.out.println("DESPESA:");
		
		String dueDate = LocalDateTime.now().plusDays(15).toLocalDate().toString();
		Expense expense = new Expense(10.50, true, "DESPESA FINTECH", 1, dueDate);
		
		System.out.println("O código dessa depesa é: " + expense.getCode());
		System.out.println("Valor: R$" + expense.value);
		System.out.println("Data de Criação: " + expense.getCreatedDate());
		System.out.println("Descrição: " + expense.description);
		System.out.println("Data de Efetivação: " + expense.getEfetivationDate());
		System.out.println("Despesa Fixa: " + (expense.fixed ? "SIM" : "NÃO"));
		
		System.out.println("Parcelas: " + expense.installments);
		System.out.println("Paga: " + (expense.getPaid() ? "SIM" : "NÃO"));
		System.out.println("Data de Vencimento: " + expense.dueDate);
		
		System.out.println();
		System.out.println("Informações após realizar pagamento:");
		System.out.println();
		
		expense.pay();
		System.out.println("Paga: " + (expense.getPaid() ? "SIM" : "NÃO"));
		System.out.println("Data de Efetivação: " + expense.getEfetivationDate());
		
		System.out.println();
		System.out.println("RECEITA:");
		
		Revenue revenue = new Revenue(5000.00, "Salário FINTECH", true, "Salário");
		
		System.out.println("O código dessa receita é: " + revenue.getCode());
		System.out.println("Valor: R$" + revenue.value);
		System.out.println("Data de Criação: " + revenue.getCreatedDate());
		System.out.println("Descrição: " + revenue.description);
		System.out.println("Data de Efetivação: " + revenue.getEfetivationDate());
		System.out.println("Receita Fixa: " + (revenue.fixed ? "SIM" : "NÃO"));
		
		System.out.println("Tipo dessa receita é: " + revenue.getTypeOfEntry());
		
		System.out.println();
		System.out.println("Após editar tipo de receita:");
		System.out.println();
		
		revenue.setTypeOfEntry("Aluguel");
		
		System.out.println("Tipo dessa receita é: " + revenue.getTypeOfEntry());
		
		System.out.println();
		System.out.println("Informações após receita ser efetivada:");
		System.out.println();
		
		revenue.validateOperation();
		System.out.println("Data de Efetivação: " + revenue.getEfetivationDate());
	}
}
