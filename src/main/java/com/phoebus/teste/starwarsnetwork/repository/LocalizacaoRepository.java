package com.phoebus.teste.starwarsnetwork.repository;

import com.phoebus.teste.starwarsnetwork.domain.Localizacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocalizacaoRepository extends JpaRepository<Localizacao, Long> {
}
