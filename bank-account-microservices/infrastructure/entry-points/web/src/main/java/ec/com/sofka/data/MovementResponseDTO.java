package ec.com.sofka.data;

import java.math.BigDecimal;

public class MovementResponseDTO {
    private Long movementId;
    private String accountNumber;
    private String movementType;
    private BigDecimal value;
    private BigDecimal balance;

    public MovementResponseDTO() {
    }

    public MovementResponseDTO(Long movementId, String accountNumber, String movementType, BigDecimal value, BigDecimal balance) {
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