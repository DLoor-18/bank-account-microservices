package ec.com.sofka.controller;

import ec.com.sofka.data.*;
import ec.com.sofka.handler.movement.*;
import jakarta.validation.Valid;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/movements")
public class MovementController {
    private final DeleteMovementHandler deleteMovementHandler;
    private final SaveMovementHandler saveMovementHandler;
    private final FindAllMovementsHandler findAllMovementsHandler;
    private final UpdateMovementHandler updateMovementHandler;
    private final FindMovementsByConsumerHandler findMovementsByConsumerHandler;

    public MovementController(DeleteMovementHandler deleteMovementHandler, SaveMovementHandler saveMovementHandler, FindAllMovementsHandler findAllMovementsHandler, UpdateMovementHandler updateMovementHandler, FindMovementsByConsumerHandler findMovementsByConsumerHandler) {
        this.deleteMovementHandler = deleteMovementHandler;
        this.saveMovementHandler = saveMovementHandler;
        this.findAllMovementsHandler = findAllMovementsHandler;
        this.updateMovementHandler = updateMovementHandler;
        this.findMovementsByConsumerHandler = findMovementsByConsumerHandler;
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

    @GetMapping("/report{identifyCard}{startDate}{endDate}")
    public ResponseEntity<List<FindMovementsResponseDTO>> report(
            @RequestParam("identifyCard") String identificationCustomer,
            @RequestParam("startDate")  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDate startDate,
            @RequestParam("endDate")  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDate endDate) {
        return  ResponseEntity.ok(findMovementsByConsumerHandler.findMovementsByConsumer(identificationCustomer, startDate, endDate));

    }
}