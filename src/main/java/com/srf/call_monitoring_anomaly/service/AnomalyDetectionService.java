package com.srf.call_monitoring_anomaly.service;

import com.srf.call_monitoring_anomaly.entity.AlertEntity;
import com.srf.call_monitoring_anomaly.entity.CallEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class AnomalyDetectionService {

    public Optional<AlertEntity> detect(List<CallEntity> calls) {

        // 1️⃣ Éviter les faux positifs
        if (calls.size() < 5) {
            return Optional.empty();
        }


        long failedCalls = calls.stream()
                .filter(c -> !c.isSuccess())
                .count();

        double failureRate = (double) failedCalls / calls.size();

        if (failureRate > 0.10) {
            AlertEntity alert = new AlertEntity();
            alert.setType("FAILURE_RATE");
            alert.setMessage("Taux d’échec > 10% sur 5 minutes");
            alert.setTimestamp(LocalDateTime.now());
            return Optional.of(alert);
        }
        return Optional.empty();
    }
}

