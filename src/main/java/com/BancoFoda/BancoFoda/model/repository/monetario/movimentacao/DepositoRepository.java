package com.BancoFoda.BancoFoda.model.repository.monetario.movimentacao;

import com.BancoFoda.BancoFoda.model.domain.monetario.movimentacao.Deposito;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepositoRepository extends JpaRepository< Deposito, Integer >
{
}
