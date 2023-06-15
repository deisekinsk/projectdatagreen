package com.datagreen.controller;

import com.datagreen.model.Pessoa;
import com.datagreen.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @GetMapping
    public Pessoa buscarPessoa(@RequestParam Long idPessoa){
        return pessoaService.buscarPessoa(idPessoa);

    }

    @GetMapping("/list")
    public List listarPessoa(){
        return pessoaService.listarPessoas();
    }

    @PostMapping
    public String inserirPessoa(){
        return "inserir";
    }

    @PutMapping
    public String atualizarPessoa(){
        return "atualizar";
    }

    @DeleteMapping
    public String deletarPessoa(){
        return "delete";
    }



}
