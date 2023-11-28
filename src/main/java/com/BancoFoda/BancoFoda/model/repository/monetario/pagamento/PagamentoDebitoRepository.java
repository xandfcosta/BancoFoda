package com.BancoFoda.BancoFoda.model.repository.monetario.pagamento;

import com.BancoFoda.BancoFoda.model.domain.monetario.pagamento.PagamentoDebito;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PagamentoDebitoRepository extends JpaRepository< PagamentoDebito, Integer>
{
}