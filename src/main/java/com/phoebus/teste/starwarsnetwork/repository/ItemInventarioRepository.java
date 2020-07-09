package com.phoebus.teste.starwarsnetwork.repository;

import com.phoebus.teste.starwarsnetwork.domain.ItemInventario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemInventarioRepository extends JpaRepository<ItemInventario, Long> {
}
