package br.com.fintech.test;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

import br.com.fintech.entity.Expense;
import br.com.fintech.entity.Revenue;

public class WalletTest {
	private static Instant instant;
	private static ZoneOffset zoneOffset = ZoneOffset.of("-03:00");
			
	public static void main(String[] args) {
		System.out.println("DESPESA:");
		
		OffsetDateTime dueDate = OffsetDateTime.ofInstant(instant, zoneOffset);
		Expense expense = new Expense(10.50, true, "DESPESA FINTECH", 1, dueDate);
		
		System.out.println("O código dessa depesa é: " + expense.getCode());
		System.out.println("Valor: R$" + expense.getValue());
		System.out.println("Data de Criação: " + expense.getCreatedDate());
		System.out.println("Descrição: " + expense.getDescription());
		System.out.println("Data de Efetivação: " + expense.getEfetivationDate());
		System.out.println("Despesa Fixa: " + (expense.isFixed() ? "SIM" : "NÃO"));
		
		System.out.println("Parcelas: " + expense.getInstallments());
		System.out.println("Paga: " + (expense.getPaidStatus() ? "SIM" : "NÃO"));
		System.out.println("Data de Vencimento: " + expense.getDueDate());
		
		System.out.println();
		System.out.println("Informações após realizar pagamento:");
		System.out.println();
		
		expense.setPaidStatus(true);
		System.out.println("Paga: " + (expense.getPaidStatus() ? "SIM" : "NÃO"));
		System.out.println("Data de Efetivação: " + expense.getEfetivationDate());
		
		System.out.println();
		System.out.println("RECEITA:");
		
		Revenue revenue = new Revenue(5000.00, "Salário FINTECH", true, "Salário");
		
		System.out.println("O código dessa receita é: " + revenue.getCode());
		System.out.println("Valor: R$" + revenue.getValue());
		System.out.println("Data de Criação: " + revenue.getCreatedDate());
		System.out.println("Descrição: " + revenue.getDescription());
		System.out.println("Data de Efetivação: " + revenue.getEfetivationDate());
		System.out.println("Receita Fixa: " + (revenue.isFixed() ? "SIM" : "NÃO"));
		
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
