package ec.com.sofka.handler.movement;

import ec.com.sofka.data.DeleteRequestDTO;
import ec.com.sofka.usecase.movement.DeleteMovementUseCase;
import org.springframework.stereotype.Component;

@Component
public class DeleteMovementHandler {
    private final DeleteMovementUseCase deleteMovementUseCase;

    public DeleteMovementHandler(DeleteMovementUseCase deleteMovementUseCase) {
        this.deleteMovementUseCase = deleteMovementUseCase;
    }

    public void delete(DeleteRequestDTO movementId) {
        deleteMovementUseCase.execute(movementId.getId());
    }
}