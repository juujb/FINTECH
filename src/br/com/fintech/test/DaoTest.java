package br.com.fintech.test;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;

import br.com.fintech.dao.implementation.ExpenseDao;
import br.com.fintech.entity.Expense;
import br.com.fintech.factory.DaoFactory;

public class DaoTest {
	private static ZoneOffset zoneOffset = ZoneOffset.of("-03:00");
	
	public static void main(String[] args) {		
		ExpenseDao expenseDao = DaoFactory.getExpenseDao();
		
		OffsetDateTime dateNow = OffsetDateTime.now(zoneOffset);

		Expense newExpense1 = new Expense(
				1,
				1,
				100.00,
				"Despesa FINTECH 1",
				true,
				true,
				dateNow,
				1,
				dateNow
		);
		
		Expense newExpense2 = new Expense(
				1,
				1,
				200.00,
				"Despesa FINTECH 2",
				true,
				false,
				dateNow,
				2,
				dateNow
		);
		
		Expense newExpense3 = new Expense(
				2,
				1,
				300.00,
				"Despesa FINTECH 3",
				false,
				false,
				dateNow,
				2,
				dateNow
		);
		
		Expense newExpense4 = new Expense(
				2,
				1,
				400.00,
				"Despesa FINTECH 4",
				false,
				true,
				dateNow,
				2,
				dateNow
		);
		
		Expense newExpense5 = new Expense(
				1,
				1,
				500.00,
				"Despesa FINTECH 5",
				true,
				false,
				dateNow,
				2,
				dateNow
		);
		
		expenseDao.insert(newExpense1);
		expenseDao.insert(newExpense2);
		expenseDao.insert(newExpense3);
		expenseDao.insert(newExpense4);
		expenseDao.insert(newExpense5);
		
		var expenseList = expenseDao.getAll();		
			
		for (int i = 0; i < expenseList.size(); i++) {
			  Expense expense = expenseList.get(i);
			  
			  System.out.println("DESPESA:");
			  
			  System.out.println();
			  
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
		}

	}
}
