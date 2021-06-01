package ro.fasttrackit.curs12.exchange.publisher;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("exchange-publisher")
@RequiredArgsConstructor
public class PublisherController {
    private final PublisherService service;

    @PostMapping("direct")
    void directExchange() {
        service.publishToDirectExchange();
    }

    @PostMapping("fanout/{topic}")
    void fanoutExchange(@PathVariable String topic) {
        service.publishToFanout(topic);
    }
}
