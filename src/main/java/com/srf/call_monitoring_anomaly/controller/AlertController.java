package com.srf.call_monitoring_anomaly.controller;

import com.srf.call_monitoring_anomaly.entity.AlertEntity;
import com.srf.call_monitoring_anomaly.repository.AlertRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/alerts")
@AllArgsConstructor
public class AlertController {

    private final AlertRepository repository;

    @GetMapping
    public List<AlertEntity> getAlerts() {
        return repository.findAll();
    }
}

