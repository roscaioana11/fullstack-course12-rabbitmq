package ro.fasttrackit.curs12.exchange.publisher;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;
import ro.fasttrackit.curs12.model.StudentEvent;

import java.util.concurrent.atomic.AtomicInteger;

@Service
@RequiredArgsConstructor
public class PublisherService {
    private final RabbitTemplate rabbitTemplate;
    private final DirectExchange directExchange;
    private final FanoutExchange fanoutExchange;
    private final AtomicInteger count = new AtomicInteger(0);

    public void publishToDirectExchange() {
        rabbitTemplate.convertAndSend(
                directExchange.getName(),
                "students",
                new StudentEvent("Student has graduated " + count.incrementAndGet()));
    }

    public void publishToFanout(String topic) {
        rabbitTemplate.convertAndSend(
                fanoutExchange.getName(),
                topic == null ? "" : topic,
                new StudentEvent("[Fanout] Student has graduated " + count.incrementAndGet()));
    }
}
