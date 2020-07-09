package com.phoebus.teste.starwarsnetwork.repository;

import com.phoebus.teste.starwarsnetwork.domain.Traicao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TraicaoRepository extends JpaRepository<Traicao, Long> {

    List<Traicao> findByRebeldeTraidor(Long rebeldeTraidor);

    Long countByRebeldeTraidor(Long idRebelde);
}
