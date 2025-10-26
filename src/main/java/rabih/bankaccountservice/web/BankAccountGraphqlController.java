package rabih.bankaccountservice.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import rabih.bankaccountservice.dtos.BankAccountRequestDTO;
import rabih.bankaccountservice.dtos.BankAccountResponseDTO;
import rabih.bankaccountservice.services.BankAccountService;

import java.util.List;

@Controller
public class BankAccountGraphqlController {
    @Autowired
    BankAccountService bankAccountService;

    @QueryMapping
    public List<BankAccountResponseDTO> getAllBankAccount(){
        return bankAccountService.getAllBankAccounts();
    }

    @MutationMapping
    public BankAccountResponseDTO createBankAccount(@Argument BankAccountRequestDTO bank){
        return  bankAccountService.createBankAccount(bank);
    }

    @MutationMapping
    public BankAccountResponseDTO updateBankAccount(@Argument String id, @Argument BankAccountRequestDTO bank){
        return bankAccountService.updateBankAccount(id,bank);
    }

    @QueryMapping
    public BankAccountResponseDTO getBankAccount(@Argument String id){
        return  bankAccountService.getBankAccount(id);
    }

    @MutationMapping
    public void deleteBankAccount(@Argument String id){
        bankAccountService.deleteBankAccount(id);
    }

}
