package org.example.payment.kafka;

import lombok.extern.slf4j.Slf4j;
import org.example.payment.service.PaymentService;
import org.example.payment.service.impl.PaymentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MessageListener {

    private final PaymentService paymentService;

    @Autowired
    public MessageListener(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @KafkaListener(topics = "new_order")
    public void listen(String message) {
        log.info("Заказ получен в оплту");
        paymentService.sendToShipping(message);
    }
}
