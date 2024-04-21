package br.com.fintech.factory;

import br.com.fintech.dao.implementation.ExpenseDao;

public abstract class DaoFactory {

	public static ExpenseDao getExpenseDao() {
		return new ExpenseDao();
	}

}
