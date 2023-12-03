package com.BancoFoda.BancoFoda.model.repository.usuario;

import com.BancoFoda.BancoFoda.model.domain.usuario.Cliente;
import com.BancoFoda.BancoFoda.model.domain.usuario.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository< Funcionario, String >
{
}
