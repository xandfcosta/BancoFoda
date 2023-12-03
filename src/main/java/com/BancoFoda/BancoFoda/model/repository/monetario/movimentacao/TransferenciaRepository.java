package com.BancoFoda.BancoFoda.model.repository.monetario.movimentacao;

import com.BancoFoda.BancoFoda.model.domain.monetario.movimentacao.Transferencia;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface TransferenciaRepository extends JpaRepository< Transferencia, Integer >
{
}
