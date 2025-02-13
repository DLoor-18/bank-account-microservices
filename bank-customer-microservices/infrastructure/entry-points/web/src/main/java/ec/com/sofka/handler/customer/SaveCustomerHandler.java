package ec.com.sofka.handler.customer;

import ec.com.sofka.data.CustomerRequestDTO;
import ec.com.sofka.data.CustomerResponseDTO;
import ec.com.sofka.mapper.CustomerMapper;
import ec.com.sofka.usecase.SaveCustomerUseCase;
import org.springframework.stereotype.Component;

@Component
public class SaveCustomerHandler {
    private final SaveCustomerUseCase saveCustomerUseCase;

    public SaveCustomerHandler(SaveCustomerUseCase saveCustomerUseCase) {
        this.saveCustomerUseCase = saveCustomerUseCase;
    }

    public CustomerResponseDTO save(CustomerRequestDTO customerRequestDTO) {
        return CustomerMapper.toResponseDto(
                saveCustomerUseCase.execute(CustomerMapper.toModel(customerRequestDTO)));
    }

}