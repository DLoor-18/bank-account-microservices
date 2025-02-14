package ec.com.sofka.usecase;

import ec.com.sofka.Customer;
import ec.com.sofka.exceptions.RecordNotFoundException;
import ec.com.sofka.gateway.CustomerRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@DisplayName("DeleteCustomerUseCase")
public class DeleteCustomerUseCaseTest {

    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private DeleteCustomerUseCase deleteCustomerUseCase;

    @Test
    @DisplayName("Should delete customer, when customer exists")
    void execute_whenCustomerExists_shouldDeleteCustomer() {
        Long customerId = 1L;
        Customer customer = new Customer("Test", "Male", 21, "1234567890", "test", "0000", 1L, "test", true);
        when(customerRepository.findById(customerId)).thenReturn(customer);

        deleteCustomerUseCase.execute(customerId);

        verify(customerRepository, times(1)).delete(customerId);
    }

    @Test
    @DisplayName("Should throw RecordNotFoundException, when customer does not exist")
    void execute_whenCustomerDoesNotExist_shouldThrowRecordNotFoundException() {
        Long customerId = 456L;
        when(customerRepository.findById(customerId)).thenReturn(null);

        RecordNotFoundException exception = assertThrows(RecordNotFoundException.class, () -> {
            deleteCustomerUseCase.execute(customerId);
        });

        assertEquals("Customer with id " + customerId + " not found", exception.getMessage());
        verify(customerRepository, never()).delete(anyLong());
    }
}