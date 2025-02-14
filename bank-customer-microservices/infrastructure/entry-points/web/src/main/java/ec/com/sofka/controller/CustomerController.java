package ec.com.sofka.controller;

import ec.com.sofka.data.CustomerDeleteRequestDTO;
import ec.com.sofka.data.CustomerRequestDTO;
import ec.com.sofka.data.CustomerResponseDTO;
import ec.com.sofka.handler.customer.DeleteCustomerHandler;
import ec.com.sofka.handler.customer.FindAllCustomerHandler;
import ec.com.sofka.handler.customer.SaveCustomerHandler;
import ec.com.sofka.handler.customer.UpdateCustomerHandler;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {
    private final SaveCustomerHandler saveCustomerHandler;
    private final UpdateCustomerHandler updateCustomerHandler;
    private final FindAllCustomerHandler findAllCustomerHandler;
    private final DeleteCustomerHandler deleteCustomerHandler;

    public CustomerController(SaveCustomerHandler saveCustomerHandler, UpdateCustomerHandler updateCustomerHandler, FindAllCustomerHandler findAllCustomerHandler, DeleteCustomerHandler deleteCustomerHandler) {
        this.saveCustomerHandler = saveCustomerHandler;
        this.updateCustomerHandler = updateCustomerHandler;
        this.findAllCustomerHandler = findAllCustomerHandler;
        this.deleteCustomerHandler = deleteCustomerHandler;
    }

    @PostMapping
    public ResponseEntity<CustomerResponseDTO> saveCustomer(@Valid @RequestBody CustomerRequestDTO customerRequestDTO) {
        CustomerResponseDTO customerResponse = saveCustomerHandler.save(customerRequestDTO);
        return new ResponseEntity<>(customerResponse, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<CustomerResponseDTO>> findAllCustomers() {
        return ResponseEntity.ok(findAllCustomerHandler.findAll());
    }

    @PutMapping
    public ResponseEntity<CustomerResponseDTO> updateCustomer(@Valid @RequestBody CustomerRequestDTO customerRequestDTO) {
        return ResponseEntity.ok(updateCustomerHandler.updateCustomer(customerRequestDTO));
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteCustomer(@Valid @RequestBody CustomerDeleteRequestDTO customer) {
        deleteCustomerHandler.delete(customer.getCustomerId());
        return new ResponseEntity<>(HttpStatus.OK);
    }
}