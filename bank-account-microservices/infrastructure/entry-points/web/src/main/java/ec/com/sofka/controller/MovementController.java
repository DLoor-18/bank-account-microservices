package ec.com.sofka.controller;

import ec.com.sofka.data.DeleteRequestDTO;
import ec.com.sofka.data.MovementRequestDTO;
import ec.com.sofka.data.MovementResponseDTO;
import ec.com.sofka.data.MovementUpdateRequestDTO;
import ec.com.sofka.handler.movement.DeleteMovementHandler;
import ec.com.sofka.handler.movement.FindAllMovementsHandler;
import ec.com.sofka.handler.movement.SaveMovementHandler;
import ec.com.sofka.handler.movement.UpdateMovementHandler;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movements")
public class MovementController {
    private final DeleteMovementHandler deleteMovementHandler;
    private final SaveMovementHandler saveMovementHandler;
    private final FindAllMovementsHandler findAllMovementsHandler;
    private final UpdateMovementHandler updateMovementHandler;

    public MovementController(DeleteMovementHandler deleteMovementHandler, SaveMovementHandler saveMovementHandler, FindAllMovementsHandler findAllMovementsHandler, UpdateMovementHandler updateMovementHandler) {
        this.deleteMovementHandler = deleteMovementHandler;
        this.saveMovementHandler = saveMovementHandler;
        this.findAllMovementsHandler = findAllMovementsHandler;
        this.updateMovementHandler = updateMovementHandler;
    }

    @PostMapping
    public ResponseEntity<MovementResponseDTO> saveMovement(@Valid @RequestBody MovementRequestDTO Movement) {
        MovementResponseDTO MovementResponseDTO = saveMovementHandler.saveMovement(Movement);
        return new ResponseEntity<>(MovementResponseDTO, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<MovementResponseDTO>> getAllMovements() {
        return ResponseEntity.ok(findAllMovementsHandler.findAll());
    }

    @PutMapping
    public ResponseEntity<MovementResponseDTO> updateMovement(@Valid @RequestBody MovementUpdateRequestDTO customerRequestDTO) {
        return ResponseEntity.ok(updateMovementHandler.updateMovement(customerRequestDTO));
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteCustomer(@Valid @RequestBody DeleteRequestDTO MovementRequestDTO) {
        deleteMovementHandler.delete(MovementRequestDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}