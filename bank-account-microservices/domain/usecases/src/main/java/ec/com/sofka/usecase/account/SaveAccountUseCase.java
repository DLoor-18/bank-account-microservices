package ec.com.sofka.usecase.account;

import ec.com.sofka.Account;
import ec.com.sofka.exceptions.ConflictException;
import ec.com.sofka.gateway.AccountRepository;
import ec.com.sofka.gateway.ValidateCustomerBusMessage;

public class SaveAccountUseCase {
    private final AccountRepository accountRepository;
    private final ValidateCustomerBusMessage validateCustomerBusMessage;

    public SaveAccountUseCase(AccountRepository accountRepository, ValidateCustomerBusMessage validateCustomerBusMessage) {
        this.accountRepository = accountRepository;
        this.validateCustomerBusMessage = validateCustomerBusMessage;
    }

    public Account execute(Account account) {
        if (accountRepository.findByNumberAccount(account.getNumberAccount()) != null) {
            throw new ConflictException("Number account already exists");
        }

        Object customer = validateCustomerBusMessage.sendMessage(account.getCustomerId().toString());

        if (customer == null || "".equals(customer.toString())) {
            throw new ConflictException("Customer not found");
        } else if ("Inactive".equals(customer.toString())) {
            throw new ConflictException("Customer is inactive");
        }

        account.setBalance(account.getOpeningBalance());
        return accountRepository.save(account);

   }
}