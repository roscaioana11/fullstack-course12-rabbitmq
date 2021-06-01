package ro.fasttrackit.curs12.simple.consumer;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import ro.fasttrackit.curs12.model.SumJob;

@Slf4j
@Component
@RabbitListener(queues = "sum.queue")
public class SumWorker {
    @SneakyThrows
    @RabbitHandler
    void calculateSum(SumJob job) {
        log.info("Received job " + job);
        Thread.sleep(2000);
        log.info(job.getDescription() + " : " + (job.getA() + job.getB()));
    }
}
