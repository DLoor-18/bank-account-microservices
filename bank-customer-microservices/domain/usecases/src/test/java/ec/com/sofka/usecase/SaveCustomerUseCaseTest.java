package ec.com.sofka.usecase;

import ec.com.sofka.Customer;
import ec.com.sofka.exceptions.ConflictException;
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
@DisplayName("SaveCustomerUseCase")
public class SaveCustomerUseCaseTest {

    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private SaveCustomerUseCase saveCustomerUseCase;

    @Test
    @DisplayName("Should save customer, when identify card is unique")
    void execute_whenIdentifyCardIsUnique_shouldSaveCustomer() {
        Customer customer = new Customer("Test", "Male", 21, "1234567890", "test", "0000", 1L, "test", true);

        when(customerRepository.findByIdentifyCard(customer.getIdentifyCard())).thenReturn(null);
        when(customerRepository.save(any(Customer.class))).thenReturn(customer);

        Customer savedCustomer = saveCustomerUseCase.execute(customer);

        assertNotNull(savedCustomer);
        verify(customerRepository, times(1)).save(any(Customer.class));
        assertNotEquals("password", savedCustomer.getPassword());
    }

    @Test
    @DisplayName("Should throw ConflictException, when identify card already exists")
    void execute_whenIdentifyCardAlreadyExists_shouldThrowConflictException() {
        Customer customer = new Customer("Test", "Male", 21, "1234567890", "test", "0000", 1L, "test", true);
        customer.setIdentifyCard("123456789");

        when(customerRepository.findByIdentifyCard(customer.getIdentifyCard())).thenReturn(customer);

        assertThrows(ConflictException.class, () -> saveCustomerUseCase.execute(customer));
        verify(customerRepository, never()).save(any(Customer.class));
    }
}