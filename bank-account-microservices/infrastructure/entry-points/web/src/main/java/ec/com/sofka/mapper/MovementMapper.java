package ec.com.sofka.mapper;

import ec.com.sofka.Movement;
import ec.com.sofka.data.*;

import java.math.BigDecimal;

public class MovementMapper {

    public static Movement toModel(MovementRequestDTO movement) {
        if (movement != null) {
            return new Movement(
                    null,
                    movement.getAccountNumber(),
                    movement.getMovementType(),
                    movement.getValue(),
                    BigDecimal.ZERO,
                    null
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
                    movement.getBalance(),
                    null
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
                    movement.getBalance(),
                    movement.getDate()
            );
        }

        return null;
    }

    public static FindMovementsResponseDTO toResponseFindDTO(MovementsData movement) {
        if (movement != null) {
            return new FindMovementsResponseDTO(
                    movement.getDate(),
                    movement.getCustomer(),
                    movement.getAccountNumber(),
                    movement.getMovementType(),
                    movement.getOpeningBalance(),
                    movement.getStatus(),
                    movement.getMovementAmount(),
                    movement.getAvailableBalance()
            );
        }

        return null;
    }

}