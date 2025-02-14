package ec.com.sofka.data;

import jakarta.validation.constraints.NotNull;

public class CustomerDeleteRequestDTO {
    @NotNull(message = "customerId cant nulleable")
    private Long customerId;

    public CustomerDeleteRequestDTO() {
    }

    public CustomerDeleteRequestDTO(Long customerId) {
        this.customerId = customerId;
    }

    public Long getCustomerId() {
        return customerId;
    }

}