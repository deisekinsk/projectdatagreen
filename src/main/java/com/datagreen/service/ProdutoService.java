package com.datagreen.service;

import com.datagreen.model.Produto;
import com.datagreen.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public Produto buscarProduto(Long idProduto){
        Optional<Produto> prod = produtoRepository.findById(idProduto);
        return  prod.get();
    }

}
