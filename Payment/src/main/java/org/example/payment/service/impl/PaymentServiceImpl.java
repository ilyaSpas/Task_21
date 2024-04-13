package org.example.payment.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.example.payment.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Value("${application.kafka.topic}")
    private String topic;

    private final KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    public PaymentServiceImpl(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void sendToShipping(String message) {
        kafkaTemplate.send(topic, message);
    }
}
