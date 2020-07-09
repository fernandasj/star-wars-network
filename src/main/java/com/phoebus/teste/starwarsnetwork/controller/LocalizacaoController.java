package com.phoebus.teste.starwarsnetwork.controller;

import com.phoebus.teste.starwarsnetwork.domain.Localizacao;
import com.phoebus.teste.starwarsnetwork.repository.LocalizacaoRepository;
import com.phoebus.teste.starwarsnetwork.service.LocalizacaoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/localizacoes")
@Api(tags = "Gerenciamento de localizaçoes")
public class LocalizacaoController {

    @Autowired
    private LocalizacaoService localizacaoService;

    @Autowired
    private LocalizacaoRepository localizacaoRepository;

    @GetMapping
    @ApiOperation(value = "Listar todas as localizaçoes cadastradas")
    public List<Localizacao> listarLocalizacoes(){
        return localizacaoRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Adicionar uma nova localizaçao")
    public Localizacao adicionarLocalizacao(@Valid @RequestBody Localizacao localizacao){
        return localizacaoService.salvar(localizacao);
    }
}
