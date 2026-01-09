package com.srf.call_monitoring_anomaly.repository;

import com.srf.call_monitoring_anomaly.entity.AlertEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlertRepository extends JpaRepository<AlertEntity, Long> {
}

