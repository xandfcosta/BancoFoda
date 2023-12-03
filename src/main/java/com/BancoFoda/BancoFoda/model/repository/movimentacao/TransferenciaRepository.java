package com.BancoFoda.BancoFoda.model.repository.movimentacao;

import com.BancoFoda.BancoFoda.model.domain.movimentacao.Transferencia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransferenciaRepository extends JpaRepository< Transferencia, Integer >
{
}
