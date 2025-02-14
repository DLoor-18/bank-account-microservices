package ec.com.sofka.gateway;

import ec.com.sofka.Customer;

import java.util.List;

public interface CustomerRepository {
    Customer save(Customer customer);
    List<Customer> findAll();
    Customer update(Customer customer);
    void delete(Long id);
    Customer findById(Long id);
    Customer findByIdentifyCard(String identifyCard);
}