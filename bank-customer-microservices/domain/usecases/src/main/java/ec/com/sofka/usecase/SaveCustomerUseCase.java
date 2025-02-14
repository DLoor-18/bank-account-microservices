package ec.com.sofka.usecase;

import ec.com.sofka.Customer;
import ec.com.sofka.PasswordUtils;
import ec.com.sofka.exceptions.ConflictException;
import ec.com.sofka.gateway.CustomerRepository;

public class SaveCustomerUseCase {
    private final CustomerRepository customerRepository;

    public SaveCustomerUseCase(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

   public Customer execute(Customer customer) {
        if (customerRepository.findByIdentifyCard(customer.getIdentifyCard()) == null) {
            customer.setPassword(PasswordUtils.encryptPassword(customer.getPassword()));
            return customerRepository.save(customer);
        }

        throw new ConflictException("Identify Card of customer already exists");
   }
}