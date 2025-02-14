package ec.com.sofka.data;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public class AccountUpdateRequestDTO {
    @NotNull(message = "accountId cant nulleable")
    private Long accountId;
    @NotNull(message = "customerId cant nulleable")
    private Long customerId;
    @NotNull(message = "numberAccount cant nulleable")
    @NotBlank(message = "numberAccount cant blank")
    private String numberAccount;
    @NotNull(message = "accountType cant nulleable")
    @NotBlank(message = "accountType cant blank")
    private String accountType;
    @NotNull(message = "openingBalance cant nulleable")
    private BigDecimal openingBalance;
    @NotNull(message = "balance cant nulleable")
    private BigDecimal balance;
    @NotNull(message = "status cant nulleable")
    private Boolean status;

    public AccountUpdateRequestDTO() {
    }

    public AccountUpdateRequestDTO(Long accountId, Long customerId, String numberAccount, String accountType, BigDecimal openingBalance, BigDecimal balance, Boolean status) {
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
