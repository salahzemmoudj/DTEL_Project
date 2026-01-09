package com.srf.call_monitoring_anomaly.kafka.producer;

import com.srf.call_monitoring_anomaly.dto.CallEventDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class CallProducer {


    private final KafkaTemplate<String, CallEventDTO> kafkaTemplate;

    @Value("${spring.kafka.topic.call-events}")
    private String topic;

    // Injection du KafkaTemplate via constructeur
    public CallProducer(KafkaTemplate<String, CallEventDTO> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void send(CallEventDTO dto) {
        //kafkaTemplate.send("call-events", dto);
        kafkaTemplate.send(topic, dto);
    }
}

