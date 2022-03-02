package bank.application.bankapplication.dto;

import java.util.Date;

public class TransactionByPhoneResponseDto {

	private String transactionId;
	private String payerPhoneNumber;
	private String payeePhoneNumber;
	private int amount;
	private Date timeStamp;
	private String comment;
	private String status;
	
	public TransactionByPhoneResponseDto() {		
	}
	
	public TransactionByPhoneResponseDto(String transactionId, String payerPhoneNumber, String payeePhoneNumber, int amount,
			Date timeStamp, String comment, String status) {
		this.transactionId = transactionId;
		this.payerPhoneNumber = payerPhoneNumber;
		this.payeePhoneNumber = payeePhoneNumber;
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
	public String getPayerPhoneNumber() {
		return payerPhoneNumber;
	}
	public void setPayerPhoneNumber(String payerPhoneNumber) {
		this.payerPhoneNumber = payerPhoneNumber;
	}
	public String getPayeePhoneNumber() {
		return payeePhoneNumber;
	}
	public void setPayeePhoneNumber(String payeePhoneNumber) {
		this.payeePhoneNumber = payeePhoneNumber;
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
