package com.phoebus.teste.starwarsnetwork.repository;

import com.phoebus.teste.starwarsnetwork.domain.Traicao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TraicaoRepository extends JpaRepository<Traicao, Long> {

    Optional<Traicao> findByRebeldeTraido(Long rebeldeTraidor);

    Long countByRebeldeTraidor(Long idRebelde);
}
