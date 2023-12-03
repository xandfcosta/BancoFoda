package com.BancoFoda.BancoFoda.model.repository.conta;

import com.BancoFoda.BancoFoda.model.domain.conta.Fatura;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FaturaRepository extends JpaRepository< Fatura, Long>
{
    Optional< List<Fatura> > findByDataVencimento( String data);
}
