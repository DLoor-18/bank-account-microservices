package ec.com.sofka.usecase;

import ec.com.sofka.Customer;
import ec.com.sofka.gateway.CustomerRepository;

public class SaveCustomerUseCase {
    private final CustomerRepository customerRepository;

    public SaveCustomerUseCase(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

   public Customer execute(Customer customer) {
        return customerRepository.save(customer);
   }
}