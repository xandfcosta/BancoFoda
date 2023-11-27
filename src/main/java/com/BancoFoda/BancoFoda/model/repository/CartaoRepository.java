package com.BancoFoda.BancoFoda.model.repository;

import com.BancoFoda.BancoFoda.model.domain.Cartao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartaoRepository extends JpaRepository< Cartao, String>
{
}
