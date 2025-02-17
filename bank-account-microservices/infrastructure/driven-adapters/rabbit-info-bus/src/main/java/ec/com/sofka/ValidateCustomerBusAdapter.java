package ec.com.sofka;

import com.fasterxml.jackson.databind.ObjectMapper;
import ec.com.sofka.gateway.ValidateCustomerBusMessage;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;

@Service
public class ValidateCustomerBusAdapter implements ValidateCustomerBusMessage {
    private final RabbitTemplate rabbitTemplate;
    private final RabbitProperties rabbitProperties;

    public ValidateCustomerBusAdapter(RabbitTemplate rabbitTemplate, RabbitProperties rabbitProperties) {
        this.rabbitTemplate = rabbitTemplate;
        this.rabbitProperties = rabbitProperties;
    }

    @Override
    public Object sendMessage(String customerData) {
        Object response = rabbitTemplate.convertSendAndReceive(
                rabbitProperties.getCustomerValidateExchange(),
                rabbitProperties.getCustomerValidateRoutingKey(),
                customerData
        );

        if (response instanceof LinkedHashMap) {
                ObjectMapper objectMapper = new ObjectMapper();
                return objectMapper.convertValue(response, Object.class);
        }

        return response;
    }
}