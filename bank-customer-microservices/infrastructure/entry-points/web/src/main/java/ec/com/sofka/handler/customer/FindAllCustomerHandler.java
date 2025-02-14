package ec.com.sofka.handler.customer;

import ec.com.sofka.data.CustomerResponseDTO;
import ec.com.sofka.mapper.CustomerMapper;
import ec.com.sofka.usecase.FindAllCustomerUseCase;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class FindAllCustomerHandler {
    private final FindAllCustomerUseCase findAllCustomerUseCase;

    public FindAllCustomerHandler(FindAllCustomerUseCase findAllCustomerUseCase) {
        this.findAllCustomerUseCase = findAllCustomerUseCase;
    }

    public List<CustomerResponseDTO> findAll() {
        return findAllCustomerUseCase.execute().stream()
                .map(CustomerMapper::toResponseDto)
                .collect(Collectors.toList());
    }

}