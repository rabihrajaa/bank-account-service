package rabih.bankaccountservice.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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

}
