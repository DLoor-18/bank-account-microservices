package ec.com.sofka.handler.customer;

import ec.com.sofka.gateway.CustomerRepository;
import org.springframework.stereotype.Component;

@Component
public class DeleteCustomerHandler {
    private final CustomerRepository customerRepository;

    public DeleteCustomerHandler(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

        public void delete(Long customerId) {
        customerRepository.delete(customerId);
    }
}