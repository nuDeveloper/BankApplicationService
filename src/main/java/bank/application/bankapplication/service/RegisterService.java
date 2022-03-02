package bank.application.bankapplication.service;

import java.util.Random;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bank.application.bankapplication.dto.CustomerDto;
import bank.application.bankapplication.entity.Account;
import bank.application.bankapplication.entity.Customer;
import bank.application.bankapplication.repository.AccountRepository;

@Service
public class RegisterService {

	@Autowired
	AccountRepository accountRepository;

	public int register(CustomerDto customerDto) {
		Customer customer = new Customer();
		BeanUtils.copyProperties(customerDto, customer);
		Account account = new Account(new Random().nextInt(900000) + 100000, 10000);
		account.setCustomer(customer);
		accountRepository.save(account);
		return account.getAccountNumber();
	}

}
