package bank.application.bankapplication.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bank.application.bankapplication.dto.StatementByPhoneResponseDto;
import bank.application.bankapplication.dto.StatementResponseDto;
import bank.application.bankapplication.entity.Transaction;
import bank.application.bankapplication.repository.AccountRepository;
import bank.application.bankapplication.repository.TransactionRepository;


@Service
public class StatementService {
	
	@Autowired
	AccountRepository accountRepository;

	@Autowired
	TransactionRepository transactionRepository;
	
	public List<StatementResponseDto> getStatement(int accountNumber, String month, int year) {
		List<StatementResponseDto> statementResponseList = new ArrayList<StatementResponseDto>();
		List<Transaction> transactionList = transactionRepository.getMonthlyTransaction(accountNumber, month, year);
		for (Transaction transaction : transactionList) {
			StatementResponseDto statementResponseDto = new StatementResponseDto();
			if (transaction.getPayerAccountNumber() == accountNumber) {
				statementResponseDto.setTransactionType("Debited");
				statementResponseDto.setAccountNumber(transaction.getPayeeAccountNumber());
			} else {
				statementResponseDto.setTransactionType("Credited");
				statementResponseDto.setAccountNumber(transaction.getPayerAccountNumber());
			}
			BeanUtils.copyProperties(transaction, statementResponseDto);
			statementResponseList.add(statementResponseDto);
		}

		return statementResponseList;
	}
	
	public List<StatementByPhoneResponseDto> getStatementByPhone(String phoneNumber) {

		int accountNumber = accountRepository.getAccountNumberFromCustomerId(phoneNumber).get();

		List<StatementByPhoneResponseDto> statementByPhoneResponseDtos = new ArrayList<StatementByPhoneResponseDto>();
		List<Transaction> transactionList = transactionRepository.findByPayerAccountNumberOrPayeeAccountNumber(accountNumber, accountNumber);
		
		List<Transaction> lastFivetransactions = transactionList.stream().sorted(Comparator.comparing(Transaction::getTimeStamp).reversed()).limit(5).collect(Collectors.toList());
		
		for (Transaction transaction : lastFivetransactions) {
			StatementByPhoneResponseDto statementByPhoneResponseDto = new StatementByPhoneResponseDto();
			if (transaction.getPayerAccountNumber() == accountNumber) {
				statementByPhoneResponseDto.setTransactionType("Debited");
				statementByPhoneResponseDto.setPhoneNumber(accountRepository.getPhoneNumberFromAccountNumber(transaction.getPayeeAccountNumber()).get());
			} else {
				statementByPhoneResponseDto.setTransactionType("Credited");
				statementByPhoneResponseDto.setPhoneNumber(accountRepository.getPhoneNumberFromAccountNumber(transaction.getPayerAccountNumber()).get());
			}
			BeanUtils.copyProperties(transaction, statementByPhoneResponseDto);
			statementByPhoneResponseDtos.add(statementByPhoneResponseDto);
		}
		return statementByPhoneResponseDtos;
	}


}
