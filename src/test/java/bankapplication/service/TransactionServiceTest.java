package bankapplication.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.event.annotation.BeforeTestMethod;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import bank.application.bankapplication.dto.TransactionByPhoneRequestDto;
import bank.application.bankapplication.dto.TransactionByPhoneResponseDto;
import bank.application.bankapplication.dto.TransactionRequestDto;
import bank.application.bankapplication.dto.TransactionResponseDto;
import bank.application.bankapplication.entity.Account;
import bank.application.bankapplication.repository.AccountRepository;
import bank.application.bankapplication.repository.TransactionRepository;
import bank.application.bankapplication.service.TransactionService;

@ExtendWith(SpringExtension.class)
public class TransactionServiceTest {

	@InjectMocks
	TransactionService transactionService;

	@Mock
	AccountRepository accountRepository;

	@Mock
	TransactionRepository transactionRepository;

	private TransactionByPhoneRequestDto transactionByPhoneRequestDto = new TransactionByPhoneRequestDto();
	private String payerPhoneNumber = "9998880000";
	private String payeePhoneNumber = "9998881111";

	@BeforeEach
	public void initializer() {
		transactionByPhoneRequestDto.setPayerPhoneNumber(payeePhoneNumber);
		transactionByPhoneRequestDto.setPayeePhoneNumber(payeePhoneNumber);
		transactionByPhoneRequestDto.setAmount(1200);
		transactionByPhoneRequestDto.setComment("transfer 1200");
	}

	@Test
	public void testTransactionByPhone() {

		Mockito.when(accountRepository.getAccountNumberFromCustomerId(payerPhoneNumber))
				.thenReturn(Optional.of(347856));
		Mockito.when(accountRepository.getAccountNumberFromCustomerId(payeePhoneNumber))
				.thenReturn(Optional.of(123490));

		TransactionByPhoneResponseDto transactionByPhoneResponseDto = transactionService
				.transactionByPhone(transactionByPhoneRequestDto);
		assertNotNull(transactionByPhoneResponseDto);
	}

	@Test
	public void testTransaction() {

		TransactionRequestDto transactionRequestDto = new TransactionRequestDto();
		Mockito.when(accountRepository.findByAccountNumber(000000)).thenReturn(Optional.of(new Account()));

		TransactionResponseDto transactionResponseDto = transactionService.transaction(transactionRequestDto);
		assertNotNull(transactionResponseDto);
	}
}
