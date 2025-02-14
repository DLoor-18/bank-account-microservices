package ec.com.sofka.usecase.account;

import ec.com.sofka.exceptions.RecordNotFoundException;
import ec.com.sofka.gateway.AccountRepository;

public class DeleteAccountUseCase {
    private final AccountRepository accountRepository;

    public DeleteAccountUseCase(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public void execute(Long accountId) {
        if (accountRepository.findById(accountId) == null) {
            throw new RecordNotFoundException("Account with id " + accountId + " not found");
        }
        accountRepository.delete(accountId);
    }
}