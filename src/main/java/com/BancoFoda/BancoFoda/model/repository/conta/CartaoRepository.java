package com.BancoFoda.BancoFoda.model.repository.conta;

import com.BancoFoda.BancoFoda.model.domain.conta.Cartao;
import com.BancoFoda.BancoFoda.model.domain.conta.Fatura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CartaoRepository extends JpaRepository< Cartao, Long>
{
    @Query(value = "SELECT * FROM cartao c WHERE c.validade = ?1", nativeQuery = true)
<<<<<<< Updated upstream
    Optional< List<Cartao> > findByValidade( String data );
=======
    Optional< List<Cartao> > findByValidade( String data);
>>>>>>> Stashed changes
}
