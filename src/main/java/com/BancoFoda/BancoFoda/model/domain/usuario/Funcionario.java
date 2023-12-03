package com.BancoFoda.BancoFoda.model.domain.usuario;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@DiscriminatorValue(value="funcionario")
@Getter
@Setter
@AllArgsConstructor
public class Funcionario extends Usuario
{
    @NotNull
    @NotBlank
    private String setor;

    @NotNull
    @NotBlank
    private String cargo;

    @NotNull
    @NotBlank
    private float salario;
}
