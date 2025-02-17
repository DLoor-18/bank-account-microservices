package ec.com.sofka.handler.movement;

import ec.com.sofka.data.FindMovementsResponseDTO;
import ec.com.sofka.mapper.MovementMapper;
import ec.com.sofka.usecase.movement.FindMovementsByConsumerUseCase;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class FindMovementsByConsumerHandler {
    private final FindMovementsByConsumerUseCase findMovementsByConsumerUseCase;

    public FindMovementsByConsumerHandler(FindMovementsByConsumerUseCase findMovementsByConsumerUseCase) {
        this.findMovementsByConsumerUseCase = findMovementsByConsumerUseCase;
    }

    public List<FindMovementsResponseDTO> findMovementsByConsumer(String identificationCustomer, LocalDate startDate, LocalDate endDate) {
        LocalDateTime startDateTime = startDate.atStartOfDay();
        LocalDateTime endDateTime = endDate.atTime(LocalTime.MAX);

        return findMovementsByConsumerUseCase.execute(identificationCustomer, startDateTime, endDateTime).stream()
                .map(MovementMapper::toResponseFindDTO)
                .collect(Collectors.toList());
    }

}