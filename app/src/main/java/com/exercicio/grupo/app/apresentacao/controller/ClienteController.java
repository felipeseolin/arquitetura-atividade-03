package com.exercicio.grupo.app.apresentacao.controller;

import com.exercicio.grupo.app.apresentacao.model.ClienteModel;
import com.exercicio.grupo.app.apresentacao.model.PaisModel;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ClienteController {

    private List<ClienteModel> clientes;
    private List<PaisModel> paises;

    public ClienteController() {
        var paisController = new PaisController();
        paises = paisController.listaPaises();

        clientes = Stream.of(
                ClienteModel.builder().id(1L).nome("Fulano").idade(12).telefone("123456").limiteCredito("50.25").pais(paises.get(0)).build(),
                ClienteModel.builder().id(2L).nome("Ciclano").idade(35).telefone("123456").limiteCredito("12.25").pais(paises.get(0)).build(),
                ClienteModel.builder().id(3L).nome("Cipriano").idade(13).telefone("123456").limiteCredito("12.25").pais(paises.get(0)).build()
        ).collect(Collectors.toList());
    }

    @GetMapping("/cliente")
    public String listar(Model memoria) {

        memoria.addAttribute("listaClientes", clientes);
        memoria.addAttribute("listaPaises", paises);

        return "cliente-view";
    }

    @PostMapping("/cliente/criar")
    public String criar(ClienteModel cliente, @RequestParam("paisId") String paisId) {

        cliente.setId(new Long(clientes.size() + 1));
        Long id = Long.parseLong(paisId);
        var paisController = new PaisController();
        cliente.setPais(paisController.buscaPaisPeloId(id));

        clientes.add(cliente);

        return "redirect:/cliente";
    }
}
