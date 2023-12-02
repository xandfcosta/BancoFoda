package com.BancoFoda.BancoFoda.model.repository;

import com.BancoFoda.BancoFoda.model.domain.Conta;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ContaRepository extends JpaRepository< Conta, Integer>
{
    @Transactional
    @Query(value = "SELECT u FROM Conta WHERE u.saldo ?1", nativeQuery = true)
    public List<Conta> findUserFilteredBySaldo( String saldo );
}
