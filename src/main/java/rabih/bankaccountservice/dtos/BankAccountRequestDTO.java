package rabih.bankaccountservice.dtos;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import rabih.bankaccountservice.enums.AccountType;

import java.sql.Date;

@Data
@NoArgsConstructor @AllArgsConstructor @Builder
public class BankAccountDTO {
    private Double balance;
    private String currency;
    private AccountType type;

}