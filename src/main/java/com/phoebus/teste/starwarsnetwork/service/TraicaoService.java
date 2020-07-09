package com.phoebus.teste.starwarsnetwork.service;

import com.phoebus.teste.starwarsnetwork.domain.Rebelde;
import com.phoebus.teste.starwarsnetwork.domain.Traicao;
import com.phoebus.teste.starwarsnetwork.exception.EntidadeNaoEncontradaException;
import com.phoebus.teste.starwarsnetwork.exception.NegocioException;
import com.phoebus.teste.starwarsnetwork.repository.TraicaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TraicaoService {

    @Autowired
    private TraicaoRepository traicaoRepository;

    @Autowired
    private RebeldeService rebeldeService;

    public Traicao salvar(Traicao traicao){

        Optional<Traicao> traicaoExistente = traicaoRepository.findById(traicao.getIdTraicao());

        if (traicaoExistente.isPresent() && traicaoExistente.equals(traicao)){
            throw new NegocioException("Esta traicao ja foi cadastrada");
        }
        Traicao novaTraicao = traicaoRepository.save(traicao);
        rebeldeService.marcarTraidor(novaTraicao.getRebeldeTraidor().getIdRebelde());
        return novaTraicao;
    }

    public List<Traicao> listarTraicoes(Long rebeldeTraidor){

        List<Traicao> traicoes = traicaoRepository.findByRebeldeTraidor(rebeldeTraidor);
        if (traicoes.isEmpty()){
            throw new EntidadeNaoEncontradaException("Nao foram encontradas traicoes para o rebelde informado");
        }

        return traicoes;
    }
}
