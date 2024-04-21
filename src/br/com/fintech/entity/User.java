package br.com.fintech.entity;

public class User extends AuditableDocument {
    private String name; 
    private String email;
    private String phoneNumber;
    private String cpf;

    public User (String name, String email, String phoneNumber, String cpf) {
    	super();
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.cpf = cpf;
    }
    
    void editarEmail(String email) {
        this.email = email;
    }

    void editarTelefone(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getCpf() {
        return cpf;
    }

}
