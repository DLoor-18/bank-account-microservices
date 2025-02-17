package ec.com.sofka.config;

import ec.com.sofka.RabbitProperties;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {
    private final RabbitProperties rabbitProperties;

    public RabbitConfig(RabbitProperties rabbitProperties) {
        this.rabbitProperties = rabbitProperties;
    }

    @Bean
    public MessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public AmqpTemplate rabbitTemplateBean(ConnectionFactory connectionFactory) {
        final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(jsonMessageConverter());
        return rabbitTemplate;
    }

    @Bean
    public DirectExchange customerValidateExchange() {
        return new DirectExchange(rabbitProperties.getCustomerValidateExchange(), true, false);
    }

    @Bean
    public Queue customerValidateQueue() {
        return new Queue(rabbitProperties.getCustomerValidateQueue(), true);
    }

    @Bean
    public Binding customerValidateBinding() {
        return BindingBuilder.bind(customerValidateQueue())
                .to(customerValidateExchange())
                .with(rabbitProperties.getCustomerValidateRoutingKey());
    }

    @Bean
    public DirectExchange customerDataExchange() {
        return new DirectExchange(rabbitProperties.getCustomerDataExchange(), true, false);
    }

    @Bean
    public Queue customerDataQueue() {
        return new Queue(rabbitProperties.getCustomerDataQueue(), true);
    }

    @Bean
    public Binding customerDataBinding() {
        return BindingBuilder.bind(customerDataQueue())
                .to(customerDataExchange())
                .with(rabbitProperties.getCustomerDataRoutingKey());
    }

    @Bean
    public ApplicationListener<ApplicationReadyEvent> initializeBeans(AmqpAdmin amqpAdmin) {
        return event -> {
            amqpAdmin.declareExchange(customerValidateExchange());
            amqpAdmin.declareQueue(customerValidateQueue());
            amqpAdmin.declareBinding(customerValidateBinding());

            amqpAdmin.declareExchange(customerDataExchange());
            amqpAdmin.declareQueue(customerDataQueue());
            amqpAdmin.declareBinding(customerDataBinding());
        };
    }

}