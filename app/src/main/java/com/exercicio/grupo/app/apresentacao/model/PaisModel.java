package com.exercicio.grupo.app.apresentacao.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PaisModel {

    private Long id;
    private String nome;
    private String sigla;
}
