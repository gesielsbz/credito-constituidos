package com.creditos.api.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="credito")
public class Credito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "numero_credito", length = 50, nullable = false, unique = true)
    private String numeroCredito;

    @Column(name = "numero_nfse", length = 50, nullable = false)
    private String numeroNfse;

    @Column(name = "data_constituicao", nullable = false)
    private LocalDate dataConstituicao;

    @Column(name = "valor_issqn", precision = 15, scale = 2, nullable = false)
    private BigDecimal valorIssqn;

    @Column(name = "tipo_credito", length = 50, nullable = false)
    private String tipoCredito;

    @Column(name = "simples_nacional", nullable = false)
    private Boolean simplesNacional;

    @Column(name = "aliquota", precision = 5, scale = 2, nullable = false)
    private BigDecimal aliquota;

    @Column(name = "valor_faturado", precision = 15, scale = 2, nullable = false)
    private BigDecimal valorFaturado;

    @Column(name = "valor_deducao", precision = 15, scale = 2, nullable = false)
    private BigDecimal valorDeducao;

    @Column(name = "base_calculo", precision = 15, scale = 2, nullable = false)
    private BigDecimal baseCalculo;

    public Credito() {
    }

    public Credito(
            Long id,
            String numeroCredito,
            String numeroNfse,
            LocalDate dataConstituicao,
            BigDecimal valorIssqn,
            String tipoCredito,
            Boolean simplesNacional,
            BigDecimal aliquota,
            BigDecimal valorFaturado,
            BigDecimal valorDeducao,
            BigDecimal baseCalculo
    ) {
        this.id = id;
        this.numeroCredito = numeroCredito;
        this.numeroNfse = numeroNfse;
        this.dataConstituicao = dataConstituicao;
        this.valorIssqn = valorIssqn;
        this.tipoCredito = tipoCredito;
        this.simplesNacional = simplesNacional;
        this.aliquota = aliquota;
        this.valorFaturado = valorFaturado;
        this.valorDeducao = valorDeducao;
        this.baseCalculo = baseCalculo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumeroCredito() {
        return numeroCredito;
    }

    public void setNumeroCredito(String numeroCredito) {
        this.numeroCredito = numeroCredito;
    }

    public String getNumeroNfse() {
        return numeroNfse;
    }

    public void setNumeroNfse(String numeroNfse) {
        this.numeroNfse = numeroNfse;
    }

    public LocalDate getDataConstituicao() {
        return dataConstituicao;
    }

    public void setDataConstituicao(LocalDate dataConstituicao) {
        this.dataConstituicao = dataConstituicao;
    }

    public BigDecimal getValorIssqn() {
        return valorIssqn;
    }

    public void setValorIssqn(BigDecimal valorIssqn) {
        this.valorIssqn = valorIssqn;
    }

    public String getTipoCredito() {
        return tipoCredito;
    }

    public void setTipoCredito(String tipoCredito) {
        this.tipoCredito = tipoCredito;
    }

    public Boolean getSimplesNacional() {
        return simplesNacional;
    }

    public void setSimplesNacional(Boolean simplesNacional) {
        this.simplesNacional = simplesNacional;
    }

    public BigDecimal getAliquota() {
        return aliquota;
    }

    public void setAliquota(BigDecimal aliquota) {
        this.aliquota = aliquota;
    }

    public BigDecimal getValorFaturado() {
        return valorFaturado;
    }

    public void setValorFaturado(BigDecimal valorFaturado) {
        this.valorFaturado = valorFaturado;
    }

    public BigDecimal getValorDeducao() {
        return valorDeducao;
    }

    public void setValorDeducao(BigDecimal valorDeducao) {
        this.valorDeducao = valorDeducao;
    }

    public BigDecimal getBaseCalculo() {
        return baseCalculo;
    }

    public void setBaseCalculo(BigDecimal baseCalculo) {
        this.baseCalculo = baseCalculo;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Credito credito = (Credito) o;
        return Objects.equals(id, credito.id) &&
                Objects.equals(numeroCredito, credito.numeroCredito) &&
                Objects.equals(numeroNfse, credito.numeroNfse) &&
                Objects.equals(dataConstituicao, credito.dataConstituicao) &&
                Objects.equals(valorIssqn, credito.valorIssqn) &&
                Objects.equals(tipoCredito, credito.tipoCredito) &&
                Objects.equals(simplesNacional, credito.simplesNacional) &&
                Objects.equals(aliquota, credito.aliquota) &&
                Objects.equals(valorFaturado, credito.valorFaturado) &&
                Objects.equals(valorDeducao, credito.valorDeducao) &&
                Objects.equals(baseCalculo, credito.baseCalculo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                id,
                numeroCredito,
                numeroNfse,
                dataConstituicao,
                valorIssqn,
                tipoCredito,
                simplesNacional,
                aliquota,
                valorFaturado,
                valorDeducao,
                baseCalculo
        );
    }
}
