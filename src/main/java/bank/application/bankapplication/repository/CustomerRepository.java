package bank.application.bankapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import bank.application.bankapplication.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, String>{

}
