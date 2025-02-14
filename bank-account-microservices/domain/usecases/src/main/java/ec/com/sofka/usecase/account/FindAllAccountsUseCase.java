package ec.com.sofka.usecase.account;

import ec.com.sofka.Account;
import ec.com.sofka.gateway.AccountRepository;

import java.util.List;

public class FindAllAccountsUseCase {
    private final AccountRepository accountRepository;

    public FindAllAccountsUseCase(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public List<Account> execute() {
        return accountRepository.findAll();
    }
}