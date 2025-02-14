package ec.com.sofka.handler.movement;

import ec.com.sofka.data.MovementRequestDTO;
import ec.com.sofka.data.MovementResponseDTO;
import ec.com.sofka.mapper.MovementMapper;
import ec.com.sofka.usecase.movement.SaveMovementUseCase;
import org.springframework.stereotype.Component;

@Component
public class SaveMovementHandler {
    private final SaveMovementUseCase saveMovementUseCase;

    public SaveMovementHandler(SaveMovementUseCase saveMovementUseCase) {
        this.saveMovementUseCase = saveMovementUseCase;
    }

    public MovementResponseDTO saveMovement(MovementRequestDTO movementRequestDTO) {
        return MovementMapper.toResponseDTO(
                saveMovementUseCase.execute(MovementMapper.toModel(movementRequestDTO)));
    }
}
