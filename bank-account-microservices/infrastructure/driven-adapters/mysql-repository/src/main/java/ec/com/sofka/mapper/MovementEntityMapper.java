package ec.com.sofka.mapper;

import ec.com.sofka.Movement;
import ec.com.sofka.entity.MovementEntity;

public class MovementEntityMapper {
    public static MovementEntity toEntity(Movement movement) {
        if (movement != null) {
            return new MovementEntity(
                    movement.getMovementId(),
                    movement.getAccountNumber(),
                    movement.getMovementType(),
                    movement.getValue(),
                    movement.getBalance()
            );
        }

        return null;
    }

    public static Movement toModel(MovementEntity movementEntity) {
        if (movementEntity != null) {
            return new Movement(
                movementEntity.getMovementId(),
                movementEntity.getAccountNumber(),
                movementEntity.getMovementType(),
                movementEntity.getValue(),
                movementEntity.getBalance(),
                movementEntity.getDate()
            );
        }

        return null;
    }
}
