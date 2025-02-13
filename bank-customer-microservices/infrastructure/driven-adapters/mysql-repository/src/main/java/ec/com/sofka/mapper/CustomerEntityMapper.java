package ec.com.sofka.mapper;

import ec.com.sofka.Customer;
import ec.com.sofka.entity.CustomerEntity;

public class CustomerEntityMapper {

    public static CustomerEntity toEntity(Customer customer) {
        if (customer != null) {
            return new CustomerEntity(
                    customer.getName(),
                    customer.getGender(),
                    customer.getAge(),
                    customer.getIdentifyCard(),
                    customer.getAddress(),
                    customer.getPhone(),
                    customer.getCustomerId(),
                    customer.getPassword(),
                    customer.getStatus()
                    );

        }

        return null;
    }

    public static Customer toModel(CustomerEntity customerEntity) {
        if (customerEntity != null) {
            return new Customer(
                    customerEntity.getName(),
                    customerEntity.getGender(),
                    customerEntity.getAge(),
                    customerEntity.getIdentifyCard(),
                    customerEntity.getAddress(),
                    customerEntity.getPhone(),
                    customerEntity.getCustomerId(),
                    customerEntity.getPassword(),
                    customerEntity.getStatus()
            );
        }

        return null;
    }
}