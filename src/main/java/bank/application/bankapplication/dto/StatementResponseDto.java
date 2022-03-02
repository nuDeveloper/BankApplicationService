package bank.application.bankapplication.dto;

import java.util.Date;

public class StatementResponseDto {

	private String transactionId;
	private int accountNumber;
	private Date timeStamp;
	private int amount;
	private String transactionType;

	public StatementResponseDto() {}

	public StatementResponseDto(String transactionId, int accountNumber, Date timeStamp, int amount, String transactionType) {
		this.transactionId = transactionId;
		this.accountNumber = accountNumber;
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
	

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
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
