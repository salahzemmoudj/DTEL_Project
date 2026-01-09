package com.srf.call_monitoring_anomaly.kafka.consumer;

import com.srf.call_monitoring_anomaly.dto.CallEventDTO;
import com.srf.call_monitoring_anomaly.entity.CallEntity;
import com.srf.call_monitoring_anomaly.repository.CallRepository;
import com.srf.call_monitoring_anomaly.service.AlertService;
import com.srf.call_monitoring_anomaly.service.AnomalyDetectionService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
@AllArgsConstructor
public class CallConsumer {

    private final CallRepository callRepository;
    private final AnomalyDetectionService anomalyService;
    private final AlertService alertService;


    /*@KafkaListener(
            topics = "call-events",
            groupId = "sfr-group",
            containerFactory = "kafkaListenerContainerFactory")*/

    @KafkaListener(
            topics = "${spring.kafka.topic.call-events}",
            groupId = "${spring.kafka.consumer.group-id}",
            containerFactory = "kafkaListenerContainerFactory")
    public void consume(CallEventDTO dto) {

        System.out.println("✅ MESSAGE KAFKA REÇU : " + dto);

        CallEntity call = new CallEntity();
        call.setCaller(dto.getCaller());
        call.setCallee(dto.getCallee());
        call.setCallType(dto.getCallType());
        call.setDuration(dto.getDuration());
        call.setSuccess(dto.isSuccess());
        call.setTimestamp(LocalDateTime.now());

        callRepository.save(call);
       // recupere tous les appels des dernieres 5 minutes
        List<CallEntity> lastCalls =
                callRepository.findByTimestampAfter(
                        LocalDateTime.now().minusMinutes(5));

       //« S’il y a une alerte, alors sauvegarde-la »
        anomalyService.detect(lastCalls)
                .ifPresent(alertService::save);
        /*
        c'est comme:
        if (alert.isPresent()) {
    alertService.save(alert.get());
}

         */
    }
}
