package ec.com.sofka.mapper;

import ec.com.sofka.Customer;
import ec.com.sofka.data.CustomerRequestDTO;
import ec.com.sofka.data.CustomerResponseDTO;
import ec.com.sofka.data.CustomerUpdateRequestDTO;

public class CustomerMapper {

    public static Customer toModel(CustomerRequestDTO customer) {
        if (customer != null) {
            return new Customer(
                    customer.getName(),
                    customer.getGender(),
                    customer.getAge(),
                    customer.getIdentifyCard(),
                    customer.getAddress(),
                    customer.getPhone(),
                    null,
                    customer.getPassword(),
                    customer.getStatus()
            );
        }

        return null;
    }

    public static Customer updateToModel(CustomerUpdateRequestDTO customer) {
        if (customer != null) {
            return new Customer(
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

    public static CustomerResponseDTO toResponseDto(Customer customer) {
        if (customer != null) {
            return new CustomerResponseDTO(
                    customer.getCustomerId(),
                    customer.getStatus(),
                    customer.getName(),
                    customer.getGender(),
                    customer.getAge(),
                    customer.getIdentifyCard(),
                    customer.getAddress(),
                    customer.getPhone()
            );
        }

        return null;
    }
}