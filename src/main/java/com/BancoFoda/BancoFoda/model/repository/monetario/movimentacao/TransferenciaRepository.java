package com.BancoFoda.BancoFoda.model.repository.monetario.movimentacao;

import com.BancoFoda.BancoFoda.model.domain.monetario.movimentacao.Transferencia;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface TransferenciaRepository extends JpaRepository< Transferencia, Integer >
{
    @Transactional
    @Query(value = "SELECT from Transferencia WHERE u.data ?1", nativeQuery = true)
    public List<Transferencia> getTransferenciaFilteredByDate( String data );
}
