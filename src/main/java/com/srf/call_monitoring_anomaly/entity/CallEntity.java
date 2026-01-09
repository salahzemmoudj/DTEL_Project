package com.srf.call_monitoring_anomaly.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "calls")
@Data
public class CallEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String caller;
    private String callee;
    private String callType;
    private int duration;
    private boolean success;
    private LocalDateTime timestamp;
}