package ec.com.sofka.data;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.math.BigDecimal;

public class AccountRequestDTO implements Serializable {
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
    @NotNull(message = "status cant nulleable")
    private Boolean status;

    public AccountRequestDTO() {
    }

    public AccountRequestDTO(Long customerId, String numberAccount, String accountType, BigDecimal openingBalance, Boolean status) {
        this.customerId = customerId;
        this.numberAccount = numberAccount;
        this.accountType = accountType;
        this.openingBalance = openingBalance;
        this.status = status;
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

    public Boolean getStatus() {
        return status;
    }
}