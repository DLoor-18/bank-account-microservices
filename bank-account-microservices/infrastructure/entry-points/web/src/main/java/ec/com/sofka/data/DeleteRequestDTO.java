package ec.com.sofka.data;

import jakarta.validation.constraints.NotNull;

public class DeleteRequestDTO {
    @NotNull(message = "id cant nulleable")
    private Long id;

    public DeleteRequestDTO() {
    }

    public DeleteRequestDTO(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

}