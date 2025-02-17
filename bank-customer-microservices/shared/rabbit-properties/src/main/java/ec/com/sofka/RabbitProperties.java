package ec.com.sofka;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:rabbit.properties")
public class RabbitProperties {

    @Value("${customer.validate.exchange}")
    private String customerValidateExchange;

    @Value("${customer.validate.queue}")
    private String customerValidateQueue;

    @Value("${customer.validate.routing.key}")
    private String customerValidateRoutingKey;

    @Value("${customer.data.exchange}")
    private String customerDataExchange;

    @Value("${customer.data.queue}")
    private String customerDataQueue;

    @Value("${customer.data.routing.key}")
    private String customerDataRoutingKey;

    public String getCustomerValidateExchange() {
        return customerValidateExchange;
    }

    public String getCustomerValidateQueue() {
        return customerValidateQueue;
    }

    public String getCustomerValidateRoutingKey() {
        return customerValidateRoutingKey;
    }

    public String getCustomerDataExchange() {
        return customerDataExchange;
    }

    public String getCustomerDataQueue() {
        return customerDataQueue;
    }

    public String getCustomerDataRoutingKey() {
        return customerDataRoutingKey;
    }
}