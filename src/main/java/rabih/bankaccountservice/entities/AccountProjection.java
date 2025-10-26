package rabih.bankaccountservice.entities;

import org.springframework.data.rest.core.config.Projection;
import rabih.bankaccountservice.enums.AccountType;

@Projection(types = BankAccount.class , name = "P1")
public interface AccountProjection {
    public String getId();
    public Double getBalance();
    public AccountType getType();
}
