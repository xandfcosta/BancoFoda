package com.BancoFoda.BancoFoda.model.domain.conta;

import ch.qos.logback.core.testUtil.RandomUtil;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDate;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Cartao
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long numero;

    @NotNull
    @Enumerated( EnumType.STRING )
    private CartaoType tipo;

    @NotNull
    @Temporal( TemporalType.DATE )
    @Future
    private LocalDate validade;

    @NotNull
    @NotBlank
    @Size(min = 3, max = 3)
    private String codigoValidacao;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "conta_id")
    @OnDelete( action = OnDeleteAction.CASCADE)
    private Conta conta;

    @OneToMany(mappedBy = "cartao")
    Set<Fatura> faturas;

    public String gerarCodigoValidacao()
    {
        StringBuilder cv = new StringBuilder( );
        for(int i = 0; i < 3; i++)
        {
            cv.append( ThreadLocalRandom.current( ).nextInt( 0, 10 ) );
        }

        return cv.toString();
    }
}
