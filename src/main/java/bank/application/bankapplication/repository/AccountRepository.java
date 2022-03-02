package bank.application.bankapplication.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import bank.application.bankapplication.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Integer> {

	Optional<Account> findByAccountNumber(int accountNumber);

	@Transactional
	@Modifying
	@Query("update Account a set a.balance= :balance where a.accountNumber=:accountNumber")
	void updateBalance(int accountNumber, int balance);
	
	@Query(value = "SELECT a.account_number FROM Account a WHERE a.customer_id= :customerId", nativeQuery=true)
	Optional<Integer> getAccountNumberFromCustomerId(String customerId);

	@Query(value = "SELECT a.customer_id FROM Account a WHERE a.account_number= :accountNumber", nativeQuery=true)
	Optional<String> getPhoneNumberFromAccountNumber(int accountNumber);
}
