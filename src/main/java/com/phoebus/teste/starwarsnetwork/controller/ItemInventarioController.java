package com.phoebus.teste.starwarsnetwork.controller;

import com.phoebus.teste.starwarsnetwork.domain.ItemInventario;
import com.phoebus.teste.starwarsnetwork.repository.ItemInventarioRepository;
import com.phoebus.teste.starwarsnetwork.service.ItemInventarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/inventario")
public class ItemInventarioController {

    @Autowired
    private ItemInventarioService itemInventarioService;

    @Autowired
    private ItemInventarioRepository itemInventarioRepository;

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
}
