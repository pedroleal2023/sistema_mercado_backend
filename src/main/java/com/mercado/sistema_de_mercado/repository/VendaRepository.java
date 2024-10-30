package com.mercado.sistema_de_mercado.repository;

import com.mercado.sistema_de_mercado.entities.Venda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VendaRepository extends JpaRepository<Venda, Integer> {
    List<Venda> findByCpf(Integer cpf);
}

