package rabih.bankaccountservice.mappers;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import rabih.bankaccountservice.dtos.BankAccountRequestDTO;
import rabih.bankaccountservice.dtos.BankAccountResponseDTO;
import rabih.bankaccountservice.dtos.CustomerDTO;
import rabih.bankaccountservice.entities.BankAccount;
import rabih.bankaccountservice.entities.Customer;
@Component
public class BankAccoutMapper {
    public BankAccountRequestDTO toRequestDTO(BankAccount bankAccount){
        BankAccountRequestDTO bankAccountDTO = new BankAccountRequestDTO();
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setName(bankAccount.getCustomer().getName());
        BeanUtils.copyProperties(bankAccount,bankAccountDTO);
        bankAccountDTO.setCustomerdto(customerDTO);
        return bankAccountDTO;
    }

    public BankAccount toRequestENTITY(BankAccountRequestDTO bankAccountDTO){
        BankAccount bankAccount = new BankAccount();
        Customer customer = new Customer();
        customer.setName(bankAccountDTO.getCustomerdto().getName());
        BeanUtils.copyProperties(bankAccountDTO,bankAccount);
        bankAccount.setCustomer(customer);
        return bankAccount;
    }


    public BankAccountResponseDTO toResponseDTO(BankAccount bankAccount){
        BankAccountResponseDTO bankAccountDTO = new BankAccountResponseDTO();
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setName(bankAccount.getCustomer().getName());
        BeanUtils.copyProperties(bankAccount,bankAccountDTO);
        bankAccountDTO.setCustomerdto(customerDTO);
        return bankAccountDTO;
    }

    public BankAccount toResponseENTITY(BankAccountResponseDTO bankAccountDTO){
        BankAccount bankAccount = new BankAccount();
        Customer customer = new Customer();
        customer.setName(bankAccountDTO.getCustomerdto().getName());
        BeanUtils.copyProperties(bankAccountDTO,bankAccount);
        bankAccount.setCustomer(customer);
        return bankAccount;
    }

}
