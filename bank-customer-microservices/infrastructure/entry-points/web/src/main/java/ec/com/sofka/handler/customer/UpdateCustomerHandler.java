package ec.com.sofka.handler.customer;

import ec.com.sofka.data.CustomerRequestDTO;
import ec.com.sofka.data.CustomerResponseDTO;
import ec.com.sofka.gateway.CustomerRepository;
import ec.com.sofka.mapper.CustomerMapper;
import org.springframework.stereotype.Component;

@Component
public class UpdateCustomerHandler {
    private final CustomerRepository customerRepository;

    public UpdateCustomerHandler(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public CustomerResponseDTO updateCustomer(CustomerRequestDTO customer) {
        return CustomerMapper.toResponseDto(customerRepository.update(CustomerMapper.toModel(customer)));
    }

}