package ec.com.sofka.mapper;

import ec.com.sofka.Movement;
import ec.com.sofka.data.MovementRequestDTO;
import ec.com.sofka.data.MovementResponseDTO;
import ec.com.sofka.data.MovementUpdateRequestDTO;

import java.math.BigDecimal;

public class MovementMapper {

    public static Movement toModel(MovementRequestDTO movement) {
        if (movement != null) {
            return new Movement(
                    null,
                    movement.getAccountNumber(),
                    movement.getMovementType(),
                    movement.getValue(),
                    BigDecimal.ZERO
            );
        }

        return null;
    }

    public static Movement updateToModel(MovementUpdateRequestDTO movement) {
        if (movement != null) {
            return new Movement(
                    movement.getMovementId(),
                    movement.getAccountNumber(),
                    movement.getMovementType(),
                    movement.getValue(),
                    movement.getBalance()
            );
        }

        return null;
    }

    public static MovementResponseDTO toResponseDTO(Movement movement) {
        if (movement != null) {
            return new MovementResponseDTO(
                    movement.getMovementId(),
                    movement.getAccountNumber(),
                    movement.getMovementType(),
                    movement.getValue(),
                    movement.getBalance()
            );
        }

        return null;
    }

}