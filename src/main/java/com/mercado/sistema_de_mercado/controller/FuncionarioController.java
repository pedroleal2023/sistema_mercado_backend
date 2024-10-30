package com.mercado.sistema_de_mercado.controller;

import com.mercado.sistema_de_mercado.entities.Funcionario;
import com.mercado.sistema_de_mercado.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/funcionarios")
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    @GetMapping
    public List<Funcionario> listarTodos() {
        return funcionarioService.listarTodos();
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<Funcionario> buscarPorCpf(@PathVariable Integer cpf) {
        Funcionario funcionario = funcionarioService.buscarPorCpf(cpf);
        return funcionario != null ? ResponseEntity.ok(funcionario) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public Funcionario salvar(@RequestBody Funcionario funcionario) {
        return funcionarioService.salvar(funcionario);
    }

    @DeleteMapping("/{cpf}")
    public ResponseEntity<Void> deletar(@PathVariable Integer cpf) {
        funcionarioService.deletar(cpf);
        return ResponseEntity.noContent().build();
    }
}

