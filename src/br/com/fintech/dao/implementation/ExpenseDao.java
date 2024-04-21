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
	
	private final Connection connection;
	private final String TABLE_NAME;
	private Instant instant;
	private final ZoneOffset zoneOffset;
	
	public ExpenseDao() {
		super();
        connection = OracleConnectionManager.getInstance().getConnection();
        TABLE_NAME = "DESPESA";
        zoneOffset = ZoneOffset.of("-03:00");
    }

	public void insert(Expense expense) {
		PreparedStatement stmt = null;
		
		try {
			String query = String.format("INSERT INTO T_%s (CODIGO_DESPESA, VALOR, PARCELAS, PAGA, DATA_DE_CRIACAO, DATA_DE_VENCIMENTO, DATA_DE_EFETIVACAO, FIXA, DESCRICAO) VALUES (SQ_%s, ?, ?, ?, ?, ?, ?, ?, ?)", TABLE_NAME, TABLE_NAME);
			stmt = connection.prepareStatement(query);
			
			stmt.setDouble(1, expense.getValue());
			stmt.setInt(2, expense.getInstallments());
			stmt.setBoolean(3, expense.getPaidStatus());
			
			Instant currentDate = java.time.OffsetDateTime.ofInstant(instant , zoneOffset).toInstant();
			java.sql.Date creationDate = new java.sql.Date(currentDate.toEpochMilli());
			stmt.setDate(4, creationDate);
			
			java.sql.Date dueDate = new java.sql.Date(expense.getDueDate().toInstant().toEpochMilli());
			stmt.setDate(5, dueDate);
			
			java.sql.Date efetivationDate = new java.sql.Date(expense.getEfetivationDate().toInstant().toEpochMilli());
			stmt.setDate(6, efetivationDate);
			
			stmt.setBoolean(7, expense.isFixed());
			stmt.setString(8, expense.getDescription());
			
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
