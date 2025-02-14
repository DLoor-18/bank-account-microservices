package ec.com.sofka.repository;

import ec.com.sofka.entity.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAccountRepository extends JpaRepository<AccountEntity, Long> {

    AccountEntity findByNumberAccount(String numberAccount);

}