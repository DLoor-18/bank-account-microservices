package ec.com.sofka.usecase.movement;

import ec.com.sofka.Movement;
import ec.com.sofka.exceptions.RecordNotFoundException;
import ec.com.sofka.gateway.MovementRepository;

public class UpdateMovementUseCase {
    private final MovementRepository movementRepository;

    public UpdateMovementUseCase(MovementRepository movementRepository) {
        this.movementRepository = movementRepository;
    }

    public Movement execute(Movement movement) {
        if (movementRepository.findById(movement.getMovementId()) != null) {
            return movementRepository.update(movement);
        }
        throw new RecordNotFoundException("Movement with id " + movement.getMovementId() + " not found");
    }
}
