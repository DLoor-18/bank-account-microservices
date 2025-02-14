package ec.com.sofka.handler.customer;

import ec.com.sofka.usecase.DeleteCustomerUseCase;
import org.springframework.stereotype.Component;

@Component
public class DeleteCustomerHandler {
    private final DeleteCustomerUseCase deleteCustomerUseCase;

    public DeleteCustomerHandler(DeleteCustomerUseCase deleteCustomerUseCase) {
        this.deleteCustomerUseCase = deleteCustomerUseCase;
    }

    public void delete(Long customerId) {
        deleteCustomerUseCase.execute(customerId);
    }
}