package com.BancoFoda.BancoFoda.model.dtos.usuario;

public record ClienteDTO( String cpf, String nomeCompleto, String email, String dataNascimento, Float receitaMensal, String senha )
{
}
