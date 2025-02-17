package ec.com.sofka.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "movements", uniqueConstraints = @UniqueConstraint(columnNames = "movement_id"))
public class MovementEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movement_id", nullable = false)
    private Long movementId;

    @Column(name = "account_number", nullable = false)
    private String accountNumber;

    @Column(name = "movement_type", nullable = false)
    private String movementType;

    @Column(name = "value", nullable = false)
    private BigDecimal value;

    @Column(name = "balance", nullable = false)
    private BigDecimal balance;

    @Column(name = "date")
    private LocalDateTime date;

    public MovementEntity() {
    }

    @PrePersist
    public void prePersist() {
        if (this.date == null) {
            this.date = LocalDateTime.now();
        }
    }

    public MovementEntity(Long movementId, String accountNumber, String movementType, BigDecimal value, BigDecimal balance) {
        this.movementId = movementId;
        this.accountNumber = accountNumber;
        this.movementType = movementType;
        this.value = value;
        this.balance = balance;
    }

    public Long getMovementId() {
        return movementId;
    }

    public void setMovementId(Long movementId) {
        this.movementId = movementId;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getMovementType() {
        return movementType;
    }

    public void setMovementType(String movementType) {
        this.movementType = movementType;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public LocalDateTime getDate() {
        return date;
    }

}