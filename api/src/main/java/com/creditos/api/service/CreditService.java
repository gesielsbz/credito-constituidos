package com.creditos.api.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import com.creditos.api.dto.CreditoDTO;
import com.creditos.api.exception.CreditNotFoundException;
import com.creditos.api.model.Credito;
import com.creditos.api.repository.CreditRepository;

@Service
public class CreditService {
    private final CreditRepository creditRepository;
    private final CreditKafkaPublisher kafkaPublisher;

    public CreditService(CreditRepository creditRepository, CreditKafkaPublisher kafkaPublisher) {
        this.creditRepository = creditRepository;
        this.kafkaPublisher = kafkaPublisher;
    }

    public List<CreditoDTO> listarCreditosNumeroNfse(String numeroNfse) {
        if (numeroNfse == null || numeroNfse.isEmpty()) {
            throw new IllegalArgumentException("Número NFS-e não pode ser vazio.");
        }

        List<Credito> credits = this.creditRepository.findByNumeroNfse(numeroNfse);

        List<CreditoDTO> listCreditsDTO = credits.stream().map(credit -> new CreditoDTO(
                credit.getId(),
                credit.getNumeroCredito(),
                credit.getNumeroNfse(),
                credit.getDataConstituicao(),
                credit.getValorIssqn(),
                credit.getTipoCredito(),
                credit.getSimplesNacional() ? "Sim" : "Não",
                credit.getAliquota(),
                (credit.getValorFaturado()),
                (credit.getValorDeducao()),
                (credit.getBaseCalculo())
        )).collect(Collectors.toList());

        this.kafkaPublisher.publish(listCreditsDTO);

        return listCreditsDTO;
    }

    public CreditoDTO buscarCreditoNumeroCredito(String numeroCredito) throws CreditNotFoundException {
        if (numeroCredito == null || numeroCredito.isEmpty()) {
            throw new IllegalArgumentException("Número do crédito não pode ser vazio.");
        }

        Optional<Credito> creditoOptional = creditRepository.findByNumeroCredito(numeroCredito);

        Credito credito = creditoOptional.orElseThrow(() -> new CreditNotFoundException("Crédito não encontrado."));

        CreditoDTO dto = new CreditoDTO(
                credito.getId(),
                credito.getNumeroCredito(),
                credito.getNumeroNfse(),
                credito.getDataConstituicao(),
                credito.getValorIssqn(),
                credito.getTipoCredito(),
                credito.getSimplesNacional() ? "Sim" : "Não",
                credito.getAliquota(),
                (credito.getValorFaturado()),
                (credito.getValorDeducao()),
                (credito.getBaseCalculo())
        );

        List<CreditoDTO> list = new ArrayList<>();

        list.add(dto);

        this.kafkaPublisher.publish(list);

        return dto;
    }
}
