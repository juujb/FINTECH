package br.com.fintech.test;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

import br.com.fintech.dao.implementation.ExpenseDao;
import br.com.fintech.entity.Expense;
import br.com.fintech.factory.DaoFactory;

public class DaoTest {
	private static Instant instant;
	private static ZoneOffset zoneOffset = ZoneOffset.of("-3:00");
	
	public static void main(String[] args) {
		System.out.println("DESPESA:");
		
		ExpenseDao expenseDao = DaoFactory.getExpenseDao();
		
		OffsetDateTime dueDate = OffsetDateTime.ofInstant(instant, zoneOffset);
		Expense newExpense = new Expense(10.50, true, "DESPESA FINTECH", 1, dueDate);
		
		expenseDao.insert(newExpense);
	}
}
