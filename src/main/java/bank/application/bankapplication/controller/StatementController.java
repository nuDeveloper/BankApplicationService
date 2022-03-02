package bank.application.bankapplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import bank.application.bankapplication.dto.StatementByPhoneResponseDto;
import bank.application.bankapplication.dto.StatementResponseDto;
import bank.application.bankapplication.service.StatementService;

@RestController
@RequestMapping("/bankapplication")
public class StatementController {
	
	@Autowired
	StatementService statementService;

	@GetMapping("/statementbyaccount")
	public List<StatementResponseDto> getStatement(@RequestParam(value = "accountNumber") int accountNumber,
			@RequestParam(value = "month") String month, @RequestParam(value = "year") int year) {
		return statementService.getStatement(accountNumber, month, year);
	}
	
	@GetMapping("/statementbyphone")
	public List<StatementByPhoneResponseDto> getStatementByPhone(@RequestParam(value = "phoneNumber") String phoneNumber){
		return statementService.getStatementByPhone(phoneNumber);
	}
}
