package com.mercado.sistema_de_mercado.service;

import com.mercado.sistema_de_mercado.entities.Venda;
import com.mercado.sistema_de_mercado.repository.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VendaService {

    @Autowired
    private VendaRepository vendaRepository;

    public List<Venda> listarTodos() {
        return vendaRepository.findAll();
    }

    public Venda salvar(Venda venda) {
        return vendaRepository.save(venda);
    }

    public void deletar(Integer codVenda) {
        vendaRepository.deleteById(codVenda);
    }
}

