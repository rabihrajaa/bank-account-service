package rabih.bankaccountservice.services;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rabih.bankaccountservice.dtos.BankAccountRequestDTO;
import rabih.bankaccountservice.dtos.BankAccountResponseDTO;
import rabih.bankaccountservice.entities.BankAccount;
import rabih.bankaccountservice.mappers.BankAccoutMapper;
import rabih.bankaccountservice.repositories.BankAccountRepository;
import rabih.bankaccountservice.repositories.CustomerRepository;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
public class BankAccountServiceImpl implements  BankAccountService {

    @Autowired
    BankAccoutMapper bankAccoutMapper;

    @Autowired
    BankAccountRepository bankAccountRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public BankAccountResponseDTO createBankAccount(BankAccountRequestDTO bankAccountRequestDTO) {
        BankAccount bankAccount=bankAccoutMapper.toRequestENTITY(bankAccountRequestDTO);
        bankAccount.setId(UUID.randomUUID().toString());
        bankAccount.setCustomer(customerRepository.save(bankAccount.getCustomer()));
        return bankAccoutMapper.toResponseDTO(bankAccountRepository.save(bankAccount));
    }

    @Override
    public BankAccountResponseDTO updateBankAccount(String id,BankAccountRequestDTO bankAccountRequestDTO) {
        BankAccount bankAccount=bankAccountRepository.findById(id).get();
        if (bankAccountRequestDTO.getBalance() != null ) bankAccount.setBalance(bankAccountRequestDTO.getBalance());
        if (bankAccountRequestDTO.getType() != null ) bankAccount.setType(bankAccountRequestDTO.getType());
        if (bankAccountRequestDTO.getCurrency() != null ) bankAccount.setCurrency(bankAccountRequestDTO.getCurrency());
        if (bankAccountRequestDTO.getCustomerdto().getName() != null ) bankAccount.getCustomer().setName(bankAccountRequestDTO.getCustomerdto().getName());
        customerRepository.save(bankAccount.getCustomer());
        BankAccountResponseDTO bankAccountResponseDTO = bankAccoutMapper.toResponseDTO(bankAccountRepository.save(bankAccount));

        return bankAccountResponseDTO;
    }

    @Override
    public BankAccountResponseDTO getBankAccount(String idBankAccount) {
        return bankAccoutMapper.toResponseDTO(bankAccountRepository.findById(idBankAccount).get());
    }

    @Override
    public List<BankAccountResponseDTO> getAllBankAccounts() {
        return bankAccountRepository.findAll() // Récupère toutes les entités
                .stream() // Crée un flux (Stream<BankAccount>)
                .map(bankAccount -> bankAccoutMapper.toResponseDTO(bankAccount)) // Transforme chaque entité en DTO
                .collect(Collectors.toList()); // Collecte le résultat dans une liste
    }


    @Override
    public void deleteBankAccount(String idBankAccount) {
        bankAccountRepository.deleteById(idBankAccount);
    }

}
