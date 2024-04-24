package br.com.fintech.test;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;

import br.com.fintech.dao.implementation.ExpenseDao;
import br.com.fintech.entity.Expense;
import br.com.fintech.factory.DaoFactory;

public class DaoTest {
	private static ZoneOffset zoneOffset = ZoneOffset.of("-03:00");
	
	public static void main(String[] args) {
		System.out.println("DESPESA:");
		
		ExpenseDao expenseDao = DaoFactory.getExpenseDao();
		
		OffsetDateTime dateNow = OffsetDateTime.now(zoneOffset);
		Expense newExpense = new Expense(700.00, false, "DESPESA FINTECH 3", 3, dateNow);
		newExpense.validateOperation();
		newExpense.setUserCode(1);
		newExpense.setWalletCode(1);
		
		// expenseDao.insert(newExpense);
		
		var expenseList = expenseDao.getAll();		
		
		//	expenseList.forEach(null);

		System.out.println(expenseList.get(1).getDescription());
	}
}
