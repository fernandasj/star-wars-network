package com.phoebus.teste.starwarsnetwork.controller;

import com.phoebus.teste.starwarsnetwork.domain.Item;
import com.phoebus.teste.starwarsnetwork.repository.ItemRepository;
import com.phoebus.teste.starwarsnetwork.service.ItemService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/itens")
@Api(tags = "Gerenciamento de Itens")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @Autowired
    private ItemRepository itemRepository;

    @GetMapping
    @ApiOperation(value = "Listar todos os itens cadastrados")
    public List<Item> listarItens(){
        return itemRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Adicionar um novo item")
    public Item adicionarItem(@Valid @RequestBody Item item){
        return itemService.salvar(item);
    }

}
