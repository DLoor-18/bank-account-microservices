package ec.com.sofka;

import ec.com.sofka.data.CustomerResponse;
import ec.com.sofka.gateway.BusMessageListener;
import ec.com.sofka.usecase.GetCustomerByIdentifyCardUseCase;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class CustomerDataBusListener implements BusMessageListener {
    private final GetCustomerByIdentifyCardUseCase getCustomerByIdentifyCardUseCase;

    public CustomerDataBusListener(GetCustomerByIdentifyCardUseCase getCustomerByIdentifyCardUseCase) {
        this.getCustomerByIdentifyCardUseCase = getCustomerByIdentifyCardUseCase;
    }

    @Override
    @RabbitListener(queues = "#{rabbitProperties.getCustomerDataQueue()}")
    public Object reciveMessage(String customerData) {
        Customer customer = getCustomerByIdentifyCardUseCase.execute(customerData);
        return customer != null ? new CustomerResponse(customer.getCustomerId(), customer.getName()) : null;
    }

}