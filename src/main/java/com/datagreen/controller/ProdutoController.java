package com.datagreen.controller;

import com.datagreen.dto.ProdutoDTO;
import com.datagreen.model.Produto;
import com.datagreen.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public ResponseEntity<Produto> buscarProduto(@RequestParam Long produtoId){
            return new ResponseEntity<Produto>(produtoService.buscarProduto(produtoId),
                    HttpStatus.OK);
    }

    @GetMapping("/list")
    public ResponseEntity<List<Produto>> listarProduto(){
            return new ResponseEntity<List<Produto>>(produtoService.listarProduto(),
                    HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Produto> inserirProduto(@RequestBody ProdutoDTO produtoDTO){
        return new ResponseEntity<Produto>(produtoService.inserirProduto(produtoDTO),
                HttpStatus.OK);
    }

}