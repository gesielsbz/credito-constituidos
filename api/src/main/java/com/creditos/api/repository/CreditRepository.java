package com.creditos.api.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.creditos.api.model.Credito;

@Repository
public interface CreditRepository extends JpaRepository<Credito, Long>{
	   List<Credito> findByNumeroNfse(String numeroNfse);

	   Optional<Credito> findByNumeroCredito(String numeroCredito);
}
