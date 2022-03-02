package bank.application.bankapplication.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bank.application.bankapplication.dto.CustomerDto;
import bank.application.bankapplication.service.RegisterService;

@RestController
@RequestMapping("/bankapplication")
public class RegisterController {

	@Autowired
	Environment environment;
	
	@Autowired
	RegisterService registerService;

	@PostMapping("/register")
	public int register(@Valid @RequestBody CustomerDto customerDto) {
		return registerService.register(customerDto);
	}

	@GetMapping("/port")
	public String getPort() {
		return "Bank application running on : "+environment.getProperty("local.server.port");
	}
}
