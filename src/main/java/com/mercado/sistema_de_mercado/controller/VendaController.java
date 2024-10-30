package com.mercado.sistema_de_mercado.controller;

import com.mercado.sistema_de_mercado.entities.Venda;
import com.mercado.sistema_de_mercado.service.VendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vendas")
public class VendaController {

    @Autowired
    private VendaService vendaService;

    @GetMapping
    public List<Venda> listarTodos() {
        return vendaService.listarTodos();
    }

    @PostMapping
    public Venda salvar(@RequestBody Venda venda) {
        return vendaService.salvar(venda);
    }

    @DeleteMapping("/{codVenda}")
    public ResponseEntity<Void> deletar(@PathVariable Integer codVenda) {
        vendaService.deletar(codVenda);
        return ResponseEntity.noContent().build();
    }
}

