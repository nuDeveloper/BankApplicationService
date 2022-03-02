package bank.application.bankapplication.dto;

import java.util.Date;

public class TransactionRequestDto {

	private int payerAccountNumber;
	private int payeeAccountNumber;
	private int amount;
	private String comment;

	public TransactionRequestDto() {
	}

	public TransactionRequestDto(String transactionId, int payerAccountNumber, int payeeAccountNumber, int amount,
			Date timeStamp, String comment) {
		this.payerAccountNumber = payerAccountNumber;
		this.payeeAccountNumber = payeeAccountNumber;
		this.amount = amount;
		this.comment = comment;
	}

	public int getPayerAccountNumber() {
		return payerAccountNumber;
	}

	public void setPayerAccountNumber(int payerAccountNumber) {
		this.payerAccountNumber = payerAccountNumber;
	}

	public int getPayeeAccountNumber() {
		return payeeAccountNumber;
	}

	public void setPayeeAccountNumber(int payeeAccountNumber) {
		this.payeeAccountNumber = payeeAccountNumber;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	/*
	 * public Date getTimeStamp() { return timeStamp; }
	 * 
	 * public void setTimeStamp(Date timeStamp) { this.timeStamp = timeStamp; }
	 */

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
}
