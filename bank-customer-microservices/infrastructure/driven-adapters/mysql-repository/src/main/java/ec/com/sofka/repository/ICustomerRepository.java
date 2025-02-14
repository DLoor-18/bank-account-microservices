package ec.com.sofka.repository;

import ec.com.sofka.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerRepository extends JpaRepository<CustomerEntity, Long> {

    CustomerEntity findByIdentifyCard(String identifyCard);

}