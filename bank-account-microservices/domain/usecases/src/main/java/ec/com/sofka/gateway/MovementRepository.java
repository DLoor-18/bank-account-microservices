package ec.com.sofka.gateway;

import ec.com.sofka.Movement;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface MovementRepository {
    Movement save(Movement movement);
    List<Movement> findAll();
    Movement update(Movement movement);
    void delete(Long movementId);
    Movement findById(Long id);
    List<Movement> findMovementsByDateRangeAndAccounts(LocalDateTime startDate, LocalDateTime endDate, List<String> accountNumber);
}