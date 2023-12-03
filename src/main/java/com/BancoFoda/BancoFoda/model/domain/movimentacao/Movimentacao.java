package com.BancoFoda.BancoFoda.model.domain.movimentacao;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "tipo_movimentacao")
@Getter
@Setter
@AllArgsConstructor
public class Movimentacao
{
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;

    @NotNull
    @Positive
    private float valor;

    @PastOrPresent
    private LocalDate data;

    public Movimentacao( ){}
}
