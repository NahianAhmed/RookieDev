package com.nahian.github.io.rookiedev.controllers;

import com.nahian.github.io.rookiedev.objects.TokenRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@Log4j2
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class KafkaController {
    private final KafkaTemplate<String, Object> template;

    private static final String KAFKA_TOPIC = "rookiedev";

    @GetMapping("/kafka/produce/{text}")
    public String produceInKafka(@PathVariable String text) {
        template.send(KAFKA_TOPIC, text);
        return text;
    }

    @PostMapping("/kafka/produce/")
    public TokenRequest produceInKafka(@RequestBody TokenRequest tokenRequest) {
        template.send(KAFKA_TOPIC, tokenRequest);
        return tokenRequest;
    }
}
