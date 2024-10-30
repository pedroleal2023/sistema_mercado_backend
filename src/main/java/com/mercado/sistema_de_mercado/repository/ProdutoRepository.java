package com.mercado.sistema_de_mercado.repository;

import com.mercado.sistema_de_mercado.entities.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

    List<Produto> findByNomeContainingIgnoreCase(String nome);

    @Query("SELECT p FROM Produto p WHERE p.validade <= :dataLimite")
    List<Produto> findProdutosComValidadeProxima(@Param("dataLimite") Date dataLimite);

    List<Produto> findByQuantidadeLessThan(Integer quantidadeMinima);

    List<Produto> findByPrecoBetween(BigDecimal precoMinimo, BigDecimal precoMaximo);
}

