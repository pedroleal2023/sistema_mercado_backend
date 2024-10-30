package com.mercado.sistema_de_mercado.controller;

import com.mercado.sistema_de_mercado.entities.Produto;
import com.mercado.sistema_de_mercado.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public List<Produto> listarTodos() {
        return produtoService.listarTodos();
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<Produto> buscarPorCodigo(@PathVariable Integer codigo) {
        Produto produto = produtoService.buscarPorCodigo(codigo);
        return produto != null ? ResponseEntity.ok(produto) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public Produto salvar(@RequestBody Produto produto) {
        return produtoService.salvar(produto);
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity<Void> deletar(@PathVariable Integer codigo) {
        produtoService.deletar(codigo);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/buscar")
    public List<Produto> buscarPorNome(@RequestParam String nome) {
        return produtoService.buscarPorNome(nome);
    }

    @GetMapping("/validade")
    public List<Produto> produtosComValidadeProxima(@RequestParam Date dataLimite) {
        return produtoService.produtosComValidadeProxima(dataLimite);
    }

    @GetMapping("/estoque")
    public List<Produto> buscarPorQuantidadeMinima(@RequestParam Integer quantidadeMinima) {
        return produtoService.buscarPorQuantidadeMinima(quantidadeMinima);
    }

    @GetMapping("/preco")
    public List<Produto> buscarPorFaixaDePreco(@RequestParam BigDecimal precoMinimo, @RequestParam BigDecimal precoMaximo) {
        return produtoService.buscarPorFaixaDePreco(precoMinimo, precoMaximo);
    }
}

