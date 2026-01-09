package com.srf.call_monitoring_anomaly.service;

import com.srf.call_monitoring_anomaly.entity.AlertEntity;
import com.srf.call_monitoring_anomaly.repository.AlertRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AlertService {
    private final AlertRepository repository;
    public void save(AlertEntity alert) {
        repository.save(alert);
    }
}

