package ro.fasttrackit.curs12.simple.producer.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.fasttrackit.curs12.simple.producer.service.ProducerService;

@RestController
@RequestMapping("simple-producer")
@RequiredArgsConstructor
public class ProducerController {
    private final ProducerService producerService;

    @PostMapping
    void sendMessage() {
        producerService.sendMessage();
    }
}
