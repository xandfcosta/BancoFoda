package com.BancoFoda.BancoFoda.model.repository;

import com.BancoFoda.BancoFoda.model.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository< Cliente, String>
{
}
