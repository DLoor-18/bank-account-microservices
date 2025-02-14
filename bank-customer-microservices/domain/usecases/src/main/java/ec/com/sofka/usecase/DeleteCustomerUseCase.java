package ec.com.sofka.usecase;

import ec.com.sofka.exceptions.RecordNotFoundException;
import ec.com.sofka.gateway.CustomerRepository;

public class DeleteCustomerUseCase {
    private final CustomerRepository customerRepository;

    public DeleteCustomerUseCase(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void execute(Long customerId) {
        if (customerRepository.findById(customerId) == null) {
            throw new RecordNotFoundException("Customer with id " + customerId + " not found");
        }
        customerRepository.delete(customerId);
    }
}