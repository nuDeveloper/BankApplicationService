package bankapplication.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import bank.application.bankapplication.dto.StatementByPhoneResponseDto;
import bank.application.bankapplication.dto.StatementResponseDto;
import bank.application.bankapplication.entity.Transaction;
import bank.application.bankapplication.repository.AccountRepository;
import bank.application.bankapplication.repository.TransactionRepository;
import bank.application.bankapplication.service.StatementService;

@ExtendWith(SpringExtension.class)
public class StatementServiceTest {

	@InjectMocks
	StatementService statementService;

	@Mock
	AccountRepository accountRepository;

	@Mock
	TransactionRepository transactionRepository;

	List<Transaction> transactions = new ArrayList<Transaction>();

	@BeforeEach
	public void initializer() {
		Transaction transaction = new Transaction();
		transaction.setTransactionId("344tvy394tc29t");
		transaction.setPayerAccountNumber(564389);
		transaction.setPayeeAccountNumber(526042);
		transaction.setTimeStamp(new Date());
		transaction.setAmount(120);
		transaction.setComment("test");
		transactions.add(transaction);
	}

	@Test
	public void testGetStatement() {

		int accountNumber = 564389;
		String month = "feb";
		int year = 1991;

		Mockito.when(transactionRepository.getMonthlyTransaction(accountNumber, month, year)).thenReturn(transactions);

		List<StatementResponseDto> statementResponseDtos = statementService.getStatement(accountNumber, month, year);
		assertNotNull(statementResponseDtos);
	}

	@Test
	public void testGetStatementByPhone() {

		String phoneNumber = "9998881111";

		Mockito.when(accountRepository.getAccountNumberFromCustomerId(phoneNumber)).thenReturn(Optional.of(526042));
		Mockito.when(transactionRepository.findByPayerAccountNumberOrPayeeAccountNumber(526042, 526042))
				.thenReturn(transactions);
		Mockito.when(accountRepository.getPhoneNumberFromAccountNumber(564389)).thenReturn(Optional.of("9998884567"));

		List<StatementByPhoneResponseDto> statementList = statementService.getStatementByPhone(phoneNumber);

		assertNotNull(statementList);
	}

}
