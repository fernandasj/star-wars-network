package com.phoebus.teste.starwarsnetwork.service;

import com.phoebus.teste.starwarsnetwork.domain.Item;
import com.phoebus.teste.starwarsnetwork.exception.NegocioException;
import com.phoebus.teste.starwarsnetwork.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    public Item salvar(Item item){
        Optional<Item> itemExistente = itemRepository.findById(item.getIdItem());

        if(itemExistente != null && itemExistente.equals(item)){
            throw new NegocioException("Este item ja foi cadastrado");
        }
        return itemRepository.save(item);
    }
}
