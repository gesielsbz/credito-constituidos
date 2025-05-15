package com.creditos.api.service;

import java.util.List;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import com.creditos.api.dto.CreditoDTO;

@Service
public class CreditKafkaPublisher {
    private static final String TOPIC_CREDITO = "topic-consultas";
    private final KafkaTemplate<String, List<CreditoDTO>> kafkaTemplate;

    public CreditKafkaPublisher(KafkaTemplate<String, List<CreditoDTO>> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void publish(List<CreditoDTO> creditosDTO) {
        kafkaTemplate.send(TOPIC_CREDITO, creditosDTO);
    }
}
