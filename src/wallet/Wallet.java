package wallet;

import java.util.List;

public class Wallet {
    public String name;
    public String financialInstitution;
    public String description;
    private List<Expense> expenseList;
    private List<Revenue> revenueList;
    
    public Wallet(String name, String financialInstituition, String description) {
    	this.name = name;
    	this.financialInstitution = financialInstituition;
    	this.description = description;
    }
    
    public void addExpense(Expense expense) {
    	expenseList.add(expense);
    }
    
    public void addIncome(Revenue revenue) {
    	revenueList.add(revenue);
    }

    public static void main(String[] args) {
        Wallet minhaCarteira = new Wallet("Conta", "FIAP", "Carteira estudantil");

        System.out.println("Nome da carteira: " + minhaCarteira.name);
        System.out.println("Instituição financeira: " + minhaCarteira.financialInstitution);
        System.out.println("Descrição: " + minhaCarteira.description);
    }

}