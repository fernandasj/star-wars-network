package com.phoebus.teste.starwarsnetwork.repository;

import com.phoebus.teste.starwarsnetwork.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
}
