package ec.com.sofka.usecase;

import ec.com.sofka.Customer;
import ec.com.sofka.gateway.CustomerRepository;

import java.util.List;

public class FindAllCustomerUseCase {
    private final CustomerRepository customerRepository;

    public FindAllCustomerUseCase(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> execute() {
        return customerRepository.findAll();
    }
}