package ec.com.sofka.usecase;

import ec.com.sofka.gateway.CustomerRepository;

public class DeleteCustomerUseCase {
    private final CustomerRepository customerRepository;

    public DeleteCustomerUseCase(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void execute(Long customerId) {
        customerRepository.delete(customerId);
    }
}