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

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@DisplayName("UpdateCustomerUseCase")
public class UpdateCustomerUseCaseTest {

    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private UpdateCustomerUseCase updateCustomerUseCase;

    @Test
    @DisplayName("Should update customer, when customer exists")
    void execute_whenCustomerExists_shouldUpdateCustomer() {
        Customer customer = new Customer("Test", "Male", 21, "1234567890", "test", "0000", 1L, "test", true);

        when(customerRepository.findById(customer.getCustomerId())).thenReturn(customer);
        when(customerRepository.update(any(Customer.class))).thenReturn(customer);

        Customer updatedCustomer = updateCustomerUseCase.execute(customer);

        assertNotNull(updatedCustomer);
        verify(customerRepository, times(1)).update(any(Customer.class));
        assertNotEquals("password", updatedCustomer.getPassword());
    }

    @Test
    @DisplayName("Should throw RecordNotFoundException, when customer does not exist")
    void execute_whenCustomerDoesNotExist_shouldThrowRecordNotFoundException() {
        Customer customer = new Customer("Test", "Male", 21, "1234567890", "test", "0000", 1L, "test", true);

        when(customerRepository.findById(customer.getCustomerId())).thenReturn(null);

        RecordNotFoundException exception = assertThrows(RecordNotFoundException.class, () -> updateCustomerUseCase.execute(customer));
        assertEquals("Customer with id " + customer.getCustomerId() + " not found", exception.getMessage());
        verify(customerRepository, never()).update(any(Customer.class));
    }
}