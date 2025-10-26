package rabih.bankaccountservice.services;

import rabih.bankaccountservice.dtos.BankAccountRequestDTO;
import rabih.bankaccountservice.dtos.BankAccountResponseDTO;
import rabih.bankaccountservice.entities.BankAccount;

import java.util.List;

public interface BankAccountService {
    public BankAccountResponseDTO createBankAccount(BankAccountRequestDTO bankAccountRequestDTO);
    public BankAccountResponseDTO updateBankAccount(String id,BankAccountRequestDTO bankAccountRequestDTO);
    public  BankAccountResponseDTO getBankAccount(String idBankAccount);
    public List<BankAccountResponseDTO> getAllBankAccounts();
    public void deleteBankAccount(String idBankAccount);
}
