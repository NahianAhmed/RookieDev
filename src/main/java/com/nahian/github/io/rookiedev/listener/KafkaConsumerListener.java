package com.nahian.github.io.rookiedev.listener;

import com.nahian.github.io.rookiedev.models.User;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Log4j2
@Service
public class KafkaConsumerListener {
    private static final String KAFKA_TOPIC = "user";

    @KafkaListener(topics = KAFKA_TOPIC, groupId = "group_1", containerFactory = "kafkaListenerContainerFactory")
    public void userListener(User user) {
        log.info("kafka lister for " + user);
    }


}
