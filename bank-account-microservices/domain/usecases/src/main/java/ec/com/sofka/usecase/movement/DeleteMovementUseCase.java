package ec.com.sofka.usecase.movement;

import ec.com.sofka.exceptions.RecordNotFoundException;
import ec.com.sofka.gateway.MovementRepository;

public class DeleteMovementUseCase {
    private final MovementRepository movementRepository;

    public DeleteMovementUseCase(MovementRepository movementRepository) {
        this.movementRepository = movementRepository;
    }

    public void execute(Long movementId) {
        if (movementRepository.findById(movementId) != null) {
            throw new RecordNotFoundException("Movement with id " + movementId + " not found");
        }
        movementRepository.delete(movementId);
    }
}