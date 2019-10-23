package com.exercicio.grupo.app.apresentacao.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClienteModel {

    private Long id;
    private String nome;
    private int idade;
    private String telefone;
    private PaisModel pais;

}
