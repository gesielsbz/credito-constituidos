package com.creditos.api.controller;

import com.creditos.api.service.CreditService;
import com.creditos.api.dto.CreditoDTO;
import com.creditos.api.exception.CreditNotFoundException;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.List;
import java.math.BigDecimal;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

class CreditControllerTest {
    @Test
    void deveRetornarCreditosPorNfse() {
        CreditService service = mock(CreditService.class);
        CreditController controller = new CreditController(service);

        var credito = new CreditoDTO(
            1L,
            "123456",
            "7891011",
            LocalDate.now(),
            BigDecimal.ZERO,
            "TIPO",
            "Sim",
            BigDecimal.ZERO,
            BigDecimal.ZERO,
            BigDecimal.ZERO,
            BigDecimal.ZERO
        );

        when(service.listarCreditosNumeroNfse("7891011")).thenReturn(List.of(credito));

        ResponseEntity<List<CreditoDTO>> resposta = controller.buscarCreditoPorNfse("7891011");

        assertEquals(HttpStatus.OK, resposta.getStatusCode());
        assertNotNull(resposta.getBody());
        assertEquals(1, resposta.getBody().size());
    }

    @Test
    void deveRetornarCreditoPorNumero() throws CreditNotFoundException {
        CreditService service = mock(CreditService.class);
        CreditController controller = new CreditController(service);

        var credito = new CreditoDTO(
            1L,
            "123456",
            "7891011",
            LocalDate.now(),
            BigDecimal.ZERO,
            "TIPO",
            "Sim",
            BigDecimal.ZERO,
            BigDecimal.ZERO,
            BigDecimal.ZERO,
            BigDecimal.ZERO
        );

        when(service.buscarCreditoNumeroCredito("123456")).thenReturn(credito);

        ResponseEntity<CreditoDTO> resposta = controller.listarPorNumeroCredito("123456");

        assertEquals(HttpStatus.OK, resposta.getStatusCode());
        assertNotNull(resposta.getBody());
        assertEquals("123456", resposta.getBody().numeroCredito());
    }    
}
