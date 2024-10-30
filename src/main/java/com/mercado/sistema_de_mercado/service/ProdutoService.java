package com.mercado.sistema_de_mercado.service;

import com.mercado.sistema_de_mercado.entities.Produto;
import com.mercado.sistema_de_mercado.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public List<Produto> listarTodos() {
        return produtoRepository.findAll();
    }

    public Produto buscarPorCodigo(Integer codigo) {
        return produtoRepository.findById(codigo).orElse(null);
    }

    public Produto salvar(Produto produto) {
        return produtoRepository.save(produto);
    }

    public void deletar(Integer codigo) {
        produtoRepository.deleteById(codigo);
    }

    public List<Produto> buscarPorNome(String nome) {
        return produtoRepository.findByNomeContainingIgnoreCase(nome);
    }

    public List<Produto> produtosComValidadeProxima(Date dataLimite) {
        return produtoRepository.findProdutosComValidadeProxima(dataLimite);
    }

    public List<Produto> buscarPorQuantidadeMinima(Integer quantidadeMinima) {
        return produtoRepository.findByQuantidadeLessThan(quantidadeMinima);
    }

    public List<Produto> buscarPorFaixaDePreco(BigDecimal precoMinimo, BigDecimal precoMaximo) {
        return produtoRepository.findByPrecoBetween(precoMinimo, precoMaximo);
    }
}

