package com.datagreen.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
//não retorna vazio jackson
public class PessoaDTO {

    private Long id;
    private String firsName;
    private String lastName;
    private String email;


}
