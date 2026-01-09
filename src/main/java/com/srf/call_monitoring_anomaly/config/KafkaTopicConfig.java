package com.srf.call_monitoring_anomaly.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    @Value("${spring.kafka.topic.call-events}")
    private String callEventsTopicName;

    @Bean
    public NewTopic callEventsTopic() {
        //return TopicBuilder.name("call-events")
        return TopicBuilder.name(callEventsTopicName)
                .partitions(1)
                .replicas(1)
                .build();
    }
}

