package com.phoebus.teste.starwarsnetwork.service;

import com.phoebus.teste.starwarsnetwork.domain.Localizacao;
import com.phoebus.teste.starwarsnetwork.exception.NegocioException;
import com.phoebus.teste.starwarsnetwork.repository.LocalizacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LocalizacaoService {

    @Autowired
    LocalizacaoRepository localizacaoRepository;

    public Localizacao salvar(Localizacao localizacao){
        Optional<Localizacao> localizacaoExistente = localizacaoRepository.findById(localizacao.getIdLocalizacao());

        if(localizacaoExistente != null && localizacaoExistente.equals(localizacao)){
            throw new NegocioException("Esta localizaçao ja foi cadastrada");
        }
        return localizacaoRepository.save(localizacao);
    }
}
