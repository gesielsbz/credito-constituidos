package com.creditos.api.messaging;

import org.junit.jupiter.api.Test;
import org.springframework.kafka.core.KafkaTemplate;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import com.creditos.api.service.CreditKafkaPublisher;
import com.creditos.api.dto.CreditoDTO;
import java.util.List;

class CreditKafkaPublisherTest {
    @Test
    void deveEnviarMensagemParaKafka() {
        @SuppressWarnings("unchecked")
        KafkaTemplate<String, List<CreditoDTO>> kafkaTemplate = mock(KafkaTemplate.class);
        CreditKafkaPublisher service = new CreditKafkaPublisher(kafkaTemplate);

        List<CreditoDTO> creditos = List.of();
        service.publish(creditos);

        verify(kafkaTemplate).send("topic-consultas", creditos);
    }    
}
