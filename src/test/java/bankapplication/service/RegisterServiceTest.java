package bankapplication.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import bank.application.bankapplication.dto.CustomerDto;
import bank.application.bankapplication.repository.AccountRepository;
import bank.application.bankapplication.service.RegisterService;


@ExtendWith(SpringExtension.class)
public class RegisterServiceTest {
	
	@Mock
	AccountRepository accountRepository;
	
	@InjectMocks
	RegisterService registerService;
	
	@Test
	public void testRegister() {
		CustomerDto customerDto = new CustomerDto();
		int account = registerService.register(customerDto);
		assertNotNull(account);
	}	
}
