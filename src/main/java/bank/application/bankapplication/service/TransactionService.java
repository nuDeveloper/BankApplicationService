package bank.application.bankapplication.service;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bank.application.bankapplication.dto.TransactionByPhoneRequestDto;
import bank.application.bankapplication.dto.TransactionByPhoneResponseDto;
import bank.application.bankapplication.dto.TransactionRequestDto;
import bank.application.bankapplication.dto.TransactionResponseDto;
import bank.application.bankapplication.entity.Account;
import bank.application.bankapplication.entity.Transaction;
import bank.application.bankapplication.repository.AccountRepository;
import bank.application.bankapplication.repository.TransactionRepository;

@Service
public class TransactionService {

	@Autowired
	AccountRepository accountRepository;

	@Autowired
	TransactionRepository transactionRepository;

	public TransactionResponseDto transaction(TransactionRequestDto transactionRequestDto) {
		Transaction transaction = new Transaction();
		BeanUtils.copyProperties(transactionRequestDto, transaction);
		String status = null;

		TransactionResponseDto transactionResponseDto = new TransactionResponseDto();
		BeanUtils.copyProperties(transaction, transactionResponseDto);

		Optional<Account> payerAccount = accountRepository.findByAccountNumber(transaction.getPayerAccountNumber());
		Optional<Account> payeeAccount = accountRepository.findByAccountNumber(transaction.getPayeeAccountNumber());

		if (payerAccount.isPresent() && payeeAccount.isPresent()) {
			int payerBalance = payerAccount.get().getBalance();
			if (payerBalance >= transaction.getAmount()) {
				int payeeBalance = payeeAccount.get().getBalance();
				int finalPayeeBalance = payeeBalance + transaction.getAmount();
				accountRepository.updateBalance(transaction.getPayeeAccountNumber(), finalPayeeBalance);
				int finalPayerBalance = payerBalance - transaction.getAmount();
				accountRepository.updateBalance(transaction.getPayerAccountNumber(), finalPayerBalance);
				transaction.setTransactionId(new Date().toString().replaceAll("[^a-zA-Z0-9]", "").toUpperCase());
				transaction.setTimeStamp(new Date());
				transactionRepository.save(transaction);
				BeanUtils.copyProperties(transaction, transactionResponseDto);
				status = "Amount " + transaction.getAmount() + " successfully transfered from account "
						+ transaction.getPayerAccountNumber() + " to account " + transaction.getPayeeAccountNumber();
			} else {
				status = "Insufficient amount";
				transactionResponseDto.setTimeStamp(new Date());
			}
		} else {
			if (payerAccount.isEmpty() && payeeAccount.isEmpty()) {
				status = "Invalid payer and payee account";
			} else if (payerAccount.isEmpty()) {
				status = "Invalid payer account";
			} else if (payeeAccount.isEmpty()) {
				status = "Invalid payee account";
			}
			transactionResponseDto.setTimeStamp(new Date());
			transactionResponseDto.setTransactionId(new Date().toString().replaceAll("[^a-zA-Z0-9]", "").toUpperCase());
		}
		transactionResponseDto.setStatus(status);
		return transactionResponseDto;
	}

	public TransactionByPhoneResponseDto transactionByPhone(TransactionByPhoneRequestDto transactionByPhoneRequestDto) {

		TransactionRequestDto transactionRequestDto = new TransactionRequestDto();
		BeanUtils.copyProperties(transactionByPhoneRequestDto, transactionRequestDto);

		int payerAccountNumber = accountRepository
				.getAccountNumberFromCustomerId(transactionByPhoneRequestDto.getPayerPhoneNumber()).get();
		int payeeAccountNumber = accountRepository
				.getAccountNumberFromCustomerId(transactionByPhoneRequestDto.getPayeePhoneNumber()).get();

		transactionRequestDto.setPayerAccountNumber(payerAccountNumber);
		transactionRequestDto.setPayeeAccountNumber(payeeAccountNumber);

		TransactionResponseDto transactionResponseDto = transaction(transactionRequestDto);

		TransactionByPhoneResponseDto transactionByPhoneResponseDto = new TransactionByPhoneResponseDto();

		BeanUtils.copyProperties(transactionResponseDto, transactionByPhoneResponseDto);

		transactionByPhoneResponseDto.setPayerPhoneNumber(transactionByPhoneRequestDto.getPayerPhoneNumber());
		transactionByPhoneResponseDto.setPayeePhoneNumber(transactionByPhoneRequestDto.getPayeePhoneNumber());

		return transactionByPhoneResponseDto;
	}

}
