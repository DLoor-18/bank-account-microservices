package ec.com.sofka;

import java.math.BigDecimal;

public class Movement {
    private Long movementId;
    private String accountNumber;
    private String movementType;
    private BigDecimal value;
    private BigDecimal balance;

    public Movement() {
    }

    public Movement(Long movementId, String accountNumber, String movementType, BigDecimal value, BigDecimal balance) {
        this.movementId = movementId;
        this.accountNumber = accountNumber;
        this.movementType = movementType;
        this.value = value;
        this.balance = balance;
    }

    public void setMovementId(Long movementId) {
        this.movementId = movementId;
    }

    public void setMovementType(String movementType) {
        this.movementType = movementType;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Long getMovementId() {
        return movementId;
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

    public String getAccountNumber() {
        return accountNumber;
    }

}