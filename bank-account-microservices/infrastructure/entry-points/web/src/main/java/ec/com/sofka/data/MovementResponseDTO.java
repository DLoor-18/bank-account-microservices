package ec.com.sofka.data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class MovementResponseDTO {
    private Long movementId;
    private String accountNumber;
    private String movementType;
    private BigDecimal value;
    private BigDecimal balance;
    private LocalDateTime date;

    public MovementResponseDTO() {
    }

    public MovementResponseDTO(Long movementId, String accountNumber, String movementType, BigDecimal value, BigDecimal balance, LocalDateTime date) {
        this.movementId = movementId;
        this.accountNumber = accountNumber;
        this.movementType = movementType;
        this.value = value;
        this.balance = balance;
        this.date = date;
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