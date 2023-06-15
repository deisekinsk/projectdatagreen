package com.datagreen.service;

import com.datagreen.model.Pessoa;
import com.datagreen.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    public List listarPessoas(){
        return pessoaRepository.findAll();    }


    public Pessoa buscarPessoa(Long pessoaId){
         Optional <Pessoa> op = pessoaRepository.findById(pessoaId);
         return op.get();
    }

}
