package com.creditos.api.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.creditos.api.model.Credito;
import com.creditos.api.dto.CreditoDTO;
import com.creditos.api.repository.CreditRepository;
import com.creditos.api.service.CreditKafkaPublisher;
import com.creditos.api.service.CreditService;
import com.creditos.api.exception.CreditNotFoundException;
import java.util.List;
import java.util.Optional;

class CreditServiceTest {

    private CreditRepository repository;
    private CreditKafkaPublisher mensageriaService;
    private CreditService service;

    @BeforeEach
    void setUp() {
        repository = mock(CreditRepository.class);
        mensageriaService = mock(CreditKafkaPublisher.class);
        service = new CreditService(repository, mensageriaService);
    }

    @Test
    void deveBuscarCreditosPorNumeroNfse() {
        var credito = new Credito();
        credito.setNumeroNfse("7891011");
        when(repository.findByNumeroNfse("7891011")).thenReturn(List.of(credito));

        List<CreditoDTO> resultado = service.listarCreditosNumeroNfse("7891011");

        assertEquals(1, resultado.size());
        verify(mensageriaService).publish(resultado);
    }

    @Test
    void deveBuscarCreditoPorNumero() throws CreditNotFoundException {
        var credito = new Credito();
        credito.setNumeroCredito("123456");
        when(repository.findByNumeroCredito("123456")).thenReturn(Optional.of(credito));

        var resultado = service.buscarCreditoNumeroCredito("123456");

        assertNotNull(resultado);
        assertEquals("123456", resultado.numeroCredito());
        verify(mensageriaService).publish(List.of(resultado));
    }

    @Test
    void deveLancarExcecaoQuandoCreditoNaoExiste() {
        when(repository.findByNumeroCredito("555")).thenReturn(Optional.empty());

        assertThrows(CreditNotFoundException.class, () -> service.buscarCreditoNumeroCredito("555"));
    }    
}
