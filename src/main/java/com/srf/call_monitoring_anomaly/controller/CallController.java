package com.srf.call_monitoring_anomaly.controller;

import com.srf.call_monitoring_anomaly.dto.CallEventDTO;
import com.srf.call_monitoring_anomaly.service.CallService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/calls")
@AllArgsConstructor
public class CallController {

    private final CallService service;

    @PostMapping
    public ResponseEntity<Void> createCall(
            @RequestBody CallEventDTO dto) {

        service.process(dto);
        return ResponseEntity.accepted().build();
    }
}
