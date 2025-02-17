package ec.com.sofka;

import ec.com.sofka.gateway.BusMessageListener;
import ec.com.sofka.usecase.GetCustomerByIdUseCase;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.boot.autoconfigure.amqp.RabbitProperties;
import org.springframework.stereotype.Service;

@Service
public class CustomerValidateBusListener implements BusMessageListener {
    private final RabbitProperties rabbitProperties;
    private final GetCustomerByIdUseCase getCustomerByIdUseCase;

    public CustomerValidateBusListener(RabbitProperties rabbitProperties, GetCustomerByIdUseCase getCustomerByIdUseCase) {
        this.rabbitProperties = rabbitProperties;
        this.getCustomerByIdUseCase = getCustomerByIdUseCase;
    }

    @Override
    @RabbitListener(queues = "#{rabbitProperties.getCustomerValidateQueue()}")
    public Object reciveMessage(String customerData) {
        Customer customer = getCustomerByIdUseCase.execute(Long.parseLong(customerData));

        return customer == null ? "" : customer.getStatus();

    }

}