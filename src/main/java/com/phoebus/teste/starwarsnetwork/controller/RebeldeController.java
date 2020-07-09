package com.phoebus.teste.starwarsnetwork.controller;

import com.phoebus.teste.starwarsnetwork.domain.Localizacao;
import com.phoebus.teste.starwarsnetwork.domain.Rebelde;
import com.phoebus.teste.starwarsnetwork.repository.RebeldeRepository;
import com.phoebus.teste.starwarsnetwork.service.ItemInventarioService;
import com.phoebus.teste.starwarsnetwork.service.RebeldeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/rebeldes")
@Api(tags = "Gerenciamneto de Rebeldes")
public class RebeldeController {

    @Autowired
    private RebeldeService rebeldeService;

    @Autowired
    private ItemInventarioService itemInventarioService;

    @Autowired
    private RebeldeRepository rebeldeRepository;

    @GetMapping
    @ApiOperation(value = "Listar todo os rebeldes cadastrados")
    public List<Rebelde> listarRebeldes(){
        return rebeldeRepository.findAll();
    }

    @GetMapping("/{nomeRebelde}")
    @ApiOperation(value = "Buscar um rebelde pelo seu nome")
    public ResponseEntity<Rebelde> bucarRebeldePeloNome(
            @PathVariable @ApiParam("Nome do rebelde que se deseja buscar") String nomeRebelde){

        Optional<Rebelde> rebelde = rebeldeService.buscarPeloNome(nomeRebelde);
        if (rebelde.isPresent()){
            return ResponseEntity.ok(rebelde.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Adicionar um(a) novo(a) rebelde")
    public Rebelde adicionarRebelde(@Valid @RequestBody Rebelde rebelde){
        return rebeldeService.salvar(rebelde);
    }

    @PutMapping("/{rebeldeId}")
    @ApiOperation(value = "Atualizar a localizaçao de um(a) rebelde")
    public ResponseEntity<Rebelde> atualizarLocalizacaoRebelde(
            @PathVariable @ApiParam("Numero de identificaçao do(a) rebelde a receber atualizaçao ") Long rebeldeId,
            @RequestBody @ApiParam("Localizaçao a ser atualizada") Localizacao localizacao){

        Optional<Rebelde> rebeldeExistente = rebeldeRepository.findById(rebeldeId);

        if (rebeldeExistente.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        Rebelde rebelde = rebeldeExistente.get();
        rebelde.setLocalizacao(localizacao);
        rebeldeService.salvar(rebelde);
        return ResponseEntity.ok(rebelde);

    }
}
