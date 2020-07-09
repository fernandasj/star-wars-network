package com.phoebus.teste.starwarsnetwork.controller;

import com.phoebus.teste.starwarsnetwork.domain.Traicao;
import com.phoebus.teste.starwarsnetwork.service.TraicaoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/traicoes")
@Api(tags = "Gerenciamento de traiçoes")
public class TraicaoController {

    @Autowired
    private TraicaoService traicaoService;

    @GetMapping("/{rebeldeTraidor}")
    @ApiOperation(value = "Listar todas as traiçoes cadastradas para um(a) determinado(a) rebelde")
    public ResponseEntity<Traicao> listarTraicoesPorRebelde(
            @PathVariable @ApiParam("Numero de identificaçao do(a) rebelde") Long rebeldeTraidor){

        List<Traicao> traicoes = traicaoService.listarTraicoes(rebeldeTraidor);
        if (!traicoes.isEmpty()){
            return ResponseEntity.ok(traicoes.get(0));
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation("Adicionar uma nova traiçao")
    public Traicao adicionarTraicao(@Valid @RequestBody Traicao traicao) {
        return traicaoService.salvar(traicao);
    }
}
