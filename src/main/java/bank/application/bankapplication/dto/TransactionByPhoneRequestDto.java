package bank.application.bankapplication.dto;

import java.util.Date;

public class TransactionByPhoneRequestDto {

	private String payerPhoneNumber;
	private String payeePhoneNumber;
	private int amount;
	private String comment;

	public TransactionByPhoneRequestDto() {
	}

	public TransactionByPhoneRequestDto(String payerPhoneNumber, String payeePhoneNumber, int amount, String comment) {
		this.payerPhoneNumber = payerPhoneNumber;
		this.payeePhoneNumber = payeePhoneNumber;
		this.amount = amount;
		this.comment = comment;
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

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
}
