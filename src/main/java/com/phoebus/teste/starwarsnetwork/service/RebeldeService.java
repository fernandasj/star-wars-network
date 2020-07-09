package com.phoebus.teste.starwarsnetwork.service;

import com.phoebus.teste.starwarsnetwork.domain.Item;
import com.phoebus.teste.starwarsnetwork.domain.ItemInventario;
import com.phoebus.teste.starwarsnetwork.domain.Rebelde;
import com.phoebus.teste.starwarsnetwork.exception.EntidadeNaoEncontradaException;
import com.phoebus.teste.starwarsnetwork.exception.NegocioException;
import com.phoebus.teste.starwarsnetwork.repository.RebeldeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RebeldeService {

    @Autowired
    private RebeldeRepository rebeldeRepository;

    @Autowired
    private ItemInventarioService itemInventarioService;

    public Rebelde salvar(Rebelde rebelde){
        System.out.println(rebelde.toString());
        Optional<Rebelde> rebeldeExistente = rebeldeRepository.findByNome(rebelde.getNome());

        if(rebeldeExistente.isPresent() && rebeldeExistente.equals(rebelde)){
            throw new NegocioException("Ja existe um rebelde cadastrado com este nome");
        }

        List<ItemInventario> inventario = new ArrayList<>();
        for (ItemInventario item : rebelde.getInventario()) {
            System.out.println(item.toString());
            inventario.add(itemInventarioService.salvar(item));
        }
        System.out.println(rebeldeRepository.save(rebelde).toString());
        rebelde.setInventario(inventario);
        return rebeldeRepository.save(rebelde);
    }

    public Optional<Rebelde> buscarPeloNome(String nome){
        Optional<Rebelde> rebelde = rebeldeRepository.findByNome(nome);
        if(rebelde == null){
            throw new EntidadeNaoEncontradaException("Rebelde nao encontrado(a)");
        }
        return rebelde;
    }

    public Rebelde buscarPeloId(Long rebeldeId) {
        return rebeldeRepository.findById(rebeldeId)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Rebelde nao encontrado(a)"));
    }

    public Rebelde marcarTraidor(Long idRebelde){
        Rebelde rebelde = buscarPeloId(idRebelde);
        rebelde.setTraidor(Boolean.TRUE);
        return salvar(rebelde);
    }
}
