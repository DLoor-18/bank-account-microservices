package ec.com.sofka.usecase;

import ec.com.sofka.Customer;
import ec.com.sofka.gateway.CustomerRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@DisplayName("FindAllCustomerUseCase")
public class FindAllCustomerUseCaseTest {
    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private FindAllCustomerUseCase findAllCustomerUseCase;

    @Test
    @DisplayName("Should return all customers, when customers exist")
    void execute_whenCustomersExist_shouldReturnAllCustomers() {
        List<Customer> expectedCustomers = Arrays.asList(new Customer("Test", "Male", 21, "1234567890", "test", "0000", 1L, "test", true));
        when(customerRepository.findAll()).thenReturn(expectedCustomers);

        List<Customer> actualCustomers = findAllCustomerUseCase.execute();

        assertEquals(expectedCustomers, actualCustomers);
    }

    @Test
    @DisplayName("Should return empty list, when no customers exist")
    void execute_whenNoCustomersExist_shouldReturnEmptyList() {
        List<Customer> expectedCustomers = Arrays.asList();
        when(customerRepository.findAll()).thenReturn(expectedCustomers);

        List<Customer> actualCustomers = findAllCustomerUseCase.execute();

        assertEquals(expectedCustomers, actualCustomers);
    }
}
