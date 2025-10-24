package rabih.bankaccountservice.mappers;

import org.springframework.beans.BeanUtils;
import rabih.bankaccountservice.dtos.BankAccountRequestDTO;
import rabih.bankaccountservice.dtos.CustomerDTO;
import rabih.bankaccountservice.entities.BankAccount;
import rabih.bankaccountservice.entities.Customer;

public class BankAccoutRequestMapper {
    public BankAccountRequestDTO toDTO(BankAccount bankAccount){
        BankAccountRequestDTO bankAccountDTO = new BankAccountRequestDTO();
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setName(bankAccount.getCustomer().getName());
        BeanUtils.copyProperties(bankAccount,bankAccountDTO);
        bankAccountDTO.setCustomerdto(customerDTO);
        return bankAccountDTO;
    }

    public BankAccount toENTITY(BankAccountRequestDTO bankAccountDTO){
        BankAccount bankAccount = new BankAccount();
        Customer customer = new Customer();
        customer.setName(bankAccountDTO.getCustomerdto().getName());
        BeanUtils.copyProperties(bankAccountDTO,bankAccount);
        return bankAccount;
    }

}
