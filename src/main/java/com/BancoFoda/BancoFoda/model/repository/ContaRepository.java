package com.BancoFoda.BancoFoda.model.repository;

import com.BancoFoda.BancoFoda.model.domain.Conta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContaRepository extends JpaRepository< Conta, Integer>
{
}
