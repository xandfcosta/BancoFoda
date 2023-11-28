package com.BancoFoda.BancoFoda.model.repository.usuario;

import com.BancoFoda.BancoFoda.model.domain.usuario.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository< Cliente, String >
{
}
