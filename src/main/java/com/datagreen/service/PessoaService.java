package com.datagreen.service;

import com.datagreen.dto.PessoaDTO;
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

    public List<Pessoa> listarPessoas(){
        return pessoaRepository.findAll();    }


    public Pessoa buscarPessoa(Long pessoaId){
         Optional <Pessoa> op = pessoaRepository.findById(pessoaId);
         return op.get();
    }

    public Pessoa inserirPessoa(PessoaDTO pessoaDTO){
        Pessoa p  = new Pessoa();
        p.setEmail(pessoaDTO.getEmail());
        p.setFirsName(pessoaDTO.getFirsName());
        p.setLastName(pessoaDTO.getLastName());

        return pessoaRepository.save(p);
        //converte para a entidade de modelo do banco
    }

    public Pessoa atualizarPessoa(PessoaDTO pessoaDTO){
        Pessoa p  = new Pessoa();
        p.setEmail(pessoaDTO.getEmail());
        p.setFirsName(pessoaDTO.getFirsName());
        p.setLastName(pessoaDTO.getLastName());
        p.setId(pessoaDTO.getId());

        return pessoaRepository.save(p);
    }

    public void deletaPessoa(Long pessoaId) throws Exception {
        Optional <Pessoa> op = pessoaRepository.findById(pessoaId);
        //Optional notNull
        if(op.isPresent()){
            pessoaRepository.deleteById(pessoaId);
        }else{
            throw new Exception();
        };
    }

}
