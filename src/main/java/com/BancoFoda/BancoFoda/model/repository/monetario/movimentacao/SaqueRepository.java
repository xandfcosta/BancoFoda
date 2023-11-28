package com.BancoFoda.BancoFoda.model.repository.monetario.movimentacao;

import com.BancoFoda.BancoFoda.model.domain.monetario.movimentacao.Saque;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaqueRepository extends JpaRepository< Saque, Integer >
{
}
