package com.BancoFoda.BancoFoda.model.repository.conta;

import com.BancoFoda.BancoFoda.model.domain.conta.Fatura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface FaturaRepository extends JpaRepository< Fatura, Long>
{
    @Query(value = "SELECT * FROM fatura f WHERE f.data_vencimento = ?1", nativeQuery = true)
    Optional< List<Fatura> > findByDataVencimento( String data );
}
