package com.BancoFoda.BancoFoda.model.repository;

import com.BancoFoda.BancoFoda.model.domain.Compra;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompraRepository extends JpaRepository<Compra, Integer>
{
}