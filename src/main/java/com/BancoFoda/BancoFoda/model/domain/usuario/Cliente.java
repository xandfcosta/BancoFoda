package com.BancoFoda.BancoFoda.model.domain.usuario;

import com.BancoFoda.BancoFoda.model.domain.Conta;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import lombok.*;

import java.util.Set;

@Entity
@DiscriminatorValue(value="cliente")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Cliente extends Usuario
{
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "conta_id")
    private Conta conta;
}
