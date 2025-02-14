package ec.com.sofka.usecase.account;

import ec.com.sofka.Account;
import ec.com.sofka.exceptions.ConflictException;
import ec.com.sofka.gateway.AccountRepository;

public class SaveAccountUseCase {
    private final AccountRepository accountRepository;

    public SaveAccountUseCase(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Account execute(Account account) {
        if (accountRepository.findByNumberAccount(account.getNumberAccount()) == null) {
            account.setBalance(account.getOpeningBalance());
            return accountRepository.save(account);
        }

        throw new ConflictException("Number account of account already exists");
   }
}