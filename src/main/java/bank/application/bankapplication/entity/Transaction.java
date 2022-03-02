package bank.application.bankapplication.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Transaction {

	@Id
	private String transactionId;
	private int payerAccountNumber;
	private int payeeAccountNumber;
	private int amount;
	private Date timeStamp;
	private String comment;

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

}
