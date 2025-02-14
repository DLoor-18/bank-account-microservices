package ec.com.sofka.handler.movement;

import ec.com.sofka.data.MovementResponseDTO;
import ec.com.sofka.data.MovementUpdateRequestDTO;
import ec.com.sofka.mapper.MovementMapper;
import ec.com.sofka.usecase.movement.UpdateMovementUseCase;
import org.springframework.stereotype.Component;

@Component
public class UpdateMovementHandler {
    private final UpdateMovementUseCase updateMovementUseCase;

    public UpdateMovementHandler(UpdateMovementUseCase updateMovementUseCase) {
        this.updateMovementUseCase = updateMovementUseCase;
    }

    public MovementResponseDTO updateMovement(MovementUpdateRequestDTO movementRequestDTO) {
        return MovementMapper.toResponseDTO(
                updateMovementUseCase.execute(MovementMapper.updateToModel(movementRequestDTO)));
    }
}