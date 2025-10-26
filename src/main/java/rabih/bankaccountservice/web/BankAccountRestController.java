package rabih.bankaccountservice.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rabih.bankaccountservice.dtos.BankAccountRequestDTO;
import rabih.bankaccountservice.dtos.BankAccountResponseDTO;
import rabih.bankaccountservice.services.BankAccountService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BankAccountRestController {
    @Autowired
    BankAccountService bankAccountService;

    @PostMapping("/bankAccount")
    public BankAccountResponseDTO createBankAccount(@RequestBody BankAccountRequestDTO bankAccountRequestDTO){
        return  bankAccountService.createBankAccount(bankAccountRequestDTO);
    }

    @PutMapping("/bankAccount/{id}")
    public BankAccountResponseDTO updateBankAccount(@PathVariable String id, @RequestBody BankAccountRequestDTO bankAccountRequestDTO){
        return bankAccountService.updateBankAccount(id,bankAccountRequestDTO);
    }

    @GetMapping("/bankAccount/{id}")
    public BankAccountResponseDTO getBankAccount(@PathVariable String id){
        return  bankAccountService.getBankAccount(id);
    }

    @GetMapping("/bankAccount")
    public List<BankAccountResponseDTO> getAllBankAccount(){
        return bankAccountService.getAllBankAccounts();
    }

    @DeleteMapping("/bankAccount/{id}")
    public void deleteBankAccount(@PathVariable String id){
        bankAccountService.deleteBankAccount(id);
    }

}
