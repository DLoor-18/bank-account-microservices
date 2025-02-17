package ec.com.sofka.adapter;

import ec.com.sofka.Account;
import ec.com.sofka.gateway.AccountRepository;
import ec.com.sofka.mapper.AccountEntityMapper;
import ec.com.sofka.repository.IAccountRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class AccountAdapter implements AccountRepository {
    private final IAccountRepository accountRepository;

    public AccountAdapter(IAccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public Account save(Account account) {
        return AccountEntityMapper.toModel(
                accountRepository.save(AccountEntityMapper.toEntity(account)));
    }

    @Override
    public List<Account> findAll() {
        return accountRepository.findAll().stream()
                .map(AccountEntityMapper::toModel)
                .collect(Collectors.toList());
    }

    @Override
    public Account update(Account account) {
        return AccountEntityMapper.toModel(
                accountRepository.save(AccountEntityMapper.toEntity(account)));
    }

    @Override
    public void delete(Long account) {
        accountRepository.deleteById(account);
    }

    @Override
    public Account findById(Long id) {
        return AccountEntityMapper.toModel(
                accountRepository.findById(id).orElse(null));
    }

    @Override
    public Account findByNumberAccount(String numberAccount) {
        return AccountEntityMapper.toModel(
                accountRepository.findByNumberAccount(numberAccount));
    }

    @Override
    public List<Account> findByCustomerId(Long customerId) {
        return accountRepository.findByCustomerId(customerId).stream()
                .map(AccountEntityMapper::toModel)
                .collect(Collectors.toList());
    }

}