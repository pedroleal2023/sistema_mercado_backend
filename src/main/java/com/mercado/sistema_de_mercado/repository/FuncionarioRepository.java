package com.mercado.sistema_de_mercado.repository;

import com.mercado.sistema_de_mercado.entities.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
    public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer> {
        Funcionario findByCpf(Integer cpf);
    }


