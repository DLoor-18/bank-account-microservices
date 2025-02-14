package ec.com.sofka.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "accounts", uniqueConstraints = @UniqueConstraint(columnNames = "account_id"))
public class AccountEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id", nullable = false)
    private Long accountId;

    @Column(name = "customer_id", nullable = false)
    private Long customerId;

    @Column(name = "number_account", nullable = false)
    private String numberAccount;

    @Column(name = "account_type", nullable = false)
    private String accountType;

    @Column(name = "opening_balance", nullable = false)
    private BigDecimal openingBalance;

    @Column(name = "balance", nullable = false)
    private BigDecimal balance;

    @Column(name = "status", nullable = false)
    private Boolean status;

    public AccountEntity() {
    }

    public AccountEntity(Long accountId, Long customerId, String numberAccount, String accountType, BigDecimal openingBalance, BigDecimal balance, Boolean status) {
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

}