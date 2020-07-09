package com.phoebus.teste.starwarsnetwork.controller;

import com.phoebus.teste.starwarsnetwork.domain.ItemInventario;
import com.phoebus.teste.starwarsnetwork.domain.Rebelde;
import com.phoebus.teste.starwarsnetwork.repository.ItemInventarioRepository;
import com.phoebus.teste.starwarsnetwork.service.ItemInventarioService;
import com.phoebus.teste.starwarsnetwork.service.RebeldeService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/inventario")
public class ItemInventarioController {

    @Autowired
    private ItemInventarioService itemInventarioService;

    @Autowired
    private RebeldeService rebeldeService;

    @Autowired
    private ItemInventarioRepository itemInventarioRepository;

    @GetMapping
    @ApiOperation(value = "Listar todo os ItemInventario cadastrados")
    public List<ItemInventario> listarItensInventario(){
        return itemInventarioRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ItemInventario adicionarItemInventario(@Valid @RequestBody ItemInventario itemInventario){
        return itemInventarioService.salvar(itemInventario);
    }

    @PutMapping("/{idItemInventario}")
    public ResponseEntity<ItemInventario> atualizarQuantidadeItemInventario(@PathVariable Long idItemInventario,
                                                                            @RequestBody Integer novaQuantidade){

        Optional<ItemInventario> itemInventarioExistente = itemInventarioRepository.findById(idItemInventario);
        if (itemInventarioExistente.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        ItemInventario itemInventario = itemInventarioExistente.get();
        itemInventario.setQuantidade(novaQuantidade);
        itemInventarioService.salvar(itemInventario);
        return ResponseEntity.ok(itemInventario);

    }

//    @PutMapping
//    public ResponseEntity<ItemInventario> trocarItens(@RequestBody ItemInventario itemTroca, @RequestBody ItemInventario itemDesejado){
//        Rebelde rebeldeNegociador = rebeldeService.buscarPeloId(itemTroca.getRebelde().getIdRebelde());
//        Rebelde rebelde = rebeldeService.buscarPeloId(itemDesejado.getRebelde().getIdRebelde());
//
//        if (rebeldeNegociador.getTraidor() == Boolean.FALSE && rebelde.getTraidor() == Boolean.FALSE){
//            System.out.println("leais");
//            if (itemTroca.getItem().getPontos() == itemDesejado.getItem().getPontos()){
//                System.out.println("troca");
//                itemDesejado.setRebelde(rebeldeNegociador);
//                itemTroca.setRebelde(rebelde);
//                itemInventarioService.salvar(itemDesejado);
//                itemInventarioService.salvar(itemTroca);
//                return ResponseEntity.ok(itemDesejado);
//            }
//        }
//        return ResponseEntity.notFound().build();
//    }
}
