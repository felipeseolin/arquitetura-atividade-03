package com.exercicio.grupo.app.apresentacao.controller;

import com.exercicio.grupo.app.apresentacao.model.ClienteModel;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ClienteController {

    private List<ClienteModel> clientes;

    public ClienteController() {
        clientes = Stream.of(
                ClienteModel.builder().id(1L).nome("Fulano").idade(12).telefone("123456").build(),
                ClienteModel.builder().id(2L).nome("Ciclano").idade(35).telefone("123456").build(),
                ClienteModel.builder().id(3L).nome("Cipriano").idade(13).telefone("123456").build()
        ).collect(Collectors.toList());
    }
}
