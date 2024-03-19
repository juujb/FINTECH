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
	
	public Transference(double value, String description, boolean fixed) {
		this.value = value;
		this.description = description;
		this.fixed = fixed;
	}
	
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
	
}
