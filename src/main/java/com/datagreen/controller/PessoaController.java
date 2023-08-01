package com.datagreen.controller;

import com.datagreen.dto.PessoaDTO;
import com.datagreen.model.Pessoa;
import com.datagreen.service.PessoaService;
import com.datagreen.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @GetMapping
    public ResponseEntity<Pessoa> buscarPessoa(@RequestParam Long pessoaId){
            return new ResponseEntity<Pessoa>(pessoaService.buscarPessoa(pessoaId),HttpStatus.OK);
    }

    @GetMapping("/list")
    public ResponseEntity<List<Pessoa>> listarPessoa(){
            return new ResponseEntity<List<Pessoa>>(pessoaService.listarPessoas(),
                    HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Pessoa> inserirPessoa(@RequestBody PessoaDTO pessoaDTO){
            return new ResponseEntity<Pessoa>(pessoaService.inserirPessoa(pessoaDTO),HttpStatus.OK);
    }

    //atualiza apenas os campos não nulos
    @PutMapping
    public ResponseEntity<Pessoa> atualizarPessoa(@RequestBody PessoaDTO pessoaDTO){
            return new ResponseEntity<Pessoa>(pessoaService.atualizarPessoa(pessoaDTO),
                    HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<HttpStatus> deletarPessoa(@RequestParam Long pessoaId)
            throws Exception {
//        try {
//            pessoaService.deletaPessoa(pessoaId);
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//        return new ResponseEntity<>(HttpStatus.OK);
        if(pessoaId!=null){
            pessoaService.deletaPessoa(pessoaId);
            return new ResponseEntity<>(HttpStatus.OK);
        }throw new NotFoundException("Test");
    }
}
