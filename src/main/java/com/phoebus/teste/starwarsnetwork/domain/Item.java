package com.phoebus.teste.starwarsnetwork.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Builder
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Item {

    @Id
    @GeneratedValue
    private Long idItem;
    private String descricao;
    private Integer pontos;

    public Item(String descricao, Integer pontos) {
        this.descricao = descricao;
        this.pontos = pontos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return idItem.equals(item.idItem) &&
                descricao.equals(item.descricao) &&
                pontos.equals(item.pontos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idItem, descricao, pontos);
    }

    @Override
    public String toString() {
        return "Item{" +
                "idItem=" + idItem +
                ", descricao='" + descricao + '\'' +
                ", pontos=" + pontos +
                '}';
    }
}
