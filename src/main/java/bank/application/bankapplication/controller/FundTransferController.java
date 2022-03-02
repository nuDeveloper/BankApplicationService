package bank.application.bankapplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bank.application.bankapplication.dto.TransactionByPhoneRequestDto;
import bank.application.bankapplication.dto.TransactionByPhoneResponseDto;
import bank.application.bankapplication.dto.TransactionRequestDto;
import bank.application.bankapplication.dto.TransactionResponseDto;
import bank.application.bankapplication.service.TransactionService;

@RestController
@RequestMapping("/bankapplication")
public class FundTransferController {
	
	@Autowired
	TransactionService transactionService;

	@PostMapping("/fundtransferbyaccount")
	public TransactionResponseDto transaction(@RequestBody TransactionRequestDto transactionRequestDto) {
		return transactionService.transaction(transactionRequestDto);
	}

	@PostMapping("/fundtransferbyphone")
	public TransactionByPhoneResponseDto transactionByPhone(
			@RequestBody TransactionByPhoneRequestDto transactionByPhoneRequestDto) {
		return transactionService.transactionByPhone(transactionByPhoneRequestDto);
	}
}
