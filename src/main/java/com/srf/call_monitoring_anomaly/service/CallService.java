package com.srf.call_monitoring_anomaly.service;

import com.srf.call_monitoring_anomaly.dto.CallEventDTO;
import com.srf.call_monitoring_anomaly.kafka.producer.CallProducer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CallService {
    private final CallProducer producer;
    public void process(CallEventDTO dto) {
        producer.send(dto);
    }
}
