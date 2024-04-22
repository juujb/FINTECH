package br.com.fintech.dao.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.Instant;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;

import br.com.fintech.dao.interfaces.GenericDao;
import br.com.fintech.entity.Expense;

public class ExpenseDao implements GenericDao<Expense> {
	
	private Connection connection;
	private final ZoneOffset zoneOffset;
	
	public ExpenseDao() {
		super();
        zoneOffset = ZoneOffset.of("+03:00");
        connection = OracleConnectionManager.getInstance().getConnection();
    }

	public void insert(Expense expense) {
		PreparedStatement stmt = null;
		
		try {
			String query = "INSERT INTO T_DESPESA (CD_DESPESA, CD_CARTEIRA, CD_USUARIO, DS_DESPESA, VL_DESPESA, NR_PARCELAS, DT_CRIACAO, DT_EFETIVACAO, DT_VENCIMENTO, ST_FIXA, ST_PAGA) VALUES (SQ_DESPESA.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			stmt = connection.prepareStatement(query);
			
			stmt.setInt(1, expense.getWalletCode());
			stmt.setInt(2, expense.getUserCode());
			stmt.setString(3, expense.getDescription());
			stmt.setDouble(4, expense.getValue());
			stmt.setInt(5, expense.getInstallments());
			
			Instant currentDate = java.time.OffsetDateTime.now(zoneOffset).toInstant();
			java.sql.Date creationDate = new java.sql.Date(currentDate.toEpochMilli());
			stmt.setDate(6, creationDate);
			
			if (expense.getEfetivationDate() != null) {				
				java.sql.Date efetivationDate = new java.sql.Date(expense.getEfetivationDate().toInstant().toEpochMilli());
				stmt.setDate(7, efetivationDate);
			}
			
			if (expense.getDueDate() != null) {				
				java.sql.Date dueDate = new java.sql.Date(expense.getDueDate().toInstant().toEpochMilli());
				stmt.setDate(8, dueDate);			
			}
			
			stmt.setBoolean(9, expense.isFixed());
			stmt.setBoolean(10, expense.getPaidStatus());
			
			stmt.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			try {
				stmt.close();
				connection.close();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
	}
	
	public List<Expense> getAll() {
		// TODO
		var placeHolder = new ArrayList<Expense>();
		return placeHolder;
	}
}
