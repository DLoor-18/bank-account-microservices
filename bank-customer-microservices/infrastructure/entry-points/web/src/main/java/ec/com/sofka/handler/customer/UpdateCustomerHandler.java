package ec.com.sofka.handler.customer;

import ec.com.sofka.data.CustomerResponseDTO;
import ec.com.sofka.data.CustomerUpdateRequestDTO;
import ec.com.sofka.mapper.CustomerMapper;
import ec.com.sofka.usecase.UpdateCustomerUseCase;
import org.springframework.stereotype.Component;

@Component
public class UpdateCustomerHandler {
    private final UpdateCustomerUseCase updateCustomerUseCase;

    public UpdateCustomerHandler(UpdateCustomerUseCase updateCustomerUseCase) {
        this.updateCustomerUseCase = updateCustomerUseCase;
    }

    public CustomerResponseDTO updateCustomer(CustomerUpdateRequestDTO customer) {
        return CustomerMapper.toResponseDto(updateCustomerUseCase.execute(CustomerMapper.updateToModel(customer)));
    }

}