package com.BancoFoda.BancoFoda.model.domain.usuario;

import com.BancoFoda.BancoFoda.model.domain.conta.Conta;
import jakarta.persistence.*;
import lombok.*;

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
