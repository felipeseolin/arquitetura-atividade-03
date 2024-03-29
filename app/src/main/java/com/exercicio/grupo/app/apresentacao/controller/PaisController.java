package com.exercicio.grupo.app.apresentacao.controller;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.exercicio.grupo.app.apresentacao.model.PaisModel;

import java.util.stream.Stream;

@Controller
public class PaisController {
    private List<PaisModel> paises;

    public PaisController() {
        paises = Stream.of(
                PaisModel.builder().id(1L).nome("Brasil").sigla("BR").build(),
                PaisModel.builder().id(2L).nome("China").sigla("CH").build(),
                PaisModel.builder().id(3L).nome("India").sigla("IN").build()
        ).collect(Collectors.toList());
    }

    @GetMapping("/pais")
    public String listar(Model memoria) {

        memoria.addAttribute("listaPaises", paises);

        return "pais-view";
    }

    @PostMapping("/pais/criar")
    public String criar(PaisModel pais) {

        pais.setId(new Long(paises.size() + 1));

        paises.add(pais);

        return "redirect:/pais";
    }

    @GetMapping("/pais/apagar/{id}")
    public String apagar(@PathVariable Long id) {

        var pais = buscaPaisPeloId(id);

        paises.remove(pais);

        return "redirect:/pais";
    }

    @GetMapping("/pais/preparaAlterar/{id}")
    public String preparaAlterar (@PathVariable Long id, Model memoria) {

        var paisAtual = buscaPaisPeloId(id);

        memoria.addAttribute("paisAtual", paisAtual);
        memoria.addAttribute("listaPaises", paises);

        return "pais-view";
    }

    @PostMapping("/pais/alterar")
    public String alterar(PaisModel pais) {

        var paisAtual = buscaPaisPeloId(pais.getId());

        paisAtual.setNome(pais.getNome());
        paisAtual.setSigla(pais.getSigla());

        return "redirect:/pais";
    }

    public PaisModel buscaPaisPeloId (Long id) {
        return paises.stream()
                .filter(p -> p.getId().equals(id))
                .findAny()
                .orElseThrow(IllegalArgumentException::new);
    }

    public List<PaisModel> listaPaises() {
        return paises;
    }
}
