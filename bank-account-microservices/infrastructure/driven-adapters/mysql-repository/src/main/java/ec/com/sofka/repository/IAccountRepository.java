package ec.com.sofka.repository;

import ec.com.sofka.entity.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IAccountRepository extends JpaRepository<AccountEntity, Long> {

    AccountEntity findByNumberAccount(String numberAccount);

    List<AccountEntity> findByCustomerId(Long customerId);

}