package ec.com.sofka;

import com.fasterxml.jackson.databind.ObjectMapper;
import ec.com.sofka.data.CustomerResponse;
import ec.com.sofka.gateway.CustomerDataBussMessage;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;

@Service
public class CustomerDataBussAdapter implements CustomerDataBussMessage {
    private final RabbitTemplate rabbitTemplate;
    private final RabbitProperties rabbitProperties;

    public CustomerDataBussAdapter(RabbitTemplate rabbitTemplate, RabbitProperties rabbitProperties) {
        this.rabbitTemplate = rabbitTemplate;
        this.rabbitProperties = rabbitProperties;
    }

    @Override
    public Object sendMessage(String customerData) {
        Object response = rabbitTemplate.convertSendAndReceive(
                rabbitProperties.getCustomerDataExchange(),
                rabbitProperties.getCustomerDataRoutingKey(),
                customerData
        );

        if (response instanceof LinkedHashMap) {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.convertValue(response, CustomerResponse.class);
        }

        return response;
    }
}
