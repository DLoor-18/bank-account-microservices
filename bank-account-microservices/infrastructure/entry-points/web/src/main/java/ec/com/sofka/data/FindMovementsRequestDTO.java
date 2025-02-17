package ec.com.sofka.data;

import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.time.LocalDateTime;

public class FindMovementsRequestDTO implements Serializable {
    @NotNull(message = "customerId cant nulleable")
    private Long customerId;

    @NotNull(message = "startDate cant nulleable")
    private LocalDateTime startDate;

    @NotNull(message = "endDate cant nulleable")
    private LocalDateTime endDate;

    public FindMovementsRequestDTO() {
    }

    public FindMovementsRequestDTO(Long customerId, LocalDateTime startDate, LocalDateTime endDate) {
        this.customerId = customerId;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

}