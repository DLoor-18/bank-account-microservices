package ec.com.sofka.handler.movement;

import ec.com.sofka.data.MovementResponseDTO;
import ec.com.sofka.mapper.MovementMapper;
import ec.com.sofka.usecase.movement.FindAllMovementsUseCase;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class FindAllMovementsHandler {
    private final FindAllMovementsUseCase findAllMovementsUseCase;

    public FindAllMovementsHandler(FindAllMovementsUseCase findAllMovementsUseCase) {
        this.findAllMovementsUseCase = findAllMovementsUseCase;
    }

    public List<MovementResponseDTO> findAll() {
        return findAllMovementsUseCase.execute().stream()
                .map(MovementMapper::toResponseDTO)
                .collect(Collectors.toList());
    }
}
