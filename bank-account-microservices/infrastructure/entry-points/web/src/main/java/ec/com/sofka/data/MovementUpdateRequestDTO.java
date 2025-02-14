package ec.com.sofka.data;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public class MovementUpdateRequestDTO {
    @NotNull(message = "movementId cant nulleable")
    private Long movementId;
    @NotNull(message = "accountNumber cant nulleable")
    @NotBlank(message = "accountNumber cant blank")
    private String accountNumber;
    @NotNull(message = "movementType cant nulleable")
    @NotBlank(message = "movementType cant blank")
    private String movementType;
    @NotNull(message = "value cant nulleable")
    private BigDecimal value;
    @NotNull(message = "balance cant nulleable")
    private BigDecimal balance;

    public MovementUpdateRequestDTO() {}

    public MovementUpdateRequestDTO(Long movementId, String accountNumber, String movementType, BigDecimal value, BigDecimal balance) {
        this.movementId = movementId;
        this.accountNumber = accountNumber;
        this.movementType = movementType;
        this.value = value;
        this.balance = balance;
    }

    public Long getMovementId() {
        return movementId;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getMovementType() {
        return movementType;
    }

    public BigDecimal getValue() {
        return value;
    }

    public BigDecimal getBalance() {
        return balance;
    }
}
