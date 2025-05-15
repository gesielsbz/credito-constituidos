
package com.creditos.api.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import com.creditos.api.dto.CreditoDTO;
import com.creditos.api.exception.CreditNotFoundException;
import com.creditos.api.service.CreditService;

@RestController
@RequestMapping("/api/creditos")
@CrossOrigin(origins = "*")
public class CreditController {
    private final CreditService service;

    public CreditController(CreditService service) {
        this.service = service;
    }

    @Operation(summary = "Obtém crédito por número de NFS-e")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "NFS-e encontrado"),
            @ApiResponse(responseCode = "404", description = "NFS-e não encontrado")
    })
    @GetMapping("/{numeroNfse}")
    public ResponseEntity<List<CreditoDTO>> buscarCreditoPorNfse(@PathVariable String numeroNfse) {
        try {
            List<CreditoDTO> list = service.listarCreditosNumeroNfse(numeroNfse);
            return ResponseEntity.ok(list);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary = "Obtém crédito por número de crédito")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Crédito encontrado"),
            @ApiResponse(responseCode = "404", description = "Crédito não encontrado")
    })    
    @GetMapping("/credito/{numeroCredito}")
    public ResponseEntity<CreditoDTO> listarPorNumeroCredito(@PathVariable String numeroCredito) {
        CreditoDTO credito = null;
        try {
            credito = service.buscarCreditoNumeroCredito(numeroCredito);
        } catch (CreditNotFoundException e) {
            throw new RuntimeException(e);
        }
        return ResponseEntity.ok(credito);
    }
}
