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

    //Handler Exception no Service | API
    //Exceção de acordo com contexto
    @Autowired
    private PessoaRepository pessoaRepository;

    public List<Pessoa> listarPessoas(){
        return pessoaRepository.findAll();    }

    //Optopnal check whether a variable has null value or not.
    public Pessoa buscarPessoa(Long pessoaId){
        try{
            Optional <Pessoa> op = pessoaRepository.findById(pessoaId);
            return op.get();
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public Pessoa inserirPessoa(PessoaDTO pessoaDTO) {
        Pessoa p = convertePessoaDTO(pessoaDTO);
        return pessoaRepository.save(p);
    }

    public Pessoa atualizarPessoa(PessoaDTO pessoaDTO) {
        Pessoa p = buscarPessoa(pessoaDTO.getId());
        return pessoaRepository.save(convertePessoaDTO(pessoaDTO));
    }

    private Pessoa convertePessoaDTO(PessoaDTO pessoaDTO) {
        Pessoa p = new Pessoa();
        p.setId(pessoaDTO.getId());
        p.setEmail(pessoaDTO.getEmail());
        p.setFirsName(pessoaDTO.getFirsName());
        p.setLastName(pessoaDTO.getLastName());
        return p;
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
