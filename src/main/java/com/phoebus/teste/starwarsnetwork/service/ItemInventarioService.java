package com.phoebus.teste.starwarsnetwork.service;

import com.phoebus.teste.starwarsnetwork.domain.ItemInventario;
import com.phoebus.teste.starwarsnetwork.repository.ItemInventarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemInventarioService {

    @Autowired
    private ItemInventarioRepository itemInventarioRepository;

    public ItemInventario salvar(ItemInventario itemInventario){
        return itemInventarioRepository.save(itemInventario);
    }

    public void excluir(Long idItemInventario){
        itemInventarioRepository.deleteById(idItemInventario);
    }
}
