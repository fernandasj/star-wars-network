package com.phoebus.teste.starwarsnetwork.service;

import com.phoebus.teste.starwarsnetwork.domain.ItemInventario;
import com.phoebus.teste.starwarsnetwork.domain.Rebelde;
import com.phoebus.teste.starwarsnetwork.exception.EntidadeNaoEncontradaException;;
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
        Rebelde novoRebelde = rebeldeRepository.save(rebelde);

        List<ItemInventario> inventario = new ArrayList<>();
        for (ItemInventario item : rebelde.getInventario()) {
            item.setRebelde(novoRebelde);
            inventario.add(item);
        }
        novoRebelde.setInventario(inventario);
        return rebeldeRepository.save(novoRebelde);
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

    public void marcarTraidor(Long idRebelde){
        Rebelde rebelde = buscarPeloId(idRebelde);
        if ((rebelde.getTraicoes().size()) >= 3){
            rebelde.setTraidor(Boolean.TRUE);
        }
        salvar(rebelde);
    }
}
