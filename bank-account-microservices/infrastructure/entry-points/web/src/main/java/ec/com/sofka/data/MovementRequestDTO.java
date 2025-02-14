package ec.com.sofka.data;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public class MovementRequestDTO {
    @NotNull(message = "accountNumber cant nulleable")
    @NotBlank(message = "accountNumber cant blank")
    private String accountNumber;
    @NotNull(message = "movementType cant nulleable")
    @NotBlank(message = "movementType cant blank")
    private String movementType;
    @NotNull(message = "value cant nulleable")
    private BigDecimal value;

    public MovementRequestDTO() {}

    public MovementRequestDTO(String accountNumber, String movementType, BigDecimal value) {
        this.accountNumber = accountNumber;
        this.movementType = movementType;
        this.value = value;
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

}