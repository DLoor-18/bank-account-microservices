package ec.com.sofka.gateway;

import ec.com.sofka.Account;

import java.util.List;

public interface AccountRepository {
    Account save(Account account);
    List<Account> findAll();
    Account update(Account account);
    void delete(Long account);
    Account findById(Long id);
    Account findByNumberAccount(String numberAccount);
}