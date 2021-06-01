package ro.fasttrackit.curs12.simple.producer.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;
import ro.fasttrackit.curs12.model.SumJob;

import java.util.Random;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProducerService {
    private final RabbitTemplate rabbit;
    private final Queue jobQueue;

    public void sendMessage() {
        log.info("sending");
        Random random = new Random();
        rabbit.convertAndSend(jobQueue.getName(),
                new SumJob(random.nextInt(1000), random.nextInt(1000), "Please sum this!"));
    }
}
