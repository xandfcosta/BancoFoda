package com.BancoFoda.BancoFoda.model.domain.usuario;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@DiscriminatorColumn(name = "tipo_usuario")
@Getter
@Setter
@AllArgsConstructor
public class Usuario
{
    @Id
    @Column(columnDefinition = "varchar(11)")
    private String CPF;

    @NotNull
    @NotBlank
    private String nomeCompleto;

    @NotNull
    @NotBlank
    @Email
    @Column(unique = true)
    private String email;

    @NotNull
    @Past
    @Temporal(TemporalType.DATE)
    private LocalDate dataNascimento;

    @NotNull
    @PositiveOrZero
    private float receitaMensal;

    @NotNull
    @NotBlank
    private String senha;

    public Usuario( ){}

    private static int calcularDigitoParaCPF( String str, int[] peso) {
        int soma = 0;
        for (int indice=str.length()-1, digito; indice >= 0; indice-- ) {
            digito = Integer.parseInt(str.substring(indice,indice+1));
            soma += digito*peso[peso.length-str.length()+indice];
        }
        soma = 11 - soma % 11;
        return soma > 9 ? 0 : soma;
    }

    public static boolean validarCPF(String cpf)
    {
        if ((cpf==null) || (cpf.length()!=11)) return false;

        int[] pesoCPF = {11, 10, 9, 8, 7, 6, 5, 4, 3, 2};

        int digito1 = calcularDigitoParaCPF(cpf.substring(0,9), pesoCPF);
        int digito2 = calcularDigitoParaCPF(cpf.substring(0,9) + digito1, pesoCPF);
        return cpf.equals(cpf.substring(0,9) + digito1 + digito2);
    }

    public static boolean maiorDeIdade( LocalDate dataNascimento)
    {
        return LocalDate.now().getYear() - dataNascimento.getYear() >= 18;
    }
}
