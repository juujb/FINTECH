package br.com.fintech.dao.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
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
//				connection.close();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
	}
	
	public List<Expense> getAll() {
		// TODO
		PreparedStatement stmt = null;
		var placeHolder = new ArrayList<Expense>();
		
		
		try {
			String query = "SELECT * FROM T_DESPESA";
			stmt = connection.prepareStatement(query);
			ResultSet rst = stmt.executeQuery();
			
			
			
			while(rst.next()) {
//				int CD_DESPESA = rst.getInt(1);
				int CD_CARTEIRA = rst.getInt(2);
//				int CD_USUARIO = rst.getInt(3);
				String DS_DESPESA = rst.getString(4);
				String VL_DESPESA = rst.getString(5);
//				int NR_PARCELAS = rst.getInt(6);
//				String DT_CRIACAO = rst.getString(7);
//				String DT_EFETIVACAO = rst.getString(8);
				String DT_VENCIMENTO = rst.getString(9);
				String ST_FIXA = rst.getString(10);
				String ST_PAGA = rst.getString(11);
	
				try {
					SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
				    Date parsedDate = dateFormat.parse(DT_VENCIMENTO);
				    Timestamp timestamp = new java.sql.Timestamp(parsedDate.getTime());
				    
					Expense expense = new Expense(Double.parseDouble(VL_DESPESA), "1".equals(ST_FIXA), DS_DESPESA, CD_CARTEIRA,timestamp.toInstant().atOffset( ZoneOffset.UTC ));
					expense.setPaidStatus("1".equals(ST_PAGA));
					placeHolder.add(expense);
				} catch(Exception e) {}
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}finally {
			try {
				stmt.close();
//				connection.close();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
	
		
		return placeHolder;
	
	}
}
