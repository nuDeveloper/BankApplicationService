package bank.application.bankapplication.dto;

import java.util.Date;

public class TransactionResponseDto {

	private String transactionId;
	private int payerAccountNumber;
	private int payeeAccountNumber;
	private int amount;
	private Date timeStamp;
	private String comment;
	private String status;

	public TransactionResponseDto() {
	}

	public TransactionResponseDto(String transactionId, int payerAccountNumber, int payeeAccountNumber, int amount,
			Date timeStamp, String comment, String status) {
		this.transactionId = transactionId;
		this.payerAccountNumber = payerAccountNumber;
		this.payeeAccountNumber = payeeAccountNumber;
		this.amount = amount;
		this.timeStamp = timeStamp;
		this.comment = comment;
		this.status = status;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
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

	public Date getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
