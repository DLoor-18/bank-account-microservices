package ec.com.sofka.usecase;

import ec.com.sofka.Customer;
import ec.com.sofka.gateway.CustomerRepository;

public class GetCustomerByIdentifyCardUseCase {
    private final CustomerRepository customerRepository;

    public GetCustomerByIdentifyCardUseCase(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer execute(String identifyCard) {
        return customerRepository.findByIdentifyCard(identifyCard);
    }
}
