package com.datagreen;

import com.datagreen.controller.PessoaController;
import com.datagreen.model.Pessoa;
import com.datagreen.repository.PessoaRepository;
import com.datagreen.service.PessoaService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PessoaTest {

    private static PessoaController pessoaController;
    private static PessoaService pessoaService;

    @BeforeAll
    static void setUp() {
        // Criando ium mock
        PessoaRepository pessoaRepositoryMock = Mockito.mock(PessoaRepository.class);

        // Crie uma lista de pessoas para retornar quando o método findAll() for chamado no mock
        List<Pessoa> listaDePessoas = new ArrayList<>();

        // mock para não acessar BD diretamente
        Mockito.when(pessoaRepositoryMock.findAll()).thenReturn(listaDePessoas);

        // injeDepemock: PessoaRepository no PessoaService
        pessoaService = new PessoaService(pessoaRepositoryMock);

        // injDepe: PessoaService no PessoaController
        pessoaController = new PessoaController(pessoaService);
    }

    @Test
    void testListarPessoa() {
        ResponseEntity<List<Pessoa>> responseEntity = pessoaController.listarPessoa();
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());

        //List<Pessoa> pessoas = responseEntity.getBody();
        //assertTrue(pessoas != null);
    }
}
