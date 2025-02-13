package ec.com.sofka.handler.customer;

import ec.com.sofka.Customer;
import ec.com.sofka.data.CustomerResponseDTO;
import ec.com.sofka.gateway.CustomerRepository;
import ec.com.sofka.mapper.CustomerMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class FindAllCustomerHandler {
    private final CustomerRepository customerRepository;

    public FindAllCustomerHandler(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<CustomerResponseDTO> findAll() {
        return customerRepository.findAll().stream()
                .map(CustomerMapper::toResponseDto)
                .collect(Collectors.toList());
    }

}