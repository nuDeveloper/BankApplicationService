package bank.application.bankapplication.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import bank.application.bankapplication.entity.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {

	@Query(value = "from Transaction where monthname(timeStamp) like %:month% and year(timeStamp) = :year and (payerAccountNumber = :accountNumber or payeeAccountNumber = :accountNumber)")
	List<Transaction> getMonthlyTransaction(int accountNumber, String month, int year);
	
	List<Transaction> findByPayerAccountNumberOrPayeeAccountNumber(int payerAccountNumber, int payeeAccountNumber);
}
