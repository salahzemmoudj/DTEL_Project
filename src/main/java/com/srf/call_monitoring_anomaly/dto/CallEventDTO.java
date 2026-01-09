package com.srf.call_monitoring_anomaly.dto;

import lombok.Data;

@Data
public class CallEventDTO {

    private String caller;
    private String callee;
    private String callType; // INCOMING / OUTGOING
    private int duration;    // secondes
    private boolean success;
}