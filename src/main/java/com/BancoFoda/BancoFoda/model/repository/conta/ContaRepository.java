package com.BancoFoda.BancoFoda.model.repository.conta;

import com.BancoFoda.BancoFoda.model.domain.conta.Conta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContaRepository extends JpaRepository< Conta, Long>
{
}
