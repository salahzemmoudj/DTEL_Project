package com.srf.call_monitoring_anomaly.repository;

import com.srf.call_monitoring_anomaly.entity.CallEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface CallRepository extends JpaRepository<CallEntity, Long> {
    List<CallEntity> findByTimestampAfter(LocalDateTime time);
}

