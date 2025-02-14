package ec.com.sofka.adapter;

import ec.com.sofka.Customer;
import ec.com.sofka.gateway.CustomerRepository;
import ec.com.sofka.mapper.CustomerEntityMapper;
import ec.com.sofka.repository.ICustomerRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ICustomerAdapter implements CustomerRepository {
    private final ICustomerRepository customerRepository;

    public ICustomerAdapter(ICustomerRepository ICustomerRepository) {
        this.customerRepository = ICustomerRepository;
    }

    @Override
    public Customer save(Customer customer) {
        return CustomerEntityMapper.toModel(
                customerRepository.save(CustomerEntityMapper.toEntity(customer)));

    }

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll().stream()
                .map(CustomerEntityMapper::toModel)
                .collect(Collectors.toList());
    }

    @Override
    public Customer update(Customer customer) {
        return CustomerEntityMapper.toModel(
                customerRepository.save(CustomerEntityMapper.toEntity(customer)));
    }

    @Override
    public void delete(Long id) {
        customerRepository.deleteById(id);
    }

    @Override
    public Customer findById(Long id) {
        return CustomerEntityMapper.toModel(customerRepository.findById(id).orElse(null));
    }

    @Override
    public Customer findByIdentifyCard(String identifyCard) {
        return CustomerEntityMapper.toModel(customerRepository.findByIdentifyCard(identifyCard));
    }

}