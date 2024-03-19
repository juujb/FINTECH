package user;

import wallet.Wallet;

public class User {
    private Wallet wallet = null;
    private String name; 
    private String email;
    private String phoneNumber;
    private String cpf;

    public User (String name, String email, String phoneNumber, String cpf) {
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
    
    public void addWallet(Wallet wallet) {
    	if (wallet != null)
    		this.wallet = wallet;
    }
    
    public Wallet getWallet() {
    	return wallet;
    }
    
    public static void main (String[]args) {
        User user = new User("jose", "jose123@gmail.com", "11966690909", "44077743505");

        user.editarEmail("jose123@hotmail.com");
        user.editarTelefone("11966690808");
    }

}
