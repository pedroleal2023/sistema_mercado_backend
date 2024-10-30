package com.mercado.sistema_de_mercado.service;

import com.mercado.sistema_de_mercado.entities.Funcionario;
import com.mercado.sistema_de_mercado.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public List<Funcionario> listarTodos() {
        return funcionarioRepository.findAll();
    }

    public Funcionario buscarPorCpf(Integer cpf) {
        return funcionarioRepository.findByCpf(cpf);
    }

    public Funcionario salvar(Funcionario funcionario) {
        return funcionarioRepository.save(funcionario);
    }

    public void deletar(Integer cpf) {
        funcionarioRepository.deleteById(cpf);
    }
}

