package org.example.shipping.kafka;

import lombok.extern.slf4j.Slf4j;
import org.example.shipping.service.ShippingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MessageListener {

    private final ShippingService shippingService;

    @Autowired
    public MessageListener(ShippingService shippingService) {
        this.shippingService = shippingService;
    }

    @KafkaListener(topics = "payed_orders")
    public void listen(String message) {
        log.info("Заказ получен в отгрузку");
        shippingService.sendToNotifications(message);
    }
}
