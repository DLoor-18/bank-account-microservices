package ec.com.sofka;

import java.math.BigDecimal;

public class Account {
    private Long accountId;
    private Long customerId;
    private String numberAccount;
    private String accountType;
    private BigDecimal openingBalance;
    private BigDecimal balance;
    private Boolean status;

    public Account() {
    }

    public Account(Long accountId, Long customerId, String numberAccount, String accountType, BigDecimal openingBalance, BigDecimal balance, Boolean status) {
        this.accountId = accountId;
        this.customerId = customerId;
        this.numberAccount = numberAccount;
        this.accountType = accountType;
        this.openingBalance = openingBalance;
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

    public BigDecimal getOpeningBalance() {
        return openingBalance;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}