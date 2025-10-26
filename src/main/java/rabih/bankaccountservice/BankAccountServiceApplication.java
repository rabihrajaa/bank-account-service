package rabih.bankaccountservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import rabih.bankaccountservice.entities.BankAccount;
import rabih.bankaccountservice.entities.Customer;
import rabih.bankaccountservice.enums.AccountType;
import rabih.bankaccountservice.repositories.BankAccountRepository;
import rabih.bankaccountservice.repositories.CustomerRepository;

import java.util.UUID;
import java.util.stream.Stream;

@SpringBootApplication
public class BankAccountServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BankAccountServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(BankAccountRepository bankAccountRepository, CustomerRepository customerRepository) {
        return args -> {

            // Ajouter des clients
            Stream.of("RABIH", "RAJAA", "SOUKAINA", "MARWA").forEach(name -> {
                Customer customer = Customer.builder()
                        .name(name)
                        .build();
                customerRepository.save(customer);
            });

            // Ajouter des comptes bancaires pour chaque client
            customerRepository.findAll().forEach(cust -> {
                for (int i = 0; i < 3; i++) {
                    BankAccount bankAccount = BankAccount.builder()
                            .id(UUID.randomUUID().toString())
                            .balance(Math.random() * 9000)
                            .currency("MAD")
                            .type(Math.random() > 0.5 ? AccountType.CURRENT_ACCOUNT : AccountType.SAVINGS_ACCOUNT)
                            .customer(cust)
                            .build();

                    bankAccountRepository.save(bankAccount);
                }
            });

            System.out.println("✅ Données initialisées avec succès !");
        };
    }
}
