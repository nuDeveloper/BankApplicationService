package bank.application.bankapplication.dto;

import java.util.Date;

public class StatementByPhoneResponseDto {

	private String transactionId;
	private String phoneNumber;
	private Date timeStamp;
	private int amount;
	private String transactionType;

	public StatementByPhoneResponseDto() {}

	public StatementByPhoneResponseDto(String transactionId, String phoneNumber, Date timeStamp, int amount, String transactionType) {
		this.transactionId = transactionId;
		this.phoneNumber = phoneNumber;
		this.timeStamp = timeStamp;
		this.amount = amount;
		this.transactionType = transactionType;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
	

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Date getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

}
