package org.example.orders.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.example.orders.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    private final KafkaTemplate<String, String> kafkaTemplate;

    @Value("${application.kafka.topic}")
    private String topic;

    @Autowired
    public OrderServiceImpl(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void create(String order) {
        log.info("Создан новый заказ");
        kafkaTemplate.send(topic, order);
    }
}
