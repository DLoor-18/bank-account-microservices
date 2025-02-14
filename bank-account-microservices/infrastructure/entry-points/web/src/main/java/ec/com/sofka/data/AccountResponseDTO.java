package ec.com.sofka.data;

import java.io.Serializable;
import java.math.BigDecimal;

public class AccountResponseDTO implements Serializable {
    private Long accountId;
    private Long customerId;
    private String numberAccount;
    private String accountType;
    private BigDecimal balance;
    private Boolean status;

    public AccountResponseDTO() {
    }

    public AccountResponseDTO(Long accountId, Long customerId, String numberAccount, String accountType, BigDecimal balance, Boolean status) {
        this.accountId = accountId;
        this.customerId = customerId;
        this.numberAccount = numberAccount;
        this.accountType = accountType;
        this.balance = balance;
        this.status = status;
    }

    public Long getAccountId() {
        return accountId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public String getNumberAccount() {
        return numberAccount;
    }

    public String getAccountType() {
        return accountType;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public Boolean getStatus() {
        return status;
    }
}
