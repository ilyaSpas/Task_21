package org.example.notifications.kafka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MessageListener {

    @KafkaListener(topics = "notifications")
    public void listen(String message) {
        log.info("Получено уведомление о заказе {}", message);
    }
}
