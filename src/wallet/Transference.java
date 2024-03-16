package wallet;

import java.time.LocalDateTime;
import java.util.UUID;

class Transference {
	private String code = UUID.randomUUID().toString();
	public double value;
	private String createdDate = LocalDateTime.now().toLocalDate().toString();
	private String efetivationDate;
	public boolean fixed = false;
	public String description;
	
	public String getEfetivationDate() {
		return efetivationDate;
	}
	
	public void validateOperation() {
		if (efetivationDate == null || efetivationDate.isBlank())
			efetivationDate = LocalDateTime.now().toLocalDate().toString();
	}

	public String getCode() {
		return code;
	}
	
	public String getCreatedDate() {
		return createdDate;
	}
	
	public static void main(String[] args) {
		Transference transference = new Transference();
		transference.value = 1000.50;  
		transference.description = "FINTECH";
		
		System.out.println("O código dessa transferencia é: " + transference.getCode());
		System.out.println("Valor: R$" + transference.value);
		System.out.println("Data de Criação: " + transference.getCreatedDate());
		System.out.println("Descrição: " + transference.description);
		System.out.println("Fixa por padrão: " + (transference.fixed ? "SIM" : "NÃO"));
		System.out.println("Data de Efetivação: " + transference.getEfetivationDate());
		
		transference.validateOperation();
		System.out.println("Data de Efetivação após validar operação: " + transference.getEfetivationDate());
		
		transference.fixed = true;
		System.out.println("Fixa após alteração: " + (transference.fixed ? "SIM" : "NÃO"));
	}
}
