package ec.com.sofka.usecase;

import ec.com.sofka.Customer;
import ec.com.sofka.PasswordUtils;
import ec.com.sofka.exceptions.RecordNotFoundException;
import ec.com.sofka.gateway.CustomerRepository;

public class UpdateCustomerUseCase {
    private final CustomerRepository customerRepository;

    public UpdateCustomerUseCase(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer execute(Customer customer) {
        if (customerRepository.findById(customer.getCustomerId()) != null) {
            customer.setPassword(PasswordUtils.encryptPassword(customer.getPassword()));
            return customerRepository.update(customer);
        }
        throw new RecordNotFoundException("Customer with id " + customer.getCustomerId() + " not found");
    }
}