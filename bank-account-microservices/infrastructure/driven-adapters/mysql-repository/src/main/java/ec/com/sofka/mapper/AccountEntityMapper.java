package ec.com.sofka.mapper;

import ec.com.sofka.Account;
import ec.com.sofka.entity.AccountEntity;

public class AccountEntityMapper {

    public static AccountEntity toEntity(Account account) {
        if (account != null) {
            return new AccountEntity(
                account.getAccountId(),
                account.getCustomerId(),
                account.getNumberAccount(),
                account.getAccountType(),
                account.getOpeningBalance(),
                account.getBalance(),
                account.getStatus()
            );

        }

        return null;
    }

    public static Account toModel(AccountEntity accountEntity) {
        if (accountEntity != null) {
            return new Account(
                    accountEntity.getAccountId(),
                    accountEntity.getCustomerId(),
                    accountEntity.getNumberAccount(),
                    accountEntity.getAccountType(),
                    accountEntity.getOpeningBalance(),
                    accountEntity.getBalance(),
                    accountEntity.getStatus()
            );
        }

        return null;
    }

}