package org.example.shipping.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.example.shipping.service.ShippingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ShippingServiceImpl implements ShippingService {

    @Value("${application.kafka.topic}")
    private String topic;

    private final KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    public ShippingServiceImpl(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void sendToNotifications(String message) {
        log.info("Отправляется уведомление");
        kafkaTemplate.send(topic, message);
    }
}
