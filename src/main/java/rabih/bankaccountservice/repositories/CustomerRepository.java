package rabih.bankaccountservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import rabih.bankaccountservice.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {}
