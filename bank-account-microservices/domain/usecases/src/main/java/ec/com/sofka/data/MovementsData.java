package ec.com.sofka.data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class MovementsData {
    private LocalDateTime date;
    private String customer;
    private String accountNumber;
    private String movementType;
    private BigDecimal openingBalance;
    private Boolean status;
    private BigDecimal movementAmount;
    private BigDecimal availableBalance;

    public MovementsData() {}

    public MovementsData(LocalDateTime date, String customer, String accountNumber, String movementType, BigDecimal openingBalance, Boolean status, BigDecimal movementAmount, BigDecimal availableBalance) {
        this.date = date;
        this.customer = customer;
        this.accountNumber = accountNumber;
        this.movementType = movementType;
        this.openingBalance = openingBalance;
        this.status = status;
        this.movementAmount = movementAmount;
        this.availableBalance = availableBalance;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public String getCustomer() {
        return customer;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getMovementType() {
        return movementType;
    }

    public BigDecimal getOpeningBalance() {
        return openingBalance;
    }

    public Boolean getStatus() {
        return status;
    }

    public BigDecimal getMovementAmount() {
        return movementAmount;
    }

    public BigDecimal getAvailableBalance() {
        return availableBalance;
    }

}