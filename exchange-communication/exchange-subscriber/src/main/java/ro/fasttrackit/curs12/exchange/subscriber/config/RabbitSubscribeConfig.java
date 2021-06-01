package ro.fasttrackit.curs12.exchange.subscriber.config;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.*;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class RabbitSubscribeConfig {
    @Bean
    DirectExchange directExchange() {
        return new DirectExchange("fasttrack.direct");
    }

    @Bean
    Queue directQueue() {
        return new AnonymousQueue();
    }

    @Bean
    Binding directBinding(DirectExchange directExchange, Queue directQueue) {
        return BindingBuilder.bind(directQueue).to(directExchange).with("students");
    }

    @Bean
    Queue sumQueue() {
        return new AnonymousQueue();
    }

    @Bean
    Binding sumBinding(DirectExchange directExchange, Queue sumQueue) {
        return BindingBuilder.bind(sumQueue).to(directExchange).with("sum.jobs");
    }

    @Bean
    FanoutExchange fanoutExchange() {
        return new FanoutExchange("fasttrackit.fanout");
    }

    @Bean
    Queue fanoutQueue() {
        return new AnonymousQueue();
    }

    @Bean
    Binding fanoutBinding(Queue fanoutQueue, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(fanoutQueue).to(fanoutExchange);
    }

    @Bean
    public MessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

}
