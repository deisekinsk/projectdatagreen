package com.datagreen.controller;

import com.datagreen.dto.PessoaDTO;
import com.datagreen.model.Pessoa;
import com.datagreen.service.PessoaService;
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
    public ResponseEntity<Pessoa> buscarPessoa(@RequestParam Long idPessoa){
        try{
            return new ResponseEntity<Pessoa>(pessoaService.buscarPessoa(idPessoa),HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/list")
    public ResponseEntity<List<Pessoa>> listarPessoa(){
        try{
            return new ResponseEntity<List<Pessoa>>(pessoaService.listarPessoas(),
                    HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping
    public ResponseEntity<Pessoa> inserirPessoa(@RequestBody PessoaDTO pessoaDTO){
        try{
            return new ResponseEntity<Pessoa>(pessoaService.inserirPessoa(pessoaDTO),HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    //atualiza apenas os campos não nulos
    @PutMapping("/{pessoaId}")
    public ResponseEntity<Pessoa> atualizarPessoa(@PathVariable Long pessoaId,
                                                  @RequestBody PessoaDTO pessoaDTO){
        try{
            return new ResponseEntity<Pessoa>(pessoaService.atualizarPessoa(pessoaId,
                    pessoaDTO),
                    HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping
    public ResponseEntity<HttpStatus> deletarPessoa(@RequestParam Long pessoaId){

        try {
            pessoaService.deletaPessoa(pessoaId);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }
}
