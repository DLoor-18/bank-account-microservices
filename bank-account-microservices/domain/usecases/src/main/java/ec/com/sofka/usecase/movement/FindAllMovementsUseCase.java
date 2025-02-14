package ec.com.sofka.usecase.movement;

import ec.com.sofka.Movement;
import ec.com.sofka.gateway.MovementRepository;

import java.util.List;

public class FindAllMovementsUseCase {
    private final MovementRepository movementRepository;

    public FindAllMovementsUseCase(MovementRepository movementRepository) {
        this.movementRepository = movementRepository;
    }

    public List<Movement> execute() {
        return movementRepository.findAll();
    }
}