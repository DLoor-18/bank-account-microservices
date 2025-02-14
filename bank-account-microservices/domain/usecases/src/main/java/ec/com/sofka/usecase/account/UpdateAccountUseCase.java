package ec.com.sofka.usecase.account;

import ec.com.sofka.Account;
import ec.com.sofka.exceptions.RecordNotFoundException;
import ec.com.sofka.gateway.AccountRepository;

public class UpdateAccountUseCase {
    private final AccountRepository accountRepository;

    public UpdateAccountUseCase(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Account execute(Account account) {
        if (accountRepository.findById(account.getAccountId()) != null) {
            return accountRepository.update(account);
        }
        throw new RecordNotFoundException("Account with id " + account.getAccountId() + " not found");
    }
}