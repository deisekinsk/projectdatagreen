package com.datagreen.service;

import com.datagreen.model.Produto;
import com.datagreen.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public Produto buscarProduto(Long produtoId){
        Optional<Produto> prod = produtoRepository.findById(produtoId);
        return  prod.get();
    }

    public List<Produto> listarProduto(){
        return  produtoRepository.findAll();
    }

}
