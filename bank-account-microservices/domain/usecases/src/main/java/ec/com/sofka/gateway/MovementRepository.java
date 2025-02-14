package ec.com.sofka.gateway;

import ec.com.sofka.Movement;

import java.util.List;

public interface MovementRepository {
    Movement save(Movement movement);
    List<Movement> findAll();
    Movement update(Movement movement);
    void delete(Long movementId);
    Movement findById(Long id);
}