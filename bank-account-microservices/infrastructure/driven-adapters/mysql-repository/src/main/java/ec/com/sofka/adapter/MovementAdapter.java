package ec.com.sofka.adapter;

import ec.com.sofka.Movement;
import ec.com.sofka.gateway.MovementRepository;
import ec.com.sofka.mapper.MovementEntityMapper;
import ec.com.sofka.repository.IMovementRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class MovementAdapter implements MovementRepository {
    private final IMovementRepository movementRepository;

    public MovementAdapter(IMovementRepository movementRepository) {
        this.movementRepository = movementRepository;
    }

    @Override
    public Movement save(Movement movement) {
        return MovementEntityMapper.toModel(
                movementRepository.save(MovementEntityMapper.toEntity(movement)));
    }

    @Override
    public List<Movement> findAll() {
        return movementRepository.findAll().stream()
                .map(MovementEntityMapper::toModel)
                .collect(Collectors.toList());
    }

    @Override
    public Movement update(Movement movement) {
        return MovementEntityMapper.toModel(
                movementRepository.save(MovementEntityMapper.toEntity(movement)));
    }

    @Override
    public void delete(Long movementId) {
        movementRepository.deleteById(movementId);
    }

    @Override
    public Movement findById(Long id) {
        return MovementEntityMapper.toModel(
                movementRepository.findById(id).orElse(null));
    }

    @Override
    public List<Movement> findMovementsByDateRangeAndAccounts(LocalDateTime startDate, LocalDateTime endDate, List<String> accountNumber) {
        return movementRepository.findMovementsByDateRangeAndAccounts(startDate, endDate, accountNumber).stream()
                .map(MovementEntityMapper::toModel)
                .collect(Collectors.toList());
    }

}