package ec.com.sofka.mapper;

import ec.com.sofka.Account;
import ec.com.sofka.data.AccountRequestDTO;
import ec.com.sofka.data.AccountResponseDTO;
import ec.com.sofka.data.AccountUpdateRequestDTO;

import java.math.BigDecimal;

public class AccountMapper {

    public static Account toModel(AccountRequestDTO account) {
        if (account != null) {
            return new Account(
                    null,
                    account.getCustomerId(),
                    account.getNumberAccount(),
                    account.getAccountType(),
                    account.getOpeningBalance(),
                    new BigDecimal(0),
                    account.getStatus()
            );
        }

        return null;
    }

    public static Account updateToModel(AccountUpdateRequestDTO account) {
        if (account != null) {
            return new Account(
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

    public static AccountResponseDTO toResponseDTO(Account account) {
        if (account != null) {
            return new AccountResponseDTO(
                    account.getAccountId(),
                    account.getCustomerId(),
                    account.getNumberAccount(),
                    account.getAccountType(),
                    account.getOpeningBalance(),
                    account.getStatus()
            );
        }

        return null;
    }

}