package br.com.fintech.entity;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;

public class AuditableDocument {
	
	private int code;
	private OffsetDateTime createdDate;
	
	protected ZoneOffset zoneOffset;

	public AuditableDocument() {
		zoneOffset = ZoneOffset.of("-03:00");
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public OffsetDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(OffsetDateTime createdDate) {
		this.createdDate = createdDate;
	}

}
